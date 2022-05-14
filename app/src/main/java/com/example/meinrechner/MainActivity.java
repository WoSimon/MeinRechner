package com.example.meinrechner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Timestamp;

public class MainActivity extends AppCompatActivity {

    double op1 = 0, op2 = 0, result = 0;
    char operator = '\0';
    TextView calculationView, resultView;
    boolean Add, Sub, Multiply, Divide, deci;
    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_Add, button_Sub,
            button_Mul, button_Div, button_Equ, button_Del, button_Dot;
    ImageButton button_History;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_0 = (Button) findViewById(R.id.zeroBTN);
        button_1 = (Button) findViewById(R.id.einsBTN);
        button_2 = (Button) findViewById(R.id.zweiBTN);
        button_3 = (Button) findViewById(R.id.dreiBTN);
        button_4 = (Button) findViewById(R.id.vierBTN);
        button_5 = (Button) findViewById(R.id.fuenfBTN);
        button_6 = (Button) findViewById(R.id.sechsBTN);
        button_7 = (Button) findViewById(R.id.siebenBTN);
        button_8 = (Button) findViewById(R.id.achtBTN);
        button_9 = (Button) findViewById(R.id.neunBTN);
        button_Dot = (Button) findViewById(R.id.punktBTN);
        button_Add = (Button) findViewById(R.id.plusBTN);
        button_Sub = (Button) findViewById(R.id.minusBTN);
        button_Mul = (Button) findViewById(R.id.malBTN);
        button_Div = (Button) findViewById(R.id.geteiltBTN);
        button_History = (ImageButton) findViewById(R.id.vergangenBTN);
        button_Del = (Button) findViewById(R.id.loeschenBTN);
        button_Equ = (Button) findViewById(R.id.gleichBTN);

        calculationView = (TextView) findViewById(R.id.calculationView);
        resultView = (TextView) findViewById(R.id.resultView);

