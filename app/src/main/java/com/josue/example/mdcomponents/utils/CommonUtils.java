package com.josue.example.mdcomponents.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.josue.example.mdcomponents.Fragments.ButtonFragment;
import com.josue.example.mdcomponents.Fragments.BottomNavigationBarFragment;
import com.josue.example.mdcomponents.Fragments.SnackBarFragment;

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
            //Static
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;
            case SnackBarFragment.TAG:
                fragment = new SnackBarFragment();
                break;
        }
        return fragment;
    }
}
