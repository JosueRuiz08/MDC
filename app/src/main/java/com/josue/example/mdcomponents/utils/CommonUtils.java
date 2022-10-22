package com.josue.example.mdcomponents.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.josue.example.mdcomponents.Fragments.ButtonFragment;
import com.josue.example.mdcomponents.Fragments.BottomNavigationBarFragment;
import com.josue.example.mdcomponents.Fragments.CardFragment;
import com.josue.example.mdcomponents.Fragments.CheckBoxFragment;
import com.josue.example.mdcomponents.Fragments.FloatingActionButtonFragment;
import com.josue.example.mdcomponents.Fragments.SnackBarFragment;
import com.josue.example.mdcomponents.Fragments.TextFieldFragment;

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
            case TextFieldFragment.TAG:
                fragment = new TextFieldFragment();
                break;
            case CardFragment.TAG:
                fragment = new CardFragment();
                break;
            //Static
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;
            case SnackBarFragment.TAG:
                fragment = new SnackBarFragment();
                break;
            case FloatingActionButtonFragment.TAG:
                fragment = new FloatingActionButtonFragment();
                break;
            case CheckBoxFragment.TAG:
                fragment = new CheckBoxFragment();
                break;
        }
        return fragment;
    }
}
