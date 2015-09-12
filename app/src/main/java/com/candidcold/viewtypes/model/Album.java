package com.candidcold.viewtypes.model;

/**
 * Created by davidmorant on 9/11/15.
 */
public class Album{
    String title;
    String artist;
    String releaseDate;
    int coverArt;           // Contains a reference to a drawable
    int layout;             // For more complex layouts
    int sales;

    public Album(String title, String artist, String releaseDate, int coverArt, int sales) {
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.coverArt = coverArt;
        this.sales = sales;
    }

    public void increaseSales(int increase) {
        sales = sales + increase;
    }

    public int getSales() {
        return sales;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getCoverArt() {
        return coverArt;
    }

    public void setCoverArt(int coverArt) {
        this.coverArt = coverArt;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
