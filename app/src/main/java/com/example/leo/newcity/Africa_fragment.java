package com.example.leo.newcity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Africa_fragment extends Fragment implements ItemClickListener{

    private List<City> cities;
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.africa_fragment, container, false);
        rv=(RecyclerView)view.findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

        return  view;
    }

    private void initializeData(){
        cities = new ArrayList<>();
        cities.add(new City("Cape Town","South Africa", R.drawable.capetown));
        cities.add(new City("Tunis","Tunisia", R.drawable.tunis));
        cities.add(new City("Casablanca","Marocco", R.drawable.casablanca));
        cities.add(new City("Cairo","Egypt", R.drawable.cairo));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cities);
        rv.setAdapter(adapter);
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        Intent i = new Intent(getActivity(), AfricaDetailCity.class);
        i.putExtra("position",position);
        startActivity(i);
    }
}
