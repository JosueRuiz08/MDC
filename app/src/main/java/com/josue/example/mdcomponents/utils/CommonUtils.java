package com.josue.example.mdcomponents.utils;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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

            //Static
        }
        return fragment;
    }
}