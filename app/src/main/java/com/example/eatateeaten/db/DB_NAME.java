package com.example.eatateeaten.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DB_NAME extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "promotion.db";
    private static final int DATABASE_VERSION = 1;

    public static final String NAME_RES = "name";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "title";
    public static final String COL_IMAGE = "image";

    private static final String SQL_CREATE_TABLE_NAME
            = "CREATE TABLE " + NAME_RES + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_TITLE + " TEXT,"
            + COL_IMAGE + " TEXT"
            + ")";
    public static final String DETAIL_PROMO = "promo";
    public static final String COL_ID2 = "id";
    public static final String COL_TITLE2 = "title";
    public static final String COL_PROMOTION2 = "number";
    public static final String COL_DETAIL2 = "promotion";
    public static final String COL_DATE2 = "date";

    private static final String SQL_CREATE_TABLE_PHONE2
            = "CREATE TABLE " + DETAIL_PROMO + "("
            + COL_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_TITLE2 + " TEXT,"
            + COL_PROMOTION2 + " TEXT,"
            + COL_DATE2 + " TEXT,"
            + COL_DETAIL2 + " TEXT"
            + ")";

    public DB_NAME(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_NAME);

        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, "The Pizza Company");
        cv.put(COL_IMAGE,"the-pizza-company.jpg");
        db.insert(NAME_RES, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Sizzler");
        cv.put(COL_IMAGE,"Sizzler.jpg");
        db.insert(NAME_RES, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Mcdonald's");
        cv.put(COL_IMAGE,"mcdonalds.jpg");
        db.insert(NAME_RES, null, cv);


        cv = new ContentValues();
        cv.put(COL_TITLE, "MK Restaurant");
        cv.put(COL_IMAGE,"MK.jpg");
        db.insert(NAME_RES, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "KFC");
        cv.put(COL_IMAGE,"KFC.jpg");
        db.insert(NAME_RES, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "RedSun");
        cv.put(COL_IMAGE,"redsun.jpg");
        db.insert(NAME_RES, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Santa Fe'");
        cv.put(COL_IMAGE,"santafe.jpg");
        db.insert(NAME_RES, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "HotPot");
        cv.put(COL_IMAGE,"hotpot.jpg");
        db.insert(NAME_RES, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Pizza Hut");
        cv.put(COL_IMAGE,"Pizza_hut.jpg");
        db.insert(NAME_RES, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Fuji Restaurant");
        cv.put(COL_IMAGE,"Fuji.jpg");
        db.insert(NAME_RES, null, cv);

        db.execSQL(SQL_CREATE_TABLE_PHONE2);

        ContentValues cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "Sizzler");
        cv1.put(COL_PROMOTION2, "เมนูใหม่สไตล์ไทย 2 เมนูใหม่ ราคาพิเศษ!");
        cv1.put(COL_DATE2,"วันนี้ - 31 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "ความอร่อยแบบตำรับไทย" +
                "\n" +
                "จากซิซซ์เล่อร์ แนะนำ 2 เมนูใหม่" +
                "\n" +
                "ข้าวเหนียวหมูย่างซิซซ์เล่อร์ ราคา 339 บาท" +
                "\n" +
                "และข้าวเหนียวไก่ย่างซิซซ์เล่อร์ ราคา 299 บาท อร่อยแซ่บสะใจ" +
                "\n" +
                "เสิร์ฟพร้อมน้ำจิ้มแจ่วและสลัดแครอทซอย" +
                "\n" +
                "พร้อมมะเขือเทศราชินีราดซอสสไตล์อีสาน" +
                "\n" +
                "การันตีความแซ่บ");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "Sizzler");
        cv1.put(COL_PROMOTION2, "โปรโมชั่น Sizzler Lunch Special 4 เมนูเด็ดราคาเดียว 239 บาท");
        cv1.put(COL_DATE2,"วันนี้ - 20 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "Lunch Special 4 เมนูเด็ดราคาเริ่มต้น 239 บาท " +
                "\n" +
                "เสิร์ฟคู่กับโค้กรีฟีล และ Sizzler Bar ได้ไม่อั้น\n" +
                "\n" +
                "คุ้มขนาดนี้ห้ามพลาดครับ สั่งได้ทุกจันทร์ – ศุกร์ (ยกเว้นวันหยุดนักขัตฤกษ์)" +
                "\n" +
                "ตั้งแต่ 10.00 – 15.00 น. ");
        db.insert(DETAIL_PROMO, null,cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "Sizzler");
        cv1.put(COL_PROMOTION2, "จ่ายเพียง 139 บาท ก็ทานสลัดบาร์ได้ไม่อั้น จุใจกว่า 60 เมนู");
        cv1.put(COL_DATE2,"10 - 20 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "ซิซซ์เล่อร์ต่อเวลาแห่งความสุขให้อิ่มใจ" +
                "\n" +
                "ไปกับ Promotion Salad Bar 139 บาท" +
                "\n" +
                "ที่รวม ซุป สลัด พาสต้า ของหวาน ผลไม้ให้คุณอิ่มได้ไม่อั้น" +
                "\n" +
                "อ้อ...Promotion Sizzler Salad Bar 139 บาท" +
                "\n" +
                "สามารถทานได้ทุกสาขา");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "The Pizza Company");
        cv1.put(COL_PROMOTION2, "ถูกกว่าตั้งแต่ถาดแรกแค่ 129 บาท มีให้เลือกถึง 4 หน้า 4 สไตล์");
        cv1.put(COL_DATE2,"1 - 15 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "ถูกกว่าตั้งแต่ถาดแรกแค่ 129 บาท\n" +
                "มีให้เลือกถึง 4 หน้า 4 สไตล์\n" +
                "ทั้ง ปูอัดค็อกเทล ซอสเซจดีไลท์ ชิลลี่บาร์บีคิวชิกเก้น\n" +
                "หรือแฮมแอนด์เบคอน หรือจะเปลี่ยนเป็นแป้งบางกรอบก็ได้นะเออ\n" +
                "พร้อมส่ง พร้อมเสิร์ฟ ทั่วไทย แล้ววันนี้");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "The Pizza Company");
        cv1.put(COL_PROMOTION2, "โค้งสุดท้ายซื้อ 1 เเถม 1");
        cv1.put(COL_DATE2,"วันนี้ - 31 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "ต้องมาจัดให้อิ่มกันไปเลย‼\n" +
                "M Card ซื้อพิซซ่า 1 ถาด แถมฟรี 1 ถาด‼\n" +
                "ตั้งแต่ 2 - 30 ธ.ค. 2561\n" +
                "จำกัด 1 สิทธิ์ / ใบเสร็จ \n" +
                "สามารถใช้ได้ที่ The Pizza Company");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1= new ContentValues();
        cv1.put(COL_TITLE2, "The Pizza Company");
        cv1.put(COL_PROMOTION2, "อิ่มอร่อยไปกับเซ็ตคู่พิซซ่าและไก่");
        cv1.put(COL_DATE2,"12 - 15 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "อิ่มอร่อยไปกับเซ็ตคู่พิซซ่าและไก่" +
                "\n" +
                "บริการจัดส่งไม่หวั่นแม้วันฝนตก คุ้มสุดกับพิซซ่า 2 ถาด" +
                "\n" +
                "หนานุ่มและบางกรอบ กับ ปีกไก่อีก 6 ชิ้นนน!");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "MK Restaurant");
        cv1.put(COL_PROMOTION2, "อิ่มอร่อยครบเต็มๆ ได้ทุกจาน เพียง 129 บาท");
        cv1.put(COL_DATE2,"วันนี้ - 31 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "MK ให้คุณอิ่มอร่อยครบเต็มๆ " +
                "\n" +
                "ได้ทุกจาน เพียง 129 บาท" +
                "\n" +
                "ทั้งครบทั้งคุ้มกินใจกว่านี้ไม่มีอีกแล้ว" +
                "\n" +
                "ทั้งข้าวหน้าต่างๆ ไข่มะตูม ติ่มซำ และน้ำซุป");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "MK Restaurant");
        cv1.put(COL_PROMOTION2, "MK ชุดชีส ซี๊ด แซ่บ สุดคุ้ม");
        cv1.put(COL_DATE2,"วันนี้ - 31 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "พิเศษ!!! ชุดชีส ซี๊ด แซ่บ สุดคุ้ม MK Restaurant ร่วมกับศูนย์การค้าเทสโก้ โลตัส มอบสิทธิ์ประโยชน์สุดคุ้ม สำหรับลูกค้าที่เข้าใช้บริการร้าน MK Restaurant ในศูนย์การค้าเทสโก้ โลตัส สามารถสั่งชุด ชีส ซี๊ด แซ่บ สุดคุ้ม ในราคาเพียง 199 บาท จากปกติ 259 บาท ");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "Santa Fe'");
        cv1.put(COL_PROMOTION2, "เทศกาล KUROBUTA FESTIVAL เพียง 99 บาท");
        cv1.put(COL_DATE2,"วันนี้ - 31 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "เทศกาล KUROBUTA FESTIVAL ยกขบวนหมูดำคูโรบูตะมาเสิร์ฟความสุขในราคาสุดพิเศษ และพิเศษสุดๆกับเมนู สันคอหมูคูโรบูตะ สูตรหมักพริกไทย สันคอหมูคูโรบูตะหมักพริกไทยจนนุ่ม ๆ อิ่มอร่อยในราคาเบา ๆ เพียง 99 บาท");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "RedSun");
        cv1.put(COL_PROMOTION2, "ฉลองครบรอบเรดซัน7 ปีแชมป์เปี้ยน จุใจไปกับเซตเมนูสุดพิเศษ พี่หมีใจปล้ำ 599 บาท เเละ 899 บาท");
        cv1.put(COL_DATE2,"วันนี้ - 31 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "วันนี้พี่หมีโกมิมาพร้อมกับเซตพี่หมีใจปล้ำ 599 บาท" +
                "\n" +
                "เเละ 899 บาท ฉลองครบรอบ Red Sun 7 ปีแชมป์เปี้ยน" +
                "\n" +
                "ยกทัพเมนูแสนอร่อยมาให้ออเจ้าได้ลองลิ้มชิมรสกันดู");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "HotPot");
        cv1.put(COL_PROMOTION2, "อร่อยไม่อั้นแบบไม่ต้องแอบแค่ 299 บาท ที่ HOTPOT");
        cv1.put(COL_DATE2,"1 - 31 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "โปรโมชั่นยอดฮิตลดพิเศษเหลือเพียง 299 บาท (จากราคาปกติ 379 บาท)" +
                "\n" +
                "เตรียมตัวมาฟินกับหม้อ 4 ช่อง น้ำซุป 4 รสชาติถูกใจคนไทย" +
                "\n" +
                "ที่เรากล้าท้าให้คุณลอง ไม่ว่าจะเป็นซุปสุกี้ญี่ปุ่นสุดกลมกล่อม" +
                "\n" +
                "ซุปมิโซะนาเบะสไตล์ญี่ปุ่น ซุปต้มยำรสจัดจ้าน" +
                "\n" +
                "และน้ำซุปเปอร์รสแซ่บ รับประกันความฟินเหมือนเดิม");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "HotPot");
        cv1.put(COL_PROMOTION2, "โปรโมชั่นร้อนแรงลดกระหน่ำ 20% ที่ HOT POT ทุกสาขา");
        cv1.put(COL_DATE2,"5 - 31 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "โปรระดับทศวรรษ …โปรโมชั่นร้อนแรงลดกระหน่ำ 20% ที่ HOT POT ทุกสาขานะ" +
                "\n" +
                "จัดกันต่อเนื่องอย่างยาวนานกว่า 10 ปี" +
                "\n" +
                "และเราจะยืดหยัดจัดโปรโมชั่นระดับตำนานต่อเนื่องตลอดไป" +
                "\n" +
                "“ทุกวันพุธ จัดหนัก จัดเต็ม”" +
                "\n" +
                "ที่ Hot Pot D.I.Y. Buffet เท่านั้น ทุกมื้อจัดเต็มด้วยใจ");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "Pizza Hut");
        cv1.put(COL_PROMOTION2, "ชีสซี่ซอสเซจไบท์ เพียง!! 299.-");
        cv1.put(COL_DATE2,"วันนี้ - 31 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "ชัดเจน! ลองมาคิดดูดีๆ แล้ว ชีสซี่ซอสเซจไบท์นี่คือได้เยอะกว่าราคามาก คุ้มจริงจังเว่อร์!");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "Pizza Hut");
        cv1.put(COL_PROMOTION2, "พิซซ่าถาดกลางถาดแรก 199.- ถาดที่สองเพียง 99.-");
        cv1.put(COL_DATE2,"วันนี้ - 31 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "วันหยุดแบบนี้ ต้องอร่อยวนไปอย่าให้สะดุด" +
                "\n" +
                "ก็ตอนนี้พิซซ่าฮัทมีโปรซื้อพิซซ่าถาดกลางถาดแรก 199 บาท" +
                "\n" +
                "ได้อร่อยต่อกับถาดที่สองในราคาเพียง 99 บาท" +
                "\n" +
                "แถมยังมีพิซซ่าให้เลือกถึง 9 หน้า");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "KFC");
        cv1.put(COL_PROMOTION2, "ชุดไก่จัดใหญ่ เพียง 199 บาท จากปกติ 268 บาท");
        cv1.put(COL_DATE2,"1 พ.ย. - 31 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "โปรด่วน! โปรใหม่! ชุดไก่จัดใหญ่ เพียง 199 บาท เลือกอร่อยกับเมนูไก่ในเซ็ทที่หลากหลาย คุ้มมากสุดๆ ทั้งไก่ทอด 5 ชิ้น, วิงซ์แซ่บ 3 ชิ้น, นักเก็ตส์ 3 ชิ้น ชุดไก่จัดใหญ่ อัดให้แบบจัดเต็ม");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "Mcdonald's");
        cv1.put(COL_PROMOTION2, "กลับมาแล้ว! McSaver 1+1 เมนูคุ้มเว่อร์ 2 เมนู แค่ 49 บาท");
        cv1.put(COL_DATE2,"16 พ.ย. - 20 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "กลับมาแล้ว! McSaver 1+1 เมนูคุ้มเว่อร์ 2 เมนู แค่ 49 บาท \n" +
                "\n" +
                "เลือกง่ายๆ จะของว่าง+ของหวาน หรือจะเลือกของหวาน+ของหวานก็แค่ 49\n" +
                "\n" +
                "พิเศษกว่าเดิม! เพิ่มความฟินกับแมคไก่ทอดใหญ่เผ็ดอีกแค่ 20 บาทเท่านั้น");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "Mcdonald's");
        cv1.put(COL_PROMOTION2, "McDonald’s แมคนักเก็ต ลด 50% ทุกศุกร์ เสาร์ อาทิตย์");
        cv1.put(COL_DATE2,"16 พ.ย. - 20 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "แมคนักเก็ต (Chicken McNuggets) ลดราคา 50% " +
                "\n" +
                "ทุกวันศุกร์-เสาร์-อาทิตย์ เท่านั้น" +
                "\n" +
                "รู้แบบนี้แล้ว อย่ารอช้า อิ่มอร่อยแบบคุ้มๆ" +
                "\n" +
                "ได้แล้ววันนี้ ที่แมคโดนัลด์" +
                "\n" +
                "เฉพาะสุดสัปดาห์ วันศุกร์-เสาร์-อาทิตย์  ");
        db.insert(DETAIL_PROMO, null, cv1);

        cv1 = new ContentValues();
        cv1.put(COL_TITLE2, "Fuji restaurant");
        cv1.put(COL_PROMOTION2, "ฟูจิร่วมฉลองครบรอบ 50 ปี รับส่วนลด 50%");
        cv1.put(COL_DATE2,"วันนี้ - 31 ธ.ค. 2561");
        cv1.put(COL_DETAIL2, "สัมผัสรสชาติไก่เนื้อนุ่ม ละมุนลิ้น จาก S-Pure" +
                "\n" +
                "ที่นำมาผสมผสานปรุงรสตามแบบฉบับของฟูจิ" +
                " \n" +
                "Chicken Spicy age 50 บาท / Set 85 บาท" +
                "\n" +
                "Chicken Steak with Pepper Sauce Set 125 บาท" +
                "\n" +
                "Chicken Teriyaki 65 บาท / Set 80 บาท");
        db.insert(DETAIL_PROMO, null, cv1);
}


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
