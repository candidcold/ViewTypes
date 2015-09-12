package com.candidcold.viewtypes.smarter;

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
 * Created by davidmorant on 9/12/15.
 */
public class SmarterList extends Fragment {
    @Bind(R.id.recycler_view)RecyclerView recyclerView;

    ArrayList<Album> albums = new ArrayList<>();
    SmarterAdapter adapter;

    public static SmarterList newInstance(ArrayList<Album> myAlbums) {
        // Do you think that-- Have you thought about middle schools?
        SmarterList fragment = new SmarterList();
        fragment.albums = myAlbums;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        ButterKnife.bind(this, rootView);
        adapter = new SmarterAdapter(albums, getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
