package com.josue.example.mdcomponents.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.josue.example.mdcomponents.Fragments.ButtonFragment;
import com.josue.example.mdcomponents.Fragments.BottomNavigationBarFragment;

public class CommonUtils {

    public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRes){
        Fragment fragment = getFragmentById(nameFragment);
        activity.getSupportFragmentManager().beginTransaction()
                .add(contentRes,fragment).commit();
    }

    private static Fragment getFragmentById(String nameFragment) {
        Fragment fragment = null;
        switch (nameFragment){
            //Scroll
            case ButtonFragment.TAG:
                fragment = new ButtonFragment();
                break;
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;
            //Static
        }
        return fragment;
    }
}
