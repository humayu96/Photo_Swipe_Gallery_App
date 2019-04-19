package com.example.darkdeveloper.photo_swipe_gallery_app.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.darkdeveloper.photo_swipe_gallery_app.Interface.IRecylcerViewClickListener;
import com.example.darkdeveloper.photo_swipe_gallery_app.R;

public class GalleryImageAdapter extends RecyclerView.Adapter<GalleryImageAdapter.ImageViewHolder>
{
    Context context;

    String[] urlist;

    IRecylcerViewClickListener clickListener;



    public GalleryImageAdapter(Context context,String[] urlist,IRecylcerViewClickListener clickListener)
    {
        this.context = context;
        this.urlist = urlist;
        this.clickListener = clickListener;
    }

    @NonNull

    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gallery_item,viewGroup,false);

        return new  ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {

        String currentImage = urlist[i];

        ImageView imageView = imageViewHolder.imageView;

        final ProgressBar progressBar = imageViewHolder.progressBar;


        Glide.with(context).load(currentImage).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(imageView);
    }

    @Override
    public int getItemCount() {
        return urlist.length;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {
        ImageView imageView;
        ProgressBar progressBar;

        public ImageViewHolder(View itemView)
        {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            progressBar = (ProgressBar)itemView.findViewById(R.id.prog);

            itemView.setOnClickListener(this);


        }



        @Override
        public void onClick(View view) {

            clickListener.onclick(view,getAdapterPosition());
        }
    }

}
