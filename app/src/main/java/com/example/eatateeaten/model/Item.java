package com.example.eatateeaten.model;

import java.util.Locale;

public class Item {
    public final long _id;
    public final String title;
    public final String image;

    public Item(long _id, String title, String image) {
        this._id = _id;
        this.title = title;
        this.image = image;
    }

    @Override
    public String toString() {
        String msg = String.format(
                Locale.getDefault(),
                "%s ",
                this.title
        );
        return msg;
    }
}
