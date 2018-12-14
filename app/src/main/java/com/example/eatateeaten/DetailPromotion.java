package com.example.eatateeaten;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eatateeaten.db.DB_NAME;
import com.example.eatateeaten.model.Item;
import com.example.eatateeaten.model.PromoItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.eatateeaten.db.DB_NAME.COL_DATE2;
import static com.example.eatateeaten.db.DB_NAME.COL_DETAIL2;
import static com.example.eatateeaten.db.DB_NAME.COL_ID2;
import static com.example.eatateeaten.db.DB_NAME.COL_PROMOTION2;
import static com.example.eatateeaten.db.DB_NAME.COL_TITLE2;
import static com.example.eatateeaten.db.DB_NAME.DETAIL_PROMO;


public class DetailPromotion extends AppCompatActivity {
    private DB_NAME mHelper;
    private SQLiteDatabase mDb;
    private List<PromoItem> mPromoItemList;
    private String Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_promotion);

        mHelper = new DB_NAME(DetailPromotion.this);
        mDb = mHelper.getWritableDatabase();

        Title = getIntent().getStringExtra("title");
        Button addPhoneItemButton = findViewById(R.id.add_button);
        addPhoneItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailPromotion.this,AddPromotion.class);
                intent.putExtra("title", Title);
                startActivity(intent);
            }
        });

    }
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadPhoneData();
        setupListView();
    }
    private void loadPhoneData() {
        Cursor c = mDb.query(DETAIL_PROMO, null, null, null, null, null, null);

        mPromoItemList = new ArrayList<>();
        while (c.moveToNext()) {
            long id = c.getLong(c.getColumnIndex(COL_ID2));
            String title = c.getString(c.getColumnIndex(COL_TITLE2));
            String number = c.getString(c.getColumnIndex(COL_PROMOTION2));
            String date = c.getString(c.getColumnIndex(COL_DATE2));
            String promotion = c.getString(c.getColumnIndex(COL_DETAIL2));

            if (Title.indexOf(title) != -1){
            PromoItem item = new PromoItem(id, title, number,date,promotion);
            mPromoItemList.add(item);
            }
        }
        c.close();
    }

    private void setupListView() {
        ArrayAdapter<PromoItem> adapter = new ArrayAdapter<>(
                DetailPromotion.this,
                android.R.layout.simple_list_item_1,
                mPromoItemList
        );
        ListView lv = findViewById(R.id.promo_list);
        lv.setAdapter(adapter);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                String[] items = new String[]{
                        "Edit",
                        "Delete"
                };

                new AlertDialog.Builder(DetailPromotion.this)
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                final PromoItem phoneItem = mPromoItemList.get(position);

                                switch (i) {
                                    case 0: // Edit
                                        Intent intent = new Intent(DetailPromotion.this, EditPromotion.class);
                                        intent.putExtra("title", phoneItem.title);
                                        intent.putExtra("number", phoneItem.number);
                                        intent.putExtra("date", phoneItem.date);
                                        intent.putExtra("detail", phoneItem.image);
                                        intent.putExtra("id", phoneItem._id);
                                        startActivity(intent);
                                        break;
                                    case 1: // Delete
                                        new AlertDialog.Builder(DetailPromotion.this)
                                                .setMessage("ต้องการลบรายการนี้ ใช่หรือไม่")
                                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        mDb.delete(
                                                                DETAIL_PROMO,
                                                                COL_ID2 + " = ?",
                                                                new String[]{String.valueOf(phoneItem._id)}
                                                        );
                                                        loadPhoneData();
                                                        setupListView();
                                                    }
                                                })
                                                .setNegativeButton("No", null)
                                                .show();
                                        break;
                                }
                            }
                        })
                        .show();

                return true;
            }
        });
    }
}
