package com.example.eatateeaten;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eatateeaten.db.DB_NAME;

import static com.example.eatateeaten.db.DB_NAME.COL_DATE2;
import static com.example.eatateeaten.db.DB_NAME.COL_DETAIL2;
import static com.example.eatateeaten.db.DB_NAME.COL_PROMOTION2;
import static com.example.eatateeaten.db.DB_NAME.COL_TITLE2;
import static com.example.eatateeaten.db.DB_NAME.DETAIL_PROMO;

public class AddPromotion extends AppCompatActivity {

    private static final String TAG = AddPromotion.class.getName();

    private DB_NAME mHelper;
    private SQLiteDatabase mDb;
    private String Title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_promotion);

        mHelper = new DB_NAME(this);
        mDb = mHelper.getWritableDatabase();

        Title = getIntent().getStringExtra("title");
        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doInsertPhoneItem();
            }
        });
    }
    private void doInsertPhoneItem() {

        EditText promotionEditText = findViewById(R.id.name_pro);
        EditText dateEditText = findViewById(R.id.date);
        EditText detailEditText = findViewById(R.id.detail);

        String promotion = promotionEditText.getText().toString();
        String date = dateEditText.getText().toString();
        String detail = detailEditText.getText().toString();

        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE2, Title);
        cv.put(COL_PROMOTION2, promotion);
        cv.put(COL_DATE2,date);
        cv.put(COL_DETAIL2, detail);
        mDb.insert(DETAIL_PROMO, null, cv);

        finish();
    }
}
