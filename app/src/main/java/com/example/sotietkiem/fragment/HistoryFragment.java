package com.example.sotietkiem.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sotietkiem.R;

import java.util.ArrayList;

import data.User;

public class HistoryFragment extends Fragment {

    RecyclerView rvListC;
    ArrayList<User> lstUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_history, container, false);


    }
}