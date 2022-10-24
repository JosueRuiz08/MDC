package com.josue.example.mdcomponents.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.chip.Chip;
import com.josue.example.mdcomponents.R;
import com.josue.example.mdcomponents.utils.Component;
import com.josue.example.mdcomponents.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public  static final String TAG = "CardFragment";
    private static Component mInstance;
    Unbinder mUnbinder;

    @BindView(R.id.imgCardLarge)
    AppCompatImageView imgCardLarge;
    @BindView(R.id.chipSecond)
    Chip chipSecond;
    @BindView(R.id.chipThird)
    Chip chipThird;

    public static Component getItemInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_cards_template);
        mInstance.setType(Constants.SCROLL);

        return mInstance;
    }

    public CardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardFragment newInstance(String param1, String param2) {
        CardFragment fragment = new CardFragment();
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
        View v = inflater.inflate(R.layout.fragment_card, container, false);
        mUnbinder = ButterKnife.bind(this, v);

        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop();
        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/6/6d/Good_Food_Display_-_NCI_Visuals_Online.jpg";
        Glide.with(this).load(imageUrl)
                .apply(options)
                .into(imgCardLarge);
        chipSecond.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked){
                Toast.makeText(getActivity(), "Checked", Toast.LENGTH_SHORT).show();
            }
        });
        chipThird.setOnCloseIconClickListener(view1 -> chipThird.setVisibility(View.GONE));

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
    @OnClick(R.id.chipFirst)
    public void onViewClicked(){
        Toast.makeText(getActivity(), "Chip First", Toast.LENGTH_SHORT).show();
    }
}