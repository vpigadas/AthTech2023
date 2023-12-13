package gr.athetech.athtech2023.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import gr.athetech.athtech2023.R;

public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }

    // UI Thread
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // UI Thread
    @Override
    public void onStart() {
        super.onStart();
    }

    // UI Thread
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    // UI Thread
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btn = view.findViewById(R.id.fragment_first_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity();

                if (activity instanceof CustomFragmentActivity) {
                    ((CustomFragmentActivity) activity).moveToSecondFragment();
                } else if (activity instanceof FragmentExampleActivity) {
                    ((FragmentExampleActivity) activity).switchFragments();
                }
            }
        });
    }

    // UI Thread
    @Override
    public void onResume() {
        super.onResume();
        View view = getView();

        if (view != null) {
            Button btn = view.findViewById(R.id.fragment_first_btn);
        }


    }

    // UI Thread
    @Override
    public void onPause() {
        super.onPause();
    }

    // UI Thread
    @Override
    public void onStop() {
        super.onStop();
    }

    // UI Thread
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    // UI Thread
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
