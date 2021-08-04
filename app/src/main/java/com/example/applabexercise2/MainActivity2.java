package com.example.applabexercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tv = findViewById(R.id.output);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String emp_name = bundle.getString("name");
        String emp_id = bundle.getString("id");
        String basic_salary = bundle.getString("basic_salary");
        String hra = bundle.getString("Hra");
        String da = bundle.getString("da");
        String Gross = bundle.getString("gross");
        String Net = bundle.getString("net");

        String selecteddata = bundle.getString("Gender");

        ArrayList<String> list = bundle.getStringArrayList("Skills");
        String outputtxt = "";
        for(String item : list){
            outputtxt += item + "\n";
        }
        tv.setText("Name :"+emp_name+"\n"+
                "Emp id :"+emp_id+"\n"+
                "Basic salary :"+basic_salary+"\n"+
                "Hra :"+hra+"\n"+
                "da :"+da+"\n"+
                "Gender :"+selecteddata+"\n"+
                "Skills :"+list+"\n"+
                "Gross Salary :"+Gross+"\n"+
                "Net Salary :"+Net+"\n");

}
}