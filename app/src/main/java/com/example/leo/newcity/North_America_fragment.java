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

public class North_America_fragment extends Fragment implements ItemClickListener{

    private List<City> cities;
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.north__america_fragment, container, false);
        rv=(RecyclerView)view.findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

        return  view;
    }

    private void initializeData(){
        cities = new ArrayList<>();
        cities.add(new City("New York","United States", R.drawable.newyork));
        cities.add(new City("Mexico City","Mexico", R.drawable.mexicocity));
        cities.add(new City("Havana","Cuba", R.drawable.havana));
        cities.add(new City("Toronto","Canada", R.drawable.toronto));
        cities.add(new City("Los Angeles","United States", R.drawable.losangeles));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cities);
        rv.setAdapter(adapter);
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        Intent i = new Intent(getActivity(), NorthAmDetailCity.class);
        i.putExtra("position",position);
        startActivity(i);
    }
}
