package com.candidcold.viewtypes.straightforward;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.candidcold.viewtypes.R;
import com.candidcold.viewtypes.ViewHolder;
import com.candidcold.viewtypes.model.Album;

import java.util.ArrayList;

/**
 * Created by davidmorant on 9/11/15.
 */
public class StraightForwardAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<Album> albums = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public StraightForwardAdapter(ArrayList<Album> albums, Context context) {
        this.albums = albums;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_medium_card, parent, false), context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Album singleAlbum = albums.get(position);

        holder.setAlbumName(singleAlbum.getTitle());
        holder.setArtistName(singleAlbum.getArtist());
        holder.setImage(singleAlbum.getCoverArt());

    }

    @Override
    public int getItemCount() {
        return albums.size();
    }
}
