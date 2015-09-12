package com.candidcold.viewtypes;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.candidcold.viewtypes.model.Album;
import com.candidcold.viewtypes.simplechange.SimpleChangeList;
import com.candidcold.viewtypes.smarter.SmarterList;
import com.candidcold.viewtypes.straightforward.StraightForwardList;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.tabs) TabLayout tabs;
    @Bind(R.id.viewpager) ViewPager pager;

    private ArrayList<Album> albums = new ArrayList<>();
    AlbumManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        am = new AlbumManager();

        // The number 4 is CRITICAL because I'm a horse and it's arbitrary. I just need enough.
        for (int i = 0; i < 4; i++) {
            albums.addAll(am.getAlbumList());
        }

        setupViewPager();
    }

    private void setupViewPager() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(StraightForwardList.newInstance(albums));
        fragments.add(SimpleChangeList.newInstance(albums));

        // We're not using the huge list of albums here because it'd just repeat what we know == pointless
        fragments.add(SmarterList.newInstance(am.getAlbumList()));

        // Here are the added sales to the original list, now let's see if things look different
        fragments.add(SmarterList.newInstance(am.modifySales(am.getAlbumList())));

        ArrayList<String> tabNames = new ArrayList<>();
        tabNames.add("Straightforward");
        tabNames.add("Simple Change");
        tabNames.add("Smarter");
        tabNames.add("Added Sales");
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments, tabNames);
        pager.setAdapter(adapter);

        tabs.setupWithViewPager(pager);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

}
