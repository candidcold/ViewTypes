package com.candidcold.viewtypes.simplechange;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.candidcold.viewtypes.R;
import com.candidcold.viewtypes.model.Album;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by davidmorant on 9/11/15.
 */
public class SimpleChangeList extends Fragment {
    @Bind(R.id.recycler_view)RecyclerView recyclerView;

    ArrayList<Album> albums = new ArrayList<>();
    SimpleChangeAdapter adapter;

    public static SimpleChangeList newInstance(ArrayList<Album> myAlbums) {
        // I had the lobster bisque, we went back to my place, yada yada yada, I never heard from him again.
        SimpleChangeList fragment = new SimpleChangeList();
        fragment.albums = myAlbums;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        ButterKnife.bind(this, rootView);
        adapter = new SimpleChangeAdapter(albums, getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
