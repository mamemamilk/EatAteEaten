package com.example.eatateeaten;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eatateeaten.adapter.NameListAdapter;
import com.example.eatateeaten.db.DB_NAME;
import com.example.eatateeaten.model.Item;
import com.example.eatateeaten.model.PromoItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.eatateeaten.db.DB_NAME.COL_ID;
import static com.example.eatateeaten.db.DB_NAME.COL_IMAGE;
import static com.example.eatateeaten.db.DB_NAME.COL_TITLE;
import static com.example.eatateeaten.db.DB_NAME.NAME_RES;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    private DB_NAME mHelper;
    private SQLiteDatabase mDb;
    private List<Item> mNameItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new DB_NAME(MainActivity.this);
        mDb = mHelper.getWritableDatabase();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadNameData();
        setupListView();
    }

    private void loadNameData() {
        Cursor c = mDb.query(NAME_RES, null, null, null, null, null, null);

        mNameItemList = new ArrayList<>();
        while (c.moveToNext()) {
            long id = c.getLong(c.getColumnIndex(COL_ID));
            String title = c.getString(c.getColumnIndex(COL_TITLE));
            String image = c.getString(c.getColumnIndex(COL_IMAGE));

           Item item = new Item(id, title, image);
            mNameItemList.add(item);
        }
        c.close();
    }

    private void setupListView() {
        NameListAdapter adapter = new NameListAdapter(
                MainActivity.this,
                R.layout.item_name,
                mNameItemList
        );
        ListView lv = findViewById(R.id.result_list_view);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Item item = mNameItemList.get(position);
                Toast t = Toast.makeText(MainActivity.this,item.title, Toast.LENGTH_SHORT);
                t.show();


                Intent intent = new Intent(MainActivity.this, DetailPromotion.class);
                intent.putExtra("title", item.title);
                startActivity(intent);
            }
        });

    }
}
