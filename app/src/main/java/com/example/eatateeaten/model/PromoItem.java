package com.example.eatateeaten.model;

import java.util.Locale;

public class PromoItem {
    public final long _id;
    public final String title;
    public final String number;
    public final String date;
    //public final String detail;
    public final String image;


    public PromoItem(long _id, String title, String number, String date, String image) {
        this._id = _id;
        this.title = title;
        this.number = number;
        this.date = date;
        this.image = image;

    }

    @Override
    public String toString() {
        String msg = String.format(
                Locale.getDefault(),
                "ชื่อร้าน: %s"+ "\n"+
                        "ชื่อโปรโมชั่น: %s"+ "\n" +
                        "วันที่: %s"+ "\n" +
                        "\n"+
                        "รายละเอียด:"+"\n"+"%s",

                this.title,
                this.number,
                this.date,
                this.image

        );
        return msg;
    }
}
