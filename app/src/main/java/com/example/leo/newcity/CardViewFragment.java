package com.example.leo.newcity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CardViewFragment extends Fragment {

    TextView cityName;
    TextView country;
    ImageView cityPhoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_view, container, false);
        cityName = (TextView)view.findViewById(R.id.city_name);
        country = (TextView) view.findViewById(R.id.country);
        cityPhoto = (ImageView)view.findViewById(R.id.city_photo);

        cityName.setText("London");
        country.setText("United Kingodm");
        cityPhoto.setImageResource(R.drawable.london);

        return view;
    }
}


