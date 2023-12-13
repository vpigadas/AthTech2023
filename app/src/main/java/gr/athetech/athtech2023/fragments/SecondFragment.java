package gr.athetech.athtech2023.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import gr.athetech.athtech2023.R;

public class SecondFragment extends Fragment {

    private static final String ARG_NAME = "username";

    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(String name) {
        SecondFragment fragment = new SecondFragment();
        Bundle parameters = new Bundle();
        parameters.putString(ARG_NAME, name);
        fragment.setArguments(parameters);
        return fragment;
    }

    public static SecondFragment newInstance() {
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String name;
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
        } else {
            name = "V";
        }


        TextView textView = view.findViewById(R.id.fragment_second_txt);
        textView.setText(name);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}