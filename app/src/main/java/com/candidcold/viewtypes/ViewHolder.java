package com.candidcold.viewtypes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by davidmorant on 9/11/15.
 * This same ViewHolder can be used for all of our adapters.
 * However, you could implement this project with multiple types of ViewHolders and manage them
 * yourself.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.artist_name) TextView artistName;
    @Bind(R.id.album_name) TextView albumName;
    @Bind(R.id.album_cover) ImageView albumCover;

    Context context;

    public ViewHolder(View itemView, Context context) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
    }

    public void setImage(int drawableResource) {
        if (albumCover != null) {
            Glide.with(context).load(drawableResource).into(albumCover);
        }
    }

    public void setArtistName(String name) {
        if (artistName != null) {
            artistName.setText(name);
        }
    }

    public void setAlbumName(String name) {
        if (albumName != null) {
            albumName.setText(name);
        }
    }
}
