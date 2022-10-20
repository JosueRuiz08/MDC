package com.josue.example.mdcomponents.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.josue.example.mdcomponents.R;
import com.josue.example.mdcomponents.utils.Component;
import com.josue.example.mdcomponents.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BottomNavigationBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottomNavigationBarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public  static final String TAG = "Button Navigation";
    private static Component mInstance;
    Unbinder mUnbinder;
    @BindView(R.id.bottomNavigation)
    BottomNavigationView bottomNavigation;

    public static Component getItemInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_bottomnav_mobile_portrait);
        mInstance.setType(Constants.STATIC);

        return mInstance;
    }

    public BottomNavigationBarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BottomNavigationBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BottomNavigationBarFragment newInstance(String param1, String param2) {
        BottomNavigationBarFragment fragment = new BottomNavigationBarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bottom_navigation_bar, container, false);
        mUnbinder = ButterKnife.bind(this, v);

        bottomNavigation.getOrCreateBadge(R.id.action_start);
//        bottomNavigation.removeBadge(R.id.action_start);
        BadgeDrawable favoriteBadge =  bottomNavigation.getOrCreateBadge(R.id.action_favorites);
        favoriteBadge.setNumber(4);

        BadgeDrawable profileBadge = bottomNavigation.getOrCreateBadge(R.id.action_profile);
        profileBadge.setNumber(100);
        profileBadge.setMaxCharacterCount(3);
        profileBadge.setBackgroundColor(Color.CYAN);
        profileBadge.setBadgeTextColor(Color.MAGENTA);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}