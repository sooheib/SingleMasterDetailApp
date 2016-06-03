package com.vivianaranha.singlemasterdetailapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.Messenger {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(int i) {
        FragmentB fragmentB = (FragmentB) getFragmentManager().findFragmentById(R.id.fragment2);
        if(fragmentB != null && fragmentB.isVisible()){
            fragmentB.changeData(i);
        } else {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("index", i);
            startActivity(intent);
        }
    }
}
