package com.example.mukesh.eurousdconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConverterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        final Button convertButton = findViewById(R.id.ConvertBtn);

        convertButton.setOnClickListener(new View.OnClickListener() { //assuming that user enters only number in both the text boxes
            @Override
            public void onClick(View v) {
                TextView outputView = (TextView)findViewById(R.id.resultText);

                EditText eurTemp = (EditText)findViewById(R.id.textEur);
                String eurString = eurTemp.getText().toString();
                
                EditText usdTemp= (EditText)findViewById(R.id.textDollar);
                String usdString = usdTemp.getText().toString();
                
                if(!eurString.isEmpty() && !usdString.isEmpty()){ //user has entered values in both textbox, then clear both the textboxes and show message
                    eurTemp.setText("");
                    usdTemp.setText("");
                    outputView.setText("Please enter value in only one textbox");
                }
                else{
                    if(usdString.isEmpty()){ //user wants to convert eur to usd
                        float eurValue=Float.parseFloat(eurString);
                        outputView.setText(eurValue + " euros = " + String.valueOf(eurValue * 1.17) + " dollars");
                    }
                    else{ //user wants to convert usd to eur
                        float usdValue = Float.parseFloat(usdString);
                        outputView.setText(usdValue + " dollars = " + String.valueOf(usdValue / 1.17) +" euros");
                    }
                }
            }
        });

        final Button clearButton = findViewById(R.id.ClearBtn);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText eurTemp = (EditText)findViewById(R.id.textEur);
                EditText usdTemp= (EditText)findViewById(R.id.textDollar);
                TextView resultText = (TextView)findViewById(R.id.resultText);

                eurTemp.setText("");
                usdTemp.setText("");
                resultText.setText("");
            }
        });

    }
}
