package com.example.electricity_bill_calci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etUnits;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUnits = findViewById(R.id.etUnits);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String unitStr = etUnits.getText().toString();

                if(unitStr.isEmpty()){
                    etUnits.setError("Enter units");
                    return;
                }

                int units = Integer.parseInt(unitStr);
                double bill;

                if(units <= 100){
                    bill = units * 1.5;
                }
                else if(units <= 200){
                    bill = (100 * 1.5) + (units - 100) * 2.5;
                }
                else{
                    bill = (100 * 1.5) + (100 * 2.5) + (units - 200) * 4;
                }

                tvResult.setText("Total Bill Amount: ₹ " + bill);

                // Alert Message
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Bill Generated");
                builder.setMessage("Your electricity bill is ₹ " + bill);
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });
    }
}