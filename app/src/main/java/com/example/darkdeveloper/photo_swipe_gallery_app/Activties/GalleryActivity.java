package com.example.darkdeveloper.photo_swipe_gallery_app.Activties;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.darkdeveloper.photo_swipe_gallery_app.Adapter.GalleryImageAdapter;
import com.example.darkdeveloper.photo_swipe_gallery_app.Interface.IRecylcerViewClickListener;
import com.example.darkdeveloper.photo_swipe_gallery_app.R;

import java.util.Random;

public class GalleryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerid);


//                 2 Image will be Displayed
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);


        Random ramdom = new Random();

//         Only 10 Images will be Dsisplayed and Store Url Of All images
        final String[] images = new String[10];

        for (int i=0;i<images.length;i++)
            images[i] ="https://picsum.photos/600?image-"+ramdom.nextInt(100+1);

        final IRecylcerViewClickListener listener = new IRecylcerViewClickListener() {
            @Override
            public void onclick(View view, int position) {
//                 Open Full Screen Activity with Image Click


                Intent intent = new Intent(getApplicationContext(),FullScreen.class);
                intent.putExtra("Images",images);
                intent.putExtra("Position",position);
                startActivity(intent);

            }
        };


        GalleryImageAdapter galleryImageAdapter = new GalleryImageAdapter(this,images,listener);

        recyclerView.setAdapter(galleryImageAdapter);



    }
}
