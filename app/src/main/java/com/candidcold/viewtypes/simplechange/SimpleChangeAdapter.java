package com.candidcold.viewtypes.simplechange;

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
public class SimpleChangeAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<Album> albums = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public SimpleChangeAdapter(ArrayList<Album> albums, Context context) {
        this.albums = albums;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Notice we inflate the value of the viewType.
        return new ViewHolder(inflater.inflate(viewType, parent, false), context);

        // You could also set up a bunch of checks here based on what values we have for the viewType
        // and return a different ViewHolder based on the items you need.
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

    /* Here's the interesting part:
       viewType is just an integer, it really doesn't seem to hold any special meaning. We can tell
       this method to return whatever int we want, like 0, 1, or 2.

       For this, I return the layout that we want itself, so we don't have to check again later.
       As you can tell by the conditions, this is based entirely on the position, so there's very little
       complexity.
    */
    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0 && position % 3 == 0) {
            return R.layout.item_large_card;
            // return 0;
        } else if (position % 3 == 0) {
            return  R.layout.item_small_card;
            // return 2;
        } else {
            return R.layout.item_medium_card;
            // return 1;
        }
    }
}
