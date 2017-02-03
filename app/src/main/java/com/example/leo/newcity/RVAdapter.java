package com.example.leo.newcity;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CityViewHolder> {

   private  List<City> cities;
    private ItemClickListener clickListener;

    public class CityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CardView cv;
        TextView country;
        TextView cityName;
        ImageView cityPhoto;
        Context context;

        CityViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            cityName = (TextView)itemView.findViewById(R.id.city_name);
            country = (TextView) itemView.findViewById(R.id.country);
            cityPhoto = (ImageView)itemView.findViewById(R.id.city_photo);
            context=itemView.getContext();
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }

    RVAdapter(List<City> cities){
        this.cities = cities;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        CityViewHolder cvh = new CityViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(final CityViewHolder cityViewHolder, int i) {
        cityViewHolder.cityName.setText(cities.get(i).name);
        cityViewHolder.country.setText(cities.get(i).country);
        cityViewHolder.cityPhoto.setImageResource(cities.get(i).photoId);
    }


    @Override
    public int getItemCount() {
        return cities.size();
    }

    public void setClickListener(ItemClickListener itemClickListener){
        this.clickListener = itemClickListener;
    }
}
