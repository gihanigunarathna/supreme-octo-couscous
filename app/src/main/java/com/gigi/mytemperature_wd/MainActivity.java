package com.gigi.mytemperature_wd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate,btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate=findViewById(R.id.btnCalculate);

    }


    @Override
    protected void onResume() {
        super.onResume();

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateAnswer();
            }
        });

    } //end of onResume

    private void calculateAnswer()
    {

        EditText et=findViewById(R.id.etTemp);
        String temp=et.getText().toString();

        if(temp.equals("")){       //empty field

                 Toast.makeText(this, "Please add a value", Toast.LENGTH_LONG).show();
        }
        else{

            //validate the value
            Float TempNumber=0.0f;

            Boolean error=Boolean.FALSE;

            Float answer=0.0f;

            try {
                TempNumber=Float.parseFloat(temp);
            }
            catch(NumberFormatException e)
            {
                Toast.makeText(this, "Invalid Entry", Toast.LENGTH_LONG).show();
                error=Boolean.TRUE;

            }
            if(!error)
            {
                RadioGroup rg=findViewById(R.id.rgTemp);

                int id=rg.getCheckedRadioButtonId();

                TextView tv=findViewById(R.id.tvResult);

                if(id==R.id.rbCelcius){

                    answer=convertFahrenheitToCelcius(TempNumber);

                } else{
                    answer=convertCelciusToFahrenheit(TempNumber);
                }

                tv.setText(answer+"");



            }







        }


    }


    protected float convertCelciusToFahrenheit(Float value)
    {
        Float ans = (value * 9/5) + 32;
        return ans;
    }
    protected float convertFahrenheitToCelcius(Float value)
    {
        Float ans = (value - 32) * 5/9;
        return ans; }





}
