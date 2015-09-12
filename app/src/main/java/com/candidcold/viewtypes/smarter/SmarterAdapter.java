package com.candidcold.viewtypes.smarter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.candidcold.viewtypes.R;
import com.candidcold.viewtypes.ViewHolder;
import com.candidcold.viewtypes.model.Album;

import java.util.ArrayList;

/**
 * Created by davidmorant on 9/12/15.
 */
public class SmarterAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Album> albums = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public SmarterAdapter(ArrayList<Album> albums, Context context) {
        this.albums = albums;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(viewType, parent, false), context);
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

    // Not all models are created equal. In our case, not all of these albums came out at the same
    // time. If this were a real app, we'd want to display new albums as large to promote them in
    // order to be distinguishable from the others. Since we're only using a small list of items
    //
    // This is "smarter" for lack of a better word, as we can hook into how we know models meeting
    // certain criteria should be displayed. It's not actually that much smarter, just a reminder
    // that we have the actual model to play with and make decisions based on that.
    @Override
    public int getItemViewType(int position) {
        int sales = albums.get(position).getSales();
        if (sales >= 500000) {
            return R.layout.item_large_card;
        } else if (sales > 30000) {
            return R.layout.item_medium_card;
        } else {
            return R.layout.item_small_card;
        }
    }
}
