package com.example.usher.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private HeadBar mHbMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHbMain = (HeadBar) findViewById(R.id.hb_main);
        mHbMain.setThisState(HeadBar.STATE.STATE5);
    }
}
