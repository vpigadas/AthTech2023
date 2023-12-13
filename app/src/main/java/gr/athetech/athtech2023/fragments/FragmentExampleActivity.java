package gr.athetech.athtech2023.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import gr.athetech.athtech2023.R;

public class FragmentExampleActivity extends AppCompatActivity {

    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container_bottom, FirstFragment.newInstance());
        transaction.commit();
    }

    public void switchFragments() {
        if (position == 0) {
            showFragmentSecond();
        } else if (position == 2) {
            showFragmentThird();
        } else {
            showFragmentSecond();
        }
    }

    private void showFragmentSecond() {
        position = 2;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container_top, SecondFragment.newInstance());
        transaction.commit();
    }

    private void showFragmentThird() {
        position = 3;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container_top, ThirdFragment.newInstance());
        transaction.commit();
    }
}