package com.example.leo.newcity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SouthAmDetailCity extends AppCompatActivity {

    String[] cityName,countryName,population,area,info,placename;
    int[] cityImg = {R.drawable.citybuenosaires,R.drawable.cityrio,R.drawable.citylima,R.drawable.citymonte,R.drawable.citymontevideo};
    int[] iconimg1 = {R.drawable.square,R.drawable.view,R.drawable.square,R.drawable.cpark,R.drawable.palace};
    int[] iconimg2 = {R.drawable.view,R.drawable.view,R.drawable.building,R.drawable.building,R.drawable.building};
    int[] iconimg3 = {R.drawable.building,R.drawable.mount,R.drawable.building,R.drawable.building,R.drawable.view};
    int[] iconimg4 = {R.drawable.vege,R.drawable.view,R.drawable.palace,R.drawable.palace,R.drawable.view};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south_am_detail_city);

        Intent i = getIntent();
        int position = i.getIntExtra("position", 100);

        //Content filling

        final ImageView image = (ImageView)findViewById(R.id.backdrop);
        image.setImageDrawable(getResources().getDrawable(cityImg[position]));

        TextView textView1 = (TextView) findViewById(R.id.detail_city_name);
        cityName = getResources().getStringArray(R.array.AMScity_name);
        textView1.setText(cityName[position]);

        TextView textView2 = (TextView) findViewById(R.id.detail_country_name);
        countryName = getResources().getStringArray(R.array.AMScountry_name);
        textView2.setText(countryName[position]);

        TextView textView3 = (TextView) findViewById(R.id.populationtext);
        population = getResources().getStringArray(R.array.AMSpopulation);
        textView3.setText(population[position]);

        TextView textView4 = (TextView) findViewById(R.id.areatext);
        area = getResources().getStringArray(R.array.AMSarea);
        textView4.setText(area[position]);

        TextView textView5 = (TextView) findViewById(R.id.infotext);
        info = getResources().getStringArray(R.array.AMSinfo);
        textView5.setText(info[position]);

        ImageView icon1 = (ImageView) findViewById(R.id.icon1);
        icon1.setImageDrawable(getResources().getDrawable(iconimg1[position]));
        ImageView icon2 = (ImageView) findViewById(R.id.icon2);
        icon2.setImageDrawable(getResources().getDrawable(iconimg2[position]));
        ImageView icon3 = (ImageView) findViewById(R.id.icon3);
        icon3.setImageDrawable(getResources().getDrawable(iconimg3[position]));
        ImageView icon4 = (ImageView) findViewById(R.id.icon4);
        icon4.setImageDrawable(getResources().getDrawable(iconimg4[position]));

        TextView textView6 = (TextView) findViewById(R.id.texticon1);
        placename= getResources().getStringArray(R.array.AMSicon1);
        textView6.setText(placename[position]);

        TextView textView7 = (TextView) findViewById(R.id.texticon2);
        placename= getResources().getStringArray(R.array.AMSicon2);
        textView7.setText(placename[position]);

        TextView textView8 = (TextView) findViewById(R.id.texticon3);
        placename= getResources().getStringArray(R.array.AMSicon3);
        textView8.setText(placename[position]);

        TextView textView9 = (TextView) findViewById(R.id.texticon4);
        placename= getResources().getStringArray(R.array.AMSicon4);
        textView9.setText(placename[position]);

        getSupportActionBar().hide();

        ImageView backButton = (ImageView) findViewById(R.id.backbutton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
