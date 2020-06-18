package com.android.MakeYouStudy;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Tab_pager_Adapter extends FragmentStatePagerAdapter {
    private int tabCount;

    public Tab_pager_Adapter(FragmentManager fm,int tabCount) {
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DiaryActivity.Diary_Write diaryWrite = new DiaryActivity.Diary_Write();
                return diaryWrite;
            case 1:
                DiaryActivity.Diary_List diaryList = new DiaryActivity.Diary_List();
                return diaryList;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}