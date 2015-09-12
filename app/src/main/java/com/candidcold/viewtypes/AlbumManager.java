package com.candidcold.viewtypes;

import com.candidcold.viewtypes.model.Album;

import java.util.ArrayList;

/**
 * Created by davidmorant on 9/11/15.
 */
public class AlbumManager {

    public ArrayList<Album> getAlbumList() {
        ArrayList<Album> albums = new ArrayList<>();

        albums.add(new Album("90059",
                "Jay Rock",
                "9/11/2015",
                R.drawable.ninedoubleofiveninealbumcover,
                0));

        albums.add(new Album("good kid, m.A.A.d city",
                "Kendrick Lamar",
                "8/22/2012",
                R.drawable.gkmcalbumcover,
                1400000));

        albums.add(new Album("Control System",
                "Ab-Soul",
                "5/11/2012",
                R.drawable.controlsystemalbumcover,
                27000));

        albums.add(new Album("Z",
                "SZA",
                "sometimeidr",
                R.drawable.zalbumcover,
                12600));

        albums.add(new Album("Oxymoron",
                "ScHoolboy Q",
                "2/25/2014",
                R.drawable.oxymoronalbumcover,
                432000));

        albums.add(new Album("Habits and Contradictions",
                "ScHoolboy Q",
                "1/14/2012",
                R.drawable.handcalbumcover,
                48000));

        albums.add(new Album("Section.80",
                "Kendrick Lamar",
                "7/2/2011",
                R.drawable.section80albumcover,
                110000));

        albums.add(new Album("To Pimp A Butterfly",
                "Kendrick Lamar",
                "3/15/2015",
                R.drawable.tpababumcover,
                671000));

        albums.add(new Album("These Days",
                "Ab-Soul",
                "6/24/2014",
                R.drawable.thesedaysalbumcover,
                31000));

        albums.add(new Album("Cilvia Demo",
                "Isaiah Rashad",
                "1/28/2014",
                R.drawable.cilviaalbumcover,
                26000));

        return albums;
    }

    public ArrayList<Album> modifySales(ArrayList<Album> originalAlbums) {
        for (int i = 1; i < originalAlbums.size()+1; i++) {
            if (i % 2 == 1) {
                originalAlbums.get(i - 1).increaseSales(i * 3000); // Multiplier to see a bigger difference
            } else {
                originalAlbums.get(i-1).increaseSales(-1 * i * 3000);
            }
        }

        return originalAlbums;
    }
}
