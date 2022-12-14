package com.josue.example.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.snackbar.Snackbar;
import com.josue.example.mdcomponents.R;
import com.josue.example.mdcomponents.utils.Component;
import com.josue.example.mdcomponents.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PickerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickerFragment extends Fragment {
    public  static final String TAG = "PickerFragment";
    private static Component mInstance;
    Unbinder mUnbinder;
    @BindView(R.id.containerMain)
    LinearLayout containerMain;

    public static Component getItemInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_picker);
        mInstance.setType(Constants.STATIC);

        return mInstance;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PickerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickerFragment newInstance(String param1, String param2) {
        PickerFragment fragment = new PickerFragment();
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
        View v = inflater.inflate(R.layout.fragment_picker, container, false);
        mUnbinder = ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
    @OnClick({R.id.btnDialogPicker,R.id.btnFullScreenPicker})
    public void onPickerClicked(View view){
        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText(R.string.picker_title);
        builder.setSelection(System.currentTimeMillis());
        switch (view.getId()) {
            case R.id.btnDialogPicker:
                builder.setTheme(com.google.android.material.R.style.ThemeOverlay_MaterialComponents_MaterialCalendar);
                break;
                case R.id.btnFullScreenPicker:
                    builder.setTheme(com.google.android.material.R.style.ThemeOverlay_MaterialComponents_MaterialCalendar_Fullscreen);
                    //builder.setTheme(R.style.FullScreenPicker);
                    break;
        }

        MaterialDatePicker<?> picker = builder.build();
        picker.addOnPositiveButtonClickListener(selection -> {
//            Snackbar.make(containerMain,R.string.message_action_success, Snackbar.LENGTH_SHORT).show();
            Snackbar.make(containerMain,picker.getHeaderText(), Snackbar.LENGTH_SHORT).show();
        });
        picker.addOnNegativeButtonClickListener(dialog -> {
            Snackbar.make(containerMain,R.string.dialog_negative, Snackbar.LENGTH_SHORT).show();
        });
        picker.addOnCancelListener(dialogInterface -> {
            Snackbar.make(containerMain,R.string.dialog_cancel, Snackbar.LENGTH_SHORT).show();
        });
        picker.show(getFragmentManager(), picker.toString());
    }
}