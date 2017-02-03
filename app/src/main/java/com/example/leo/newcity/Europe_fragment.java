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

public class Europe_fragment extends Fragment implements ItemClickListener {

    private List<City> cities;
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.europe_fragment, container, false);
        rv=(RecyclerView)view.findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

        return  view;
    }

    private void initializeData(){
        cities = new ArrayList<>();
        cities.add(new City("London","United Kingdom", R.drawable.london));
        cities.add(new City("Berlin","Germmany", R.drawable.berlin));
        cities.add(new City("Prague","Cezch Republic", R.drawable.prague));
        cities.add(new City("Madrid","Spain", R.drawable.madrid));
        cities.add(new City("Rome","Italy", R.drawable.rome));
        cities.add(new City("Paris","France", R.drawable.paris));
        cities.add(new City("Moscow","Russia", R.drawable.moscow));
        cities.add(new City("Istanbul","Turkey", R.drawable.istanbul));
        cities.add(new City("Athens","Greece", R.drawable.athens));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cities);
        rv.setAdapter(adapter);
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
            Intent i = new Intent(getActivity(), EuropaCity.class);
            i.putExtra("position",position);
            startActivity(i);
        }
    }

