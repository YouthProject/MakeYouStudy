package com.android.MakeYouStudy;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver {
    static String TAG="AlarmReceiver";

    // PowerManger.WakeLock object
    private static PowerManager.WakeLock sCpuWakeLock;
    private static ConnectivityManager manger;

    @Override
    public void onReceive(Context context, Intent intent) {

        int nweeks = doDayOfWeek();

        int weeks = intent.getIntExtra("weekday", -1);
        int reqCode = intent.getIntExtra("reqCode", -1);
        String state = intent.getStringExtra("state");
        Log.d(TAG,"설정 요일 : " + weeks);
        Log.d(TAG, "실제 요일 : " + nweeks);
        Log.d("reqTest", "리시버가 받은 reqcode" + reqCode);

        Intent sIntent = new Intent(context, AlarmService.class);

        if(state.equals("off")){ // 삭제 버튼을 클릭했을 때
            // Log 확인용
            Log.d("off button", "off button 클릭");
            sIntent.putExtra("state", "off");
            sIntent.putExtra("reqCode", reqCode);
            // Oreo(26) 버전 이후부터는 Background 에서 실행을 금지하기 때문에 Foreground 에서 실행해야 함
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(sIntent);
            } else {
                context.startService(sIntent);
            }
            return;
        }
        else if(weeks != nweeks){ // 오늘이 설정한 요일이 아닐 때
            // Log 확인용
            Log.d("not days", "체크한 요일이 아닙니다.");
            Toast.makeText(context, "체크한 요일이 아닙니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(weeks == nweeks) { // 오늘이 설정한 요일 일 때
            sIntent.putExtra("state", "on");
            sIntent.putExtra("weekday", weeks);
            // Oreo(26) 버전 이후부터는 Background 에서 실행을 금지하기 때문에 Foreground 에서 실행해야 함
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(sIntent);
            } else {
                context.startService(sIntent);
            }

            // 절전모드에서도 액티비티를 띄울 수 있도록 함
            PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            sCpuWakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.ON_AFTER_RELEASE, "app:alarm");
            // acquire 함수를 실행하여 앱을 깨운다. (CPU를 획득함)
            sCpuWakeLock.acquire();
            manger = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            try {
                Intent intent2 = new Intent(context, AttendanceCheckActivity.class);
                intent2.putExtra("reqCode", reqCode);
                intent2.putExtra("weekday", weeks);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
                pendingIntent.send();
                Log.d(TAG, "Activity 실행");
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
                Log.d(TAG, "Activity 실행 오류");
            }

            // acquire 함수를 사용하였으면 꼭 release를 해주어야 한다.
            // cpu를 점유하게 되어 배터리 소모나 메모리 소모에 영향을 미칠 수 있다.
            if (sCpuWakeLock != null) {
                sCpuWakeLock.release();
                sCpuWakeLock = null;
            }

            Toast.makeText(context, "알람~!!", Toast.LENGTH_SHORT).show();
            Log.e("Alarm","알람입니다.");
        }
    }

    // TimeTable의 days와 Cal.Day_OF_WEEK 양식을 맞춰준다.
    private int doDayOfWeek(){
        Calendar cal = Calendar.getInstance();
        int nWeek = cal.get(Calendar.DAY_OF_WEEK);
        if(nWeek==1){
            nWeek = 6;
        }else{
            nWeek -= 2;
        }
        return nWeek;
    }
}