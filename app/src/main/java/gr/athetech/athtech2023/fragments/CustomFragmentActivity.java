package gr.athetech.athtech2023.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import gr.athetech.athtech2023.R;

public class CustomFragmentActivity extends AppCompatActivity {

    private int position = 0;

    // BG Thread
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_fragment);
    }

    // BG Thread
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    // BG Thread
    @Override
    protected void onStart() {
        super.onStart();
    }

    // UI Thread
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        moveToFirstFragment();
    }

    public void moveToFirstFragment() {
        position = 1;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.custom_fragment_container, FirstFragment.newInstance());
        transaction.commit();
    }

    public void moveToSecondFragment() {
        position = 2;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.custom_fragment_container, SecondFragment.newInstance("Orfeas"));
//        transaction.replace(R.id.custom_fragment_container, SecondFragment.newInstance());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
//        if (position == 2) {
//            moveToFirstFragment();
//        } else {
//            super.onBackPressed();
//        }



        super.onBackPressed();
    }

    // UI Thread
    @Override
    protected void onResume() {
        super.onResume();
    }

    // UI Thread
    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    // UI Thread
    @Override
    protected void onPause() {
        super.onPause();
    }

    // BG Thread
    @Override
    protected void onStop() {
        super.onStop();
    }

    // BG Thread
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}