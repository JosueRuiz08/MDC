package com.josue.example.mdcomponents.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.josue.example.mdcomponents.R;
import com.josue.example.mdcomponents.utils.Component;
import com.josue.example.mdcomponents.utils.Constants;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlertDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlertDialogFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public  static final String TAG = "AlertDialogFragment";
    private static Component mInstance;
    Unbinder mUnbinder;

    public static Component getItemInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_dialog_mobile_alert);
        mInstance.setType(Constants.STATIC);

        return mInstance;
    }

    public AlertDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlertDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlertDialogFragment newInstance(String param1, String param2) {
        AlertDialogFragment fragment = new AlertDialogFragment();
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
        View v = inflater.inflate(R.layout.fragment_dialog, container, false);
        mUnbinder = ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @OnClick(R.id.btnDialogInfo)
    public void oninfoClicked(){
        new MaterialAlertDialogBuilder(getActivity())
                .setTitle(R.string.card_message_demo_small)
                .setPositiveButton(R.string.dialog_ok,null)
                .show();
    }

    @OnClick(R.id.btnDialogChooser)
    public void onChooserClicked(){
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.select_dialog_item);
        adapter.add("Opcion 1");
        adapter.add("Opcion 2");
        adapter.add("Opcion 3");

        new MaterialAlertDialogBuilder(getActivity())
                .setTitle(R.string.dialog_chooser)
                .setAdapter(adapter, (dialogInterface, i) ->
                        Toast.makeText(getActivity(),adapter.getItem(i), Toast.LENGTH_SHORT).show())
                .show();
    }

    @OnClick(R.id.btnDialogComfirm)
    public void onConfirmClicked(){
        //new MaterialAlertDialogBuilder(getActivity())
        //new MaterialAlertDialogBuilder(getActivity(), com.google.android.material.R.style.ThemeOverlay_MaterialComponents_Dialog)
        new MaterialAlertDialogBuilder(getActivity(), com.google.android.material.R.style.MaterialAlertDialog_MaterialComponents_Title_Icon)
                .setTitle(R.string.dialog_confirm_title)
                .setMessage(R.string.card_message_demo_small)
                .setPositiveButton(R.string.dialog_confirm, (dialogInterface, i) ->
                        Toast.makeText(getActivity(),R.string.message_action_success, Toast.LENGTH_SHORT).show())
                .setNegativeButton(R.string.dialog_cancel,null)
                .show();
    }
    @OnClick(R.id.btnDialogFullScreen)
    public void onDialogFullScreenClicked(){
        FullScreenDialogFragment dialogFragment = new FullScreenDialogFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        dialogFragment.show(transaction, FullScreenDialogFragment.TAG);
    }
}