package com.example.eatateeaten;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.eatateeaten.db.DB_NAME;

import static com.example.eatateeaten.db.DB_NAME.COL_DATE2;
import static com.example.eatateeaten.db.DB_NAME.COL_DETAIL2;
import static com.example.eatateeaten.db.DB_NAME.COL_ID2;
import static com.example.eatateeaten.db.DB_NAME.COL_PROMOTION2;
import static com.example.eatateeaten.db.DB_NAME.COL_TITLE2;
import static com.example.eatateeaten.db.DB_NAME.DETAIL_PROMO;

public class EditPromotion extends AppCompatActivity {
    private EditText id_name_edit;
    private EditText name_pro_edit;
    private EditText date_edit;
    private EditText detail_edit;
    private Button mSaveButton;

    private long mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_promotion);

        Intent intent = getIntent();
        String id_name = intent.getStringExtra("title");
        String name_pro = intent.getStringExtra("number");
        String date = intent.getStringExtra("date");
        String detail = intent.getStringExtra("detail");
        mId = intent.getLongExtra("id", 0);

        id_name_edit = findViewById(R.id.id_name);
        name_pro_edit = findViewById(R.id.name_pro);
        date_edit = findViewById(R.id.date);
        detail_edit = findViewById(R.id.detail);
        mSaveButton = findViewById(R.id.save_button);

        id_name_edit.setText(id_name);
        name_pro_edit.setText(name_pro);
        date_edit.setText(date);
        detail_edit.setText(detail);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo: บันทึกข้อมูลใหม่ลง db
                DB_NAME helper = new DB_NAME(EditPromotion.this);
                SQLiteDatabase db = helper.getWritableDatabase();

                String newIdName = id_name_edit.getText().toString().trim();
                String newNamePro = name_pro_edit.getText().toString().trim();
                String newDate = date_edit.getText().toString().trim();
                String newDetail = detail_edit.getText().toString().trim();

                ContentValues cv = new ContentValues();
                cv.put(COL_TITLE2, newIdName);
                cv.put(COL_PROMOTION2, newNamePro);
                cv.put(COL_DATE2, newDate);
                cv.put(COL_DETAIL2, newDetail);

                db.update(
                        DETAIL_PROMO,
                        cv,
                        COL_ID2 + " = ?",
                        new String[]{String.valueOf(mId)}
                );
                finish();
            }
        });
    }
}
