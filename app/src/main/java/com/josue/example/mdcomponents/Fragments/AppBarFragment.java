package com.josue.example.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.josue.example.mdcomponents.R;
import com.josue.example.mdcomponents.utils.Component;
import com.josue.example.mdcomponents.utils.Constants;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppBarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public  static final String TAG = "AppBarFragment";
    private static Component mInstance;
    Unbinder mUnbinder;

    public static Component getItemInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_appbar_top);
        mInstance.setType(Constants.STATIC);

        return mInstance;
    }

    public AppBarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AppBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AppBarFragment newInstance(String param1, String param2) {
        AppBarFragment fragment = new AppBarFragment();
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
        View v = inflater.inflate(R.layout.fragment_app_bar, container, false);
        mUnbinder = ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @OnClick({R.id.btnTop,R.id.btnBottom})
    public void onClicked(View view){
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.btnTop:
                AppBarTopFragment topFragment = new AppBarTopFragment();
                topFragment.show(transaction, AppBarTopFragment.TAG);
                break;
            case R.id.btnBottom:
                AppBarBottomFragment bottomFragment = new AppBarBottomFragment();
                bottomFragment.show(transaction, AppBarBottomFragment.TAG);
                break;
        }
    }
}