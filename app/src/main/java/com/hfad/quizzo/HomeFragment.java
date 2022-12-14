package com.hfad.quizzo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button add = view.findViewById(R.id.btn_add);
        Button practice = view.findViewById(R.id.btn_prac);
        Spinner spinnerGenre = view.findViewById(R.id.spinner_gen);

        add.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_addQuestionFragment);
            }
        });

        practice.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                String genre = spinnerGenre.getSelectedItem().toString();

                HomeFragmentDirections.ActionHomeFragmentToPracticeFragment action =
                    HomeFragmentDirections.actionHomeFragmentToPracticeFragment(genre);

                Navigation.findNavController(view).navigate(action);
            }
        });


        return view;
    }



}