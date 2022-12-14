package com.josue.example.mdcomponents.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.PopupMenu;

import com.google.android.material.button.MaterialButton;
import com.josue.example.mdcomponents.R;
import com.josue.example.mdcomponents.utils.Component;
import com.josue.example.mdcomponents.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public  static final String TAG = "MenuFragment";
    private static Component mInstance;
    Unbinder mUnbinder;

    public static Component getItemInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_menu);
        mInstance.setType(Constants.STATIC);

        return mInstance;
    }

    @BindView(R.id.btnMenuPopup)
    MaterialButton btnMenuPopup;
    @BindView(R.id.actvCourses)
    AutoCompleteTextView actvCourses;


    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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
        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        mUnbinder = ButterKnife.bind(this, v);

        btnMenuPopup.setOnClickListener(view1 ->{
            PopupMenu popupMenu =  new PopupMenu(getActivity(), view1);
            popupMenu.getMenuInflater().inflate(R.menu.menu_bottom_nav, popupMenu.getMenu());
            popupMenu.show();
        });
        String[] courses = new String[] {"Experto en firebase para android +MVP Curso completo +30Hrs",
        "Curso A Desing",
        "Andropid: Funfamentos apps de calidad",
        "Klotlin 2020"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.item_menu_dropdown,courses);
        actvCourses.setAdapter(adapter);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}