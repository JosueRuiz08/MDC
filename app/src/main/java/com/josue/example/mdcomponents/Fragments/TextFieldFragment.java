package com.josue.example.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.josue.example.mdcomponents.R;
import com.josue.example.mdcomponents.utils.Component;
import com.josue.example.mdcomponents.utils.Constants;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TextFieldFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TextFieldFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public  static final String TAG = "TextFieldFragment";
    private static Component mInstance;
    Unbinder mUnbinder;
//    @BindView(R.id.container_main)
//    FrameLayout containerMain;
    @BindView(R.id.etPrice)
    TextInputEditText etPrice;
    @BindView(R.id.etCapitalLetter)
    TextInputEditText etCapitalLetter;
    @BindView(R.id.tiCapitalLetter)
    TextInputLayout tiCapitalLetter;

    public static Component getItemInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_textfields_outlined_active);
        mInstance.setType(Constants.SCROLL);

        return mInstance;
    }

    public TextFieldFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TextFieldFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TextFieldFragment newInstance(String param1, String param2) {
        TextFieldFragment fragment = new TextFieldFragment();
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
        View v = inflater.inflate(R.layout.fragment_text_filed, container, false);
        mUnbinder = ButterKnife.bind(this, v);

        tiCapitalLetter.setEndIconOnClickListener(view -> {
            if (etCapitalLetter.getText() != null) {
                String contentStr = etCapitalLetter.getText().toString();
                etCapitalLetter.setText(contentStr.toUpperCase());
            }
        });

        etPrice.addTextChangedListener( new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty() && Integer.valueOf(etPrice.getText().toString()) < 5){
                    etPrice.setError(getString(R.string.error_price_min));
                }
            }
        });

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}