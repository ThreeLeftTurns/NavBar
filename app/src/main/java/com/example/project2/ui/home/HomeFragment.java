package com.example.project2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.project2.R;
import com.example.project2.databinding.FragmentHomeBinding;

//HomeFragment is a Fragment subclass that represents the "About Me" page.
public class HomeFragment extends Fragment {
    //Binding instance variable for accessing the fragment's views.
    private FragmentHomeBinding binding;
    //Called to "inflate" the layout of the fragment,
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Used to create the View hierarchy from the XML layout file.
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        //Layout is obtained.
        View root = binding.getRoot();
        //This is where you would display about me
        binding.textHome.setText(R.string.Aboutme);

        return root;
    }

    //Clean up resources related to the view
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
