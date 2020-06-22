package com.android.MakeYouStudy;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class AlarmService extends Service {

    private MediaPlayer mediaPlayer;
    private Vibrator vibrator;
    private boolean isRunning;
    private int pausePosition; // mediaPlayer pause 시점 저장

    @Nullable
    @Override
    public IBinder onBind(Intent intent) { return null; }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        String state = intent.getStringExtra("state");
        int reqCode = intent.getIntExtra("reqCode", -1);
        int weeks = intent.getIntExtra("weekday", -1);
        Log.d("AlarmService", "AlarmService로 넘어온 state값" + state);
        Log.d("AlarmService", "에서 받은 reqCode : " + reqCode);

        if (state.equals("on")) {
            // 알람음 재생 OFF, 알람음 시작 상태
            this.mediaPlayer = MediaPlayer.create(this, R.raw.alarm);
            this.mediaPlayer.start();
            // 진동 재생
            this.vibrator.vibrate(new long[]{500, 1000, 500, 1000}, 0);

            this.isRunning = true;

//            PendingIntent pendingIntent = PendingIntent.getActivity(
//                    this, 0, new Intent(getApplicationContext(), AttendanceCheckActivity.class),
//                    PendingIntent.FLAG_UPDATE_CURRENT
//            );

            // notification 클릭시에도 AttendanceCheckActivity를 실행할 수 있도록 함
            Intent intent1 = new Intent(getApplicationContext(), AttendanceCheckActivity.class);
            intent1.putExtra("reqCode", reqCode);
            intent1.putExtra("weekday", weeks);
            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent1, PendingIntent.FLAG_CANCEL_CURRENT);

            // Foreground 에서 실행되면 Notification 을 보여줘야 됨
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // Oreo(26) 버전 이후 버전부터는 channel 이 필요함
                String channelId =  createNotificationChannel();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId);
                Notification notification = builder.setOngoing(true)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pendingIntent) // display overlay permission을 허용하지 않았을 때를 대비
                        //.setCategory(Notification.CATEGORY_SERVICE)
                        .build();

                startForeground(1, notification);
            }
            Log.d("AlarmService", "Alarm Start");

        } else if (this.isRunning && state.equals("off")) {
            // 알람음 재생 ON, 알람음 중지 상태
            this.mediaPlayer.stop();
            this.mediaPlayer.reset();
            this.mediaPlayer.release();
            this.vibrator.cancel();

            this.isRunning = false;

            Log.d("AlarmService", "Alarm Stop");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                stopForeground(true);
            }
        } else if (state.equals("pause")){
            // AttendanceCheck시에 음악 일시 정지
            if(mediaPlayer!=null){
                this.mediaPlayer.pause();
                pausePosition = mediaPlayer.getCurrentPosition();
                this.vibrator.cancel();
            }
        } else if (state.equals("restart")){
            if(!mediaPlayer.isPlaying()){
                mediaPlayer.seekTo(pausePosition);
                mediaPlayer.start();
                this.vibrator.vibrate(new long[]{500, 1000, 500, 1000}, 0);
            }
        }
        return START_NOT_STICKY;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private String createNotificationChannel() {
        String channelId = "Alarm";
        String channelName = getString(R.string.app_name);
        String description = getString(R.string.channel_description);

        NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_NONE);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        channel.setDescription("안녕하세요");
        channel.setSound(null, null);
        channel.setShowBadge(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        manager.createNotificationChannel(channel);

        return channelId;
    }
}
