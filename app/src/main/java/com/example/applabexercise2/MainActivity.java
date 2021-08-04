package com.example.applabexercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final EditText Emp_name,Emp_id,Basic_salary,Da;
       final RadioButton r1 ,r2;
       final CheckBox cb1,cb2;
       final Spinner sp;

       //fetches the spinner view and assign to spinner variable
       sp = findViewById(R.id.spinnerbox);

       //fetches the checkbox view and assigns to check box variable
       cb1=findViewById(R.id.web_check_box_view);
       cb2=findViewById(R.id.app_check_box_view);

       //fetches the radio view and assigns to radio variable
       r1=findViewById(R.id.radio_button_1);
       r2=findViewById(R.id.radio_button_2);



       //fetches the edit view and assigns to edit variables
        Emp_name = findViewById(R.id.employe_name_edit_view);
        Emp_id = findViewById(R.id.employe_id_edit_view);
        Basic_salary = findViewById(R.id.salary_edit_view);
        Da = findViewById(R.id.da_edit_view);

        Button send = findViewById(R.id.send_button_view);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String En = Emp_name.getText().toString();
                String Eid = Emp_id.getText().toString();
                String Bs = Basic_salary.getText().toString();
                String DA = Da.getText().toString();
                String Hra = sp.getSelectedItem().toString();

                String data ="";
                if(r1.isChecked())
                    data =r1.getText().toString();
                else if (r2.isChecked())
                    data =r2.getText().toString();

                ArrayList<String> list = new ArrayList<>();
                list.clear();
                if(cb1.isChecked())
                    list.add(cb1.getText().toString());
                if(cb2.isChecked())
                    list.add(cb2.getText().toString());

                int HRA = Integer.parseInt(Hra);
                int DA_INT  = Integer.parseInt(DA);
                int BS_int  = Integer.parseInt(Bs);

                int Gross_salary = BS_int + HRA + DA_INT;
                int Net_salary;
                int tax_rate =0 ;
                if(Gross_salary >=200000 && Gross_salary<400000){
                    tax_rate = 10;
                }
                else  if(Gross_salary >=400000 && Gross_salary<600000){
                    tax_rate = 20;
                }
                else  if(Gross_salary >=600000){
                    tax_rate = 30;
                }
                Net_salary =( Gross_salary - ((Gross_salary * tax_rate)/100));

                String string_Net_salary = String.valueOf(Net_salary);
                String string_Gross_salary = String.valueOf(Gross_salary);

                Log.i(TAG,"string :"+En);
                Log.i(TAG,"string :"+Eid);
                Log.i(TAG,"string :"+Bs);
                Log.i(TAG,"string :"+DA);
                Log.i(TAG,"string :"+Hra);
                Log.i(TAG,"string :"+data);
                Log.i(TAG,"string :"+list);
                Log.i(TAG,"string :"+cb1.isChecked());
                Log.i(TAG,"string :"+cb2.isChecked());
                Log.i(TAG,"string :"+Gross_salary);
                Log.i(TAG,"string :"+Net_salary);


                Intent intent =new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("name",En);
                intent.putExtra("id",Eid);
                intent.putExtra("Skills",list);
                intent.putExtra("Gender",data);
                intent.putExtra("basic_salary",Bs);
                intent.putExtra("Hra",Hra);
                intent.putExtra("da",DA);
                intent.putExtra("net",string_Net_salary);
                intent.putExtra("gross",string_Gross_salary);

                startActivity(intent);

            }
        });


    }

}