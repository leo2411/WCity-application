package com.example.leo.newcity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AfricaDetailCity extends AppCompatActivity {

    String[] cityName,countryName,population,area,info,placename;
    int[] cityImg = {R.drawable.citycapetown,R.drawable.citytunis,R.drawable.citycasablanca,R.drawable.citycairocity};
    int[] iconimg1 = {R.drawable.mount,R.drawable.building,R.drawable.square,R.drawable.building};
    int[] iconimg2 = {R.drawable.mount,R.drawable.palace,R.drawable.palace,R.drawable.building};
    int[] iconimg3 = {R.drawable.vege,R.drawable.building,R.drawable.building,R.drawable.palace};
    int[] iconimg4 = {R.drawable.mount,R.drawable.island,R.drawable.palace,R.drawable.palace};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.africa_detail_city);

        Intent i = getIntent();
        int position = i.getIntExtra("position", 100);

        //Content filling

        final ImageView image = (ImageView)findViewById(R.id.backdrop);
        image.setImageDrawable(getResources().getDrawable(cityImg[position]));

        TextView textView1 = (TextView) findViewById(R.id.detail_city_name);
        cityName = getResources().getStringArray(R.array.AFcity_name);
        textView1.setText(cityName[position]);

        TextView textView2 = (TextView) findViewById(R.id.detail_country_name);
        countryName = getResources().getStringArray(R.array.AFcountry_name);
        textView2.setText(countryName[position]);

        TextView textView3 = (TextView) findViewById(R.id.populationtext);
        population = getResources().getStringArray(R.array.AFpopulation);
        textView3.setText(population[position]);

        TextView textView4 = (TextView) findViewById(R.id.areatext);
        area = getResources().getStringArray(R.array.AFarea);
        textView4.setText(area[position]);

        TextView textView5 = (TextView) findViewById(R.id.infotext);
        info = getResources().getStringArray(R.array.AFinfo);
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
        placename= getResources().getStringArray(R.array.AFicon1);
        textView6.setText(placename[position]);

        TextView textView7 = (TextView) findViewById(R.id.texticon2);
        placename= getResources().getStringArray(R.array.AFicon2);
        textView7.setText(placename[position]);

        TextView textView8 = (TextView) findViewById(R.id.texticon3);
        placename= getResources().getStringArray(R.array.AFicon3);
        textView8.setText(placename[position]);

        TextView textView9 = (TextView) findViewById(R.id.texticon4);
        placename= getResources().getStringArray(R.array.AFicon4);
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
