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

public class South_America_fragment extends Fragment implements ItemClickListener{

    private List<City> cities;
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.south__america_fragment, container, false);
        rv=(RecyclerView)view.findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

        return  view;
    }

    private void initializeData(){
        cities = new ArrayList<>();
        cities.add(new City("Buenos Aires","Argentina", R.drawable.buenosaires));
        cities.add(new City("Rio de Janeiro","Brazil", R.drawable.rio));
        cities.add(new City("Lima","Peru", R.drawable.lima));
        cities.add(new City("Sao Paulo","Brazil", R.drawable.saopaulo));
        cities.add(new City("Montevideo","Uruguay", R.drawable.montevideo));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cities);
        rv.setAdapter(adapter);
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        Intent i = new Intent(getActivity(), SouthAmDetailCity.class);
        i.putExtra("position",position);
        startActivity(i);
    }
}