        //RFH Logo in der ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.ic_logo_rheinischefhkoeln);


        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText() != ("")) {
                    result = 0;
                    resultView.setText("");
                    calculationView.setText("");
                }
                calculationView.setText(calculationView.getText() + "1");
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText() != ("")) {
                    result = 0;
                    resultView.setText("");
                    calculationView.setText("");
                }
                calculationView.setText(calculationView.getText() + "2");
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText() != ("")) {
                    result = 0;
                    resultView.setText("");
                    calculationView.setText("");
                }
                calculationView.setText(calculationView.getText() + "3");
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText() != ("")) {
                    result = 0;
                    resultView.setText("");
                    calculationView.setText("");
                }
                calculationView.setText(calculationView.getText() + "4");
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText() != ("")) {
                    result = 0;
                    resultView.setText("");
                    calculationView.setText("");
                }
                calculationView.setText(calculationView.getText() + "5");
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText() != ("")) {
                    result = 0;
                    resultView.setText("");
                    calculationView.setText("");
                }
                calculationView.setText(calculationView.getText() + "6");
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText() != ("")) {
                    result = 0;
                    resultView.setText("");
                    calculationView.setText("");
                }
                calculationView.setText(calculationView.getText() + "7");
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText() != ("")) {
                    result = 0;
                    resultView.setText("");
                    calculationView.setText("");
                }
                calculationView.setText(calculationView.getText() + "8");
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText() != ("")) {
                    result = 0;
                    resultView.setText("");
                    calculationView.setText("");
                }
                calculationView.setText(calculationView.getText() + "9");
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText() != ("")) {
                    result = 0;
                    resultView.setText("");
                    calculationView.setText("");
                }
                calculationView.setText(calculationView.getText() + "0");
            }
        });

        button_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText() != ("")) {
                    result = 0;
                    resultView.setText("");
                    calculationView.setText("");
                    Toast.makeText(MainActivity.this, "Bitte zuerst eine Zahl eingeben", Toast.LENGTH_SHORT).show();
                }
                if (calculationView.getText().length() != 0 && !(calculationView.getText().equals("."))) {
                    op1 = Double.parseDouble(calculationView.getText() + "");
                    op1 = Double.parseDouble(String.format("%.2f", op1));
                    Add = true;
                    deci = false;
                    operator = '+';
                    calculationView.setText(op1 + " + ");
                }
                else{
                    //Fehlermeldung wenn keine Zahl eingegeben wurde
                    Toast.makeText(MainActivity.this, "Bitte zuerst eine Zahl eingeben", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText() != ("")) {
                    result = 0;
                    resultView.setText("");
                    calculationView.setText("");
                    Toast.makeText(MainActivity.this, "Bitte zuerst eine Zahl eingeben", Toast.LENGTH_SHORT).show();
                }
                if (calculationView.getText().length() != 0 && !(calculationView.getText().equals("."))) {
                    op1 = Double.parseDouble(calculationView.getText() + "");
                    op1 = Double.parseDouble(String.format("%.2f", op1));
                    Sub = true;
                    deci = false;
                    operator = '-';
                    calculationView.setText(op1 + " - ");
                }
                else{
                    //Fehlermeldung wenn keine Zahl eingegeben wurde
                    Toast.makeText(MainActivity.this, "Bitte zuerst eine Zahl eingeben", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText() != ("")) {
                    result = 0;
                    resultView.setText("");
                    calculationView.setText("");
                    Toast.makeText(MainActivity.this, "Bitte zuerst eine Zahl eingeben", Toast.LENGTH_SHORT).show();
                }
                if (calculationView.getText().length() != 0 && !(calculationView.getText().equals("."))) {
                    op1 = Double.parseDouble(calculationView.getText() + "");
                    op1 = Double.parseDouble(String.format("%.2f", op1));
                    Multiply = true;
                    deci = false;
                    operator = '*';
                    calculationView.setText(op1 + " * ");
                }
                else{
                    //Fehlermeldung wenn keine Zahl eingegeben wurde
                    Toast.makeText(MainActivity.this, "Bitte zuerst eine Zahl eingeben", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText() != ("")) {
                    result = 0;
                    resultView.setText("");
                    calculationView.setText("");
                }
                if (calculationView.getText().length() != 0 && !(calculationView.getText().equals("."))) {
                    op1 = Double.parseDouble(calculationView.getText() + "");
                    op1 = Double.parseDouble(String.format("%.2f", op1));
                    Divide = true;
                    deci = false;
                    operator = '/';
                    calculationView.setText(op1 + " / ");
                }
            }
        });

        button_History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (MainActivity.this, HistoryActivity.class));
            }
        });

        button_Equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op2 = Double.parseDouble(calculationView.getText().toString().substring(calculationView.getText().toString().indexOf(" ")).substring(3));
                op2 = Double.parseDouble(String.format("%.2f", op2));
                deci = false;
                if (calculationView.getText().length() == 0 && !(calculationView.getText().equals("."))) {
                    Toast.makeText(MainActivity.this, "Bitte zuerst eine Zahl eingeben", Toast.LENGTH_SHORT).show();
                }
                else if (Add || Sub || Multiply || Divide) {
                    if (Add) {
                        calculationView.setText(op1 + " + " + op2 + " = ");
                        result = Double.parseDouble(String.format("%.2f", op1 + op2));
                        resultView.setText(result + "");
                        Add = false;
                    }

                    if (Sub) {
                        calculationView.setText(op1 + " - " + op2 + " = ");
                        result = Double.parseDouble(String.format("%.2f", op1 - op2));
                        resultView.setText(result + "");
                        Sub = false;
                    }
                    if (Multiply) {
                        calculationView.setText(op1 + " * " + op2 + " = ");
                        result = Double.parseDouble(String.format("%.2f", op1 * op2));
                        resultView.setText(result + "");
                        Multiply = false;
                    }
                    if (Divide) {
                        calculationView.setText(op1 + " / " + op2 + " = ");
                        result = Double.parseDouble(String.format("%.2f", op1 / op2));
                        resultView.setText(result + "");
                        Divide = false;
                    }
                }
                String timestamp = new Timestamp(System.currentTimeMillis()).toString();
                MyDatabaseHelper MyDB = new MyDatabaseHelper(MainActivity.this);
                MyDB.addCalculation(op1, Character.toString(operator), op2, result, timestamp);
                operator = '\0';
            }
        });

        button_Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationView.setText("");
                resultView.setText("");
                op1 = 0.0;
                op2 = 0.0;
                deci = false;
            }
        });

        button_Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deci) {
                    //nichts tun wenn schon eine Komma vorhanden ist
                    Toast.makeText(MainActivity.this, "Komma schon vorhanden", Toast.LENGTH_SHORT).show();
                }
                else if (resultView.getText() != ""){
                    calculationView.setText("");
                    resultView.setText(".");
                }
                else {
                    calculationView.setText(calculationView.getText() + ".");
                    deci = true;
                }


            }
        });

    }
}
