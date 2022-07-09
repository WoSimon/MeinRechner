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
                }
                if (calculationView.getText().length() != 0 && !(calculationView.getText().equals(".")) && operator == '\0') {
                    op1 = Double.parseDouble(calculationView.getText() + "");
                    op1 = Double.parseDouble(String.format("%.2f", op1));
                    Add = true;
                    deci = false;
                    operator = '+';
                    if (op1 % 1 == 0) {
                        String op1String = String.valueOf(op1);
                        calculationView.setText(op1String.substring(0, op1String.indexOf('.')) + " + ");
                    }
                    else {
                        calculationView.setText(op1 + " + ");
                    }
                }
                else if (!(operator == '\0')){
                    Toast.makeText(MainActivity.this, "Nicht mehr als ein Rechenzeichen möglich", Toast.LENGTH_SHORT).show();
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
                }
                if (calculationView.getText().length() != 0 && !(calculationView.getText().equals(".")) && operator == '\0') {
                    op1 = Double.parseDouble(calculationView.getText() + "");
                    op1 = Double.parseDouble(String.format("%.2f", op1));
                    Sub = true;
                    deci = false;
                    operator = '-';
                    if (op1 % 1 == 0) {
                        String op1String = String.valueOf(op1);
                        calculationView.setText(op1String.substring(0, op1String.indexOf('.')) + " - ");
                    }
                    else{
                        calculationView.setText(op1 + " - ");
                    }
                }
                else if (!(operator == '\0')){
                    Toast.makeText(MainActivity.this, "Nicht mehr als ein Rechenzeichen möglich", Toast.LENGTH_SHORT).show();
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
                }
                if (calculationView.getText().length() != 0 && !(calculationView.getText().equals(".")) && operator == '\0') {
                    op1 = Double.parseDouble(calculationView.getText() + "");
                    op1 = Double.parseDouble(String.format("%.2f", op1));
                    Multiply = true;
                    deci = false;
                    operator = '*';
                    if (op1 % 1 == 0) {
                        String op1String = String.valueOf(op1);
                        calculationView.setText(op1String.substring(0, op1String.indexOf('.')) + " * ");
                    }
                    else{
                        calculationView.setText(op1 + " * ");
                    }
                }
                else if (!(operator == '\0')){
                    Toast.makeText(MainActivity.this, "Nicht mehr als ein Rechenzeichen möglich", Toast.LENGTH_SHORT).show();
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
                if (calculationView.getText().length() != 0 && !(calculationView.getText().equals(".")) && operator == '\0') {
                    op1 = Double.parseDouble(calculationView.getText() + "");
                    op1 = Double.parseDouble(String.format("%.2f", op1));
                    Divide = true;
                    deci = false;
                    operator = '/';
                    if (op1 % 1 == 0) {
                        String op1String = String.valueOf(op1);
                        calculationView.setText(op1String.substring(0 , op1String.indexOf(('.'))) + " / ");
                    }
                    else{
                        calculationView.setText(op1 + " / ");
                    }
                }
                else if (!(operator == '\0')){
                    Toast.makeText(MainActivity.this, "Nicht mehr als ein Rechenzeichen möglich", Toast.LENGTH_SHORT).show();
                }
                else{
                    //Fehlermeldung wenn keine Zahl eingegeben wurde
                    Toast.makeText(MainActivity.this, "Bitte zuerst eine Zahl eingeben", Toast.LENGTH_SHORT).show();
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
                deci = false;
                try {
                    op2 = Double.parseDouble(calculationView.getText().toString().substring(calculationView.getText().toString().indexOf(" ")).substring(3));
                    op2 = Double.parseDouble(String.format("%.2f", op2));
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Es ist ein Fehler aufgetreten", Toast.LENGTH_SHORT).show();
                }
                if (calculationView.getText().length() == 0 && !(calculationView.getText().equals(".")) && result != 0) {
                    Toast.makeText(MainActivity.this, "Bitte zuerst eine Zahl eingeben", Toast.LENGTH_SHORT).show();
                }
                else if (String.valueOf(op1).equals("") || String.valueOf(op2).equals("") || String.valueOf(op1).equals(".") || String.valueOf(op2).equals(".") || String.valueOf(operator).equals("")) {
                    Toast.makeText(MainActivity.this, "Geben Sie eine vollständige Rechnung ein", Toast.LENGTH_SHORT).show();
                }
                else if (String.valueOf(op2).equals("")){
                    Toast.makeText(MainActivity.this, "Division durch 0 nicht möglich", Toast.LENGTH_SHORT).show();
                    resultView.setText("nDef");
                }
                else if (Add || Sub || Multiply || Divide) {
                    if (Add) {
                        switch (checkInteger(op1, op2)) {
                            case 1:
                                String op1String = String.valueOf(op1);
                                calculationView.setText(op1String.substring(0, op1String.indexOf('.')) + " + " + op2 + " = ");
                                break;
                            case 2:
                                String op2String = String.valueOf(op2);
                                calculationView.setText(op1 + " + " + op2String.substring(0, op2String.indexOf('.')) + " = ");
                                break;
                            case 3:
                                String op1String2= String.valueOf(op1);
                                String op2String2 = String.valueOf(op2);
                                calculationView.setText(op1String2.substring(0, op1String2.indexOf('.')) + " + " + op2String2.substring(0, op2String2.indexOf('.')) + " = ");
                                break;
                            default:
                                calculationView.setText(op1 + " + " + op2 + " = ");
                        }
                        result = Double.parseDouble(String.format("%.2f", op1 + op2));
                        if (result % 1 == 0) {
                            String resultString = String.valueOf(result);
                            resultView.setText(resultString.substring(0, resultString.indexOf('.')));
                        }
                        else {
                            resultView.setText(result + "");
                        }
                        Add = false;
                        String timestamp = new Timestamp(System.currentTimeMillis()).toString();
                        MyDatabaseHelper MyDB = new MyDatabaseHelper(MainActivity.this);
                        MyDB.addCalculation(op1, Character.toString(operator), op2, result, timestamp);
                    }

                    if (Sub) {
                        switch (checkInteger(op1, op2)) {
                            case 1:
                                String op1String = String.valueOf(op1);
                                calculationView.setText(op1String.substring(0, op1String.indexOf('.')) + " - " + op2 + " = ");
                                break;
                            case 2:
                                String op2String = String.valueOf(op2);
                                calculationView.setText(op1 + " - " + op2String.substring(0, op2String.indexOf('.')) + " = ");
                                break;
                            case 3:
                                String op1String2 = String.valueOf(op1);
                                String op2String2 = String.valueOf(op2);
                                calculationView.setText(op1String2.substring(0, op1String2.indexOf('.')) + " - " + op2String2.substring(0, op2String2.indexOf('.')) + " = ");
                                break;
                            default:
                                calculationView.setText(op1 + " - " + op2 + " = ");
                        }
                        result = Double.parseDouble(String.format("%.2f", op1 - op2));
                        if (result % 1 == 0) {
                            String resultString = String.valueOf(result);
                            resultView.setText(resultString.substring(0, resultString.indexOf('.')));
                        }
                        else {
                            resultView.setText(result + "");
                        }
                        Sub = false;
                        String timestamp = new Timestamp(System.currentTimeMillis()).toString();
                        MyDatabaseHelper MyDB = new MyDatabaseHelper(MainActivity.this);
                        MyDB.addCalculation(op1, Character.toString(operator), op2, result, timestamp);
                    }

                    if (Multiply) {
                        switch (checkInteger(op1, op2)) {
                            case 1:
                                String op1String = String.valueOf(op1);
                                calculationView.setText(op1String.substring(0, op1String.indexOf('.')) + " * " + op2 + " = ");
                                break;
                            case 2:
                                String op2String = String.valueOf(op2);
                                calculationView.setText(op1 + " * " + op2String.substring(0, op2String.indexOf('.')) + " = ");
                                break;
                            case 3:
                                String op1String2= String.valueOf(op1);
                                String op2String2 = String.valueOf(op2);
                                calculationView.setText(op1String2.substring(0, op1String2.indexOf('.')) + " * " + op2String2.substring(0, op2String2.indexOf('.')) + " = ");
                                break;
                            default:
                                calculationView.setText(op1 + " * " + op2 + " = ");

                        }
                        result = Double.parseDouble(String.format("%.2f", op1 * op2));
                        if (result % 1 == 0) {
                            String resultString = String.valueOf(result);
                            resultView.setText(resultString.substring(0, resultString.indexOf('.')));
                        }
                        else {
                            resultView.setText(result + "");
                        }
                        Multiply = false;
                        String timestamp = new Timestamp(System.currentTimeMillis()).toString();
                        MyDatabaseHelper MyDB = new MyDatabaseHelper(MainActivity.this);
                        MyDB.addCalculation(op1, Character.toString(operator), op2, result, timestamp);
                    }

                    if (Divide) {
                        switch (checkInteger(op1, op2)) {
                            case 1:
                                String op1String = String.valueOf(op1);
                                calculationView.setText(op1String.substring(0, op1String.indexOf('.')) + " / " + op2 + " = ");
                                break;
                            case 2:
                                String op2String = String.valueOf(op2);
                                calculationView.setText(op1 + " / " + op2String.substring(0, op2String.indexOf('.')) + " = ");
                                break;
                            case 3:
                                String op1String2= String.valueOf(op1);
                                String op2String2 = String.valueOf(op2);
                                calculationView.setText(op1String2.substring(0, op1String2.indexOf('.')) + " / " + op2String2.substring(0, op2String2.indexOf('.')) + " = ");
                                break;
                            default:
                                calculationView.setText(op1 + " / " + op2 + " = ");
                        }
                        result = Double.parseDouble(String.format("%.2f", op1 / op2));
                        if (result % 1 == 0) {
                            String resultString = String.valueOf(result);
                            resultView.setText(resultString.substring(0, resultString.indexOf('.')));
                        }
                        else {
                            resultView.setText(result + "");
                        }
                        Divide = false;
                        String timestamp = new Timestamp(System.currentTimeMillis()).toString();
                        MyDatabaseHelper MyDB = new MyDatabaseHelper(MainActivity.this);
                        MyDB.addCalculation(op1, Character.toString(operator), op2, result, timestamp);
                    }
                }
                operator = '\0';
                op1 = 0;
                op2 = 0;
            }
        });

        button_Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationView.setText("");
                resultView.setText("");
                operator = '\0';
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

    private int checkInteger (double op1, double op2) {
        if (op1 % 1 == 0 && op2 % 1 == 0) {
            return 3;
        }
        else if (op1 % 1 != 0 && op2 % 1 != 0) {
            return 4;
        }
        else if (op1 % 1 == 0 && op2 % 1 != 0) {
            return 1;
        }
        else if (op1 % 1 != 0 && op2 % 1 == 0) {
            return 2;
        }
        else {
            return 0;
    }

    }
}
