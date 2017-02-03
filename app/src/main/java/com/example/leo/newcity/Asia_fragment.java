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

public class Asia_fragment extends Fragment implements ItemClickListener{

    private List<City> cities;
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.asia_fragment, container, false);
        rv=(RecyclerView)view.findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

        return  view;
    }

    private void initializeData(){
        cities = new ArrayList<>();
        cities.add(new City("Tokyo","Japan", R.drawable.tokyo));
        cities.add(new City("Mumbai","India", R.drawable.mumbai));
        cities.add(new City("Bangkok","Thailand", R.drawable.bangkok));
        cities.add(new City("Shanghai","China", R.drawable.shanghai));
        cities.add(new City("Hong Kong","China", R.drawable.hongkong));
        cities.add(new City("Kuala Lumpur","Malaysia", R.drawable.kualalumpur));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cities);
        rv.setAdapter(adapter);
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        Intent i = new Intent(getActivity(), AsiaDetailCity.class);
        i.putExtra("position",position);
        startActivity(i);
    }
}
