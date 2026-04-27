package com.example.sqliteapp;



import android.database.Cursor;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name, email;
    EditText id;
    Button insert, view, update, delete;

    RecyclerView recyclerView;
    ArrayList<String> listData;
    MyAdapter adapter;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = findViewById(R.id.editId);
        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmail);

        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);

        recyclerView = findViewById(R.id.recyclerView);

        db = new DBHelper(this);

        // RecyclerView setup
        listData = new ArrayList<>();
        adapter = new MyAdapter(listData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // INSERT
        insert.setOnClickListener(v -> {
            boolean res = db.insertData(
                    name.getText().toString(),
                    email.getText().toString()
            );
            Toast.makeText(this, res ? "Inserted" : "Failed", Toast.LENGTH_SHORT).show();
        });

        // VIEW (Display in RecyclerView)
        view.setOnClickListener(v -> {
            Cursor cursor = db.getData();
            listData.clear();

            if (cursor.getCount() == 0) {
                listData.add("No Data Found");
            } else {
                while (cursor.moveToNext()) {
                    String record = "ID: " + cursor.getString(0) +
                            "\nName: " + cursor.getString(1) +
                            "\nEmail: " + cursor.getString(2);

                    listData.add(record);
                }
            }

            adapter.notifyDataSetChanged();
        });

        // UPDATE (demo using ID = 1)
        update.setOnClickListener(v -> {
            boolean res = db.updateData(
                    id.getText().toString(),
                    name.getText().toString(),
                    email.getText().toString()
            );

            Toast.makeText(this, res ? "Updated" : "Failed", Toast.LENGTH_SHORT).show();
        });

        // DELETE (demo using ID = 1)
        delete.setOnClickListener(v -> {
            int res = db.deleteData(id.getText().toString());

            Toast.makeText(this, res > 0 ? "Deleted" : "Failed", Toast.LENGTH_SHORT).show();
        });
    }
}