package com.example.meinrechner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> id, op1, operator, op2, result, timestamp;
    MyDatabaseHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        DB = new MyDatabaseHelper(this);
        id = new ArrayList<>();
        op1 = new ArrayList<>();
        operator = new ArrayList<>();
        op2 = new ArrayList<>();
        result = new ArrayList<>();
        timestamp = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(this, id, op1, operator, op2, result, timestamp);
        recyclerView.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                removeItem((String) viewHolder.itemView.getTag());
            }
        }).attachToRecyclerView(recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.ic_logo_rheinischefhkoeln);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete_all) {
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alle Einträge löschen?");
        builder.setMessage("sind Sie sicher, dass Sie alles löschen wollen?");
        builder.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(HistoryActivity.this);
                myDB.deleteAllData();
                Intent intent = new Intent(HistoryActivity.this, HistoryActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("Nein", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
            }
        });
        builder.create().show();
    }

    private void displayData() {
        Cursor cursor = DB.readAlldata();
        if (cursor.getCount() == 0) {
                Toast.makeText(HistoryActivity.this, "Noch keine Daten vorhanden", Toast.LENGTH_SHORT).show();
                return;
        }
        else {
                while (cursor.moveToNext()) {
                    id.add(cursor.getString(0));
                    //Prüfe ob Operator 1, Operator 2 und result ganzzahlig sind, wenn ja, wird nur die Zahl angezeigt
                    Double op1Double = Double.parseDouble(cursor.getString(1));
                    if (op1Double % 1 == 0) {
                        String op1String = String.valueOf(cursor.getString(1));
                        op1String = op1String.replace(".0", "");
                        op1.add(op1String);
                    }
                    else {
                        op1.add(cursor.getString(1));
                    }
                    Double op2Double = Double.parseDouble(cursor.getString(3));
                    if (op2Double % 1 == 0) {
                        String op2String = String.valueOf(cursor.getString(3));
                        op2String = op2String.replace(".0", "");
                        op2.add(op2String);
                    }
                    else {
                        op2.add(cursor.getString(3));
                    }
                    Double resultDouble;
                    try {
                        resultDouble = Double.parseDouble(cursor.getString(4));
                    }
                    catch (Exception e) {
                        resultDouble = 0.0;
                    }
                    if (resultDouble % 1 == 0) {
                        String resultString = String.valueOf(cursor.getString(4));
                        resultString = resultString.replace(".0", "");
                        result.add(resultString);
                    }
                    else {
                        result.add(cursor.getString(4));
                    }
                    //Füge dem Operanden leerzeichen hinzu
                    String operatorString = cursor.getString(2);
                    operator.add(" " + operatorString + " ");
                    //Holen den Timestamp aus der Datenbank
                    String ts = cursor.getString(5);

                    //Calendar Objekt erzeugen
                    Calendar c = Calendar.getInstance();

                    //Calendar Objekt auf den heutigen Tag setzten und in Date Objekt umwandeln
                    c.set(Calendar.HOUR_OF_DAY, 0);
                    c.set(Calendar.MINUTE, 0);
                    c.set(Calendar.SECOND, 0);
                    c.set(Calendar.MILLISECOND, 0);
                    Date today = c.getTime();

                    //Calendar Objekt auf gestern setzten und in Date Objekt umwandeln
                    c.add(Calendar.DATE, -1);
                    Date yesterday = c.getTime();

                    //Die Zeitstempel aus der Datenbank in ein Date Objekt umwandeln
                    int year = Integer.parseInt(ts.substring(0, 4));
                    int month = Integer.parseInt(ts.substring(5, 7));
                    int day = Integer.parseInt(ts.substring(8, 10));
                    c.set(Calendar.YEAR, year);
                    c.set(Calendar.MONTH, month - 1);
                    c.set(Calendar.DAY_OF_MONTH, day);
                    Date d = c.getTime();

                    //Das alte Format des Timestamps
                    SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    //Prüfe ob der Zeitstempel heute ist
                    if (d.equals(today)) {
                    //Wenn ja, Formatiere den Zeitstempel, dass er nur die Uhrzeit anzeigt
                    SimpleDateFormat to = new SimpleDateFormat("HH:mm");
                        try {
                            timestamp.add("Heute: " + to.format(from.parse(ts)));
                        }
                        catch (ParseException e) {
                            e.printStackTrace();
                            timestamp.add("");
                        }
                    }
                    //Prüfe ob der Zeitstempel gestern ist
                    else if (d.equals(yesterday)) {
                    SimpleDateFormat to = new SimpleDateFormat("HH:mm");
                        try {
                            timestamp.add("Gestern: " + to.format(from.parse(ts)));
                        }
                        catch (ParseException e) {
                            e.printStackTrace();
                            timestamp.add("");
                        }
                    }
                    //Wenn nichts von beiden, Formatiere den Zeitstempel, dass er das Datum und die Uhrzeit anzeigt
                    else {
                        try {
                            SimpleDateFormat to = new SimpleDateFormat("dd.MM.yyyy");
                            timestamp.add(to.format(from.parse(ts)));
                        } catch (ParseException e) {
                            e.printStackTrace();
                            timestamp.add("");
                        }
                    }

                }
        }
    }

    private void removeItem(String id) {
        DB.deleteOneRow(id);
        Intent intent = new Intent(HistoryActivity.this, HistoryActivity.class);
        startActivity(intent);
        finish();
    }

}