package com.example.darkdeveloper.photo_swipe_gallery_app.Activties;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.darkdeveloper.photo_swipe_gallery_app.Adapter.FullSizeAdapter;
import com.example.darkdeveloper.photo_swipe_gallery_app.R;

public class FullScreen extends Activity {

    ViewPager viewPager;

    String[] images;
    int positon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);


        if(savedInstanceState ==null)
        {
            Intent intent = getIntent();

            images = intent.getStringArrayExtra("Images");
            positon = intent.getIntExtra("Position",0);
        }

        viewPager = (ViewPager)findViewById(R.id.viewpage);


        FullSizeAdapter fullSizeAdapter = new FullSizeAdapter(this,images);
        viewPager.setAdapter(fullSizeAdapter);
        viewPager.setCurrentItem(positon,true);
    }
}
