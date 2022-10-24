package com.josue.example.mdcomponents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.josue.example.mdcomponents.Fragments.AppBarFragment;
import com.josue.example.mdcomponents.Fragments.ButtonFragment;
import com.josue.example.mdcomponents.Fragments.BottomNavigationBarFragment;
import com.josue.example.mdcomponents.Fragments.CardFragment;
import com.josue.example.mdcomponents.Fragments.CheckBoxFragment;
import com.josue.example.mdcomponents.Fragments.AlertDialogFragment;
import com.josue.example.mdcomponents.Fragments.FloatingActionButtonFragment;
import com.josue.example.mdcomponents.Fragments.MenuFragment;
import com.josue.example.mdcomponents.Fragments.SnackBarFragment;
import com.josue.example.mdcomponents.Fragments.TextFieldFragment;
import com.josue.example.mdcomponents.adapters.ComponentAdapter;
import com.josue.example.mdcomponents.utils.Component;
import com.josue.example.mdcomponents.utils.Constants;
import com.josue.example.mdcomponents.utils.OnClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    private ComponentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configAdapter();
        configRecyclerView();
    }

    private void configAdapter() {
        mAdapter = new ComponentAdapter(new ArrayList<>(),this);
        mAdapter.add(ButtonFragment.getItemInstance());
        mAdapter.add(BottomNavigationBarFragment.getItemInstance());
        mAdapter.add(SnackBarFragment.getItemInstance());
        mAdapter.add(TextFieldFragment.getItemInstance());
        mAdapter.add(FloatingActionButtonFragment.getItemInstance());
        mAdapter.add(CheckBoxFragment.getItemInstance());
        mAdapter.add(CardFragment.getItemInstance());
        mAdapter.add(MenuFragment.getItemInstance());
        mAdapter.add(AlertDialogFragment.getItemInstance());
        mAdapter.add(AppBarFragment.getItemInstance());
        mAdapter.reverse();
    }

    private void configRecyclerView() {
        recyclerView.setAdapter(mAdapter);
    }

    /*OnClickListener*/
    @Override
    public void onClick(Component component) {
        Intent intent;
        if (component.getType() == Constants.SCROLL){
            intent = new Intent(this,ScrollActivity.class);
        }else {
            intent = new Intent(this,StaticActivity.class);
        }
        intent.putExtra(Constants.ARG_NAME, component.getName());
        startActivity(intent);
    }
}