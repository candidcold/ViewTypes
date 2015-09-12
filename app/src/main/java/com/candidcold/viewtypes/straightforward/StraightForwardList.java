package com.candidcold.viewtypes.straightforward;

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
public class StraightForwardList extends Fragment {
    @Bind(R.id.recycler_view) RecyclerView recyclerView;

    ArrayList<Album> albums = new ArrayList<>();
    StraightForwardAdapter adapter;

    public static StraightForwardList newInstance(ArrayList<Album> myAlbums) {
        // I know I probably shouldn't do this, but it's easier for now.
        StraightForwardList fragment = new StraightForwardList();
        fragment.albums = myAlbums;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        ButterKnife.bind(this, rootView);
        adapter = new StraightForwardAdapter(albums, getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
