package com.romanso.gameoflife.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.romanso.gameoflife.R;
import com.romanso.gameoflife.fragment.FieldFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    private FieldFragment mFieldFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFieldFragment = new FieldFragment();
        mFragmentTransaction.add(R.id.field_container, mFieldFragment);
        mFragmentTransaction.commit();
    }
}
