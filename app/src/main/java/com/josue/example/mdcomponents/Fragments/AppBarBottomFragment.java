package com.josue.example.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.josue.example.mdcomponents.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppBarBottomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppBarBottomFragment extends DialogFragment {

    public static final String TAG = "AppBarBottomFragment";
    Unbinder mUnbinder;
    private boolean isCentered;
    @BindView(R.id.containerMain)
    CoordinatorLayout containerMain;
    @BindView(R.id.bottom_app_bar)
    BottomAppBar bottom_app_bar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AppBarBottomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AppBarBottomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AppBarBottomFragment newInstance(String param1, String param2) {
        AppBarBottomFragment fragment = new AppBarBottomFragment();
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
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_app_bar_bottom, container, false);
        mUnbinder = ButterKnife.bind(this, v);
        bottom_app_bar.setOnMenuItemClickListener(item -> {
            int resMessage;
            switch (item.getItemId()) {
                case R.id.action_favorites:
                    resMessage = R.string.menu_favorites;
                    break;
                case R.id.action_profile:
                    resMessage = R.string.menu_profile;
                    break;
                default:
                    resMessage = R.string.menu_start;
                    break;
            }
            Snackbar.make(containerMain, resMessage, Snackbar.LENGTH_SHORT)
                    .setAnchorView(fab)
                    .show();

            return true;
        });
        bottom_app_bar.setNavigationOnClickListener(view -> {
            Snackbar.make(containerMain, R.string.message_action_success, Snackbar.LENGTH_SHORT)
                    .setAnchorView(fab)
                    .show();
        });

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @OnClick(R.id.fab)
    public void onFabClicked(){
        if (isCentered){
            bottom_app_bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
        }else {
            bottom_app_bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
        }
        isCentered = !isCentered;
    }
}