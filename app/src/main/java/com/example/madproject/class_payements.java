package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class class_payements extends AppCompatActivity {


    private ArrayList<String> data=new ArrayList<>();
    private ArrayList<String> data1=new ArrayList<>();
    private ArrayList<String> data2=new ArrayList<>();
    private ArrayList<String> data3=new ArrayList<>();

    private TableLayout table;
    EditText classid,classfee,attendence,subtotal;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_payements);


        classid=findViewById(R.id.et_cid);
        classfee=findViewById(R.id.et_fee);
        attendence=findViewById(R.id.et_atd);


        subtotal=findViewById(R.id.et_sub);

        add=findViewById(R.id.btn_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addv();
            }
        });

    }



    public  void addv()
    {
        int tot;

        String prodname=classid.getText().toString();
        int price=Integer.parseInt(classfee.getText().toString());
        int qty=Integer.parseInt(attendence.getText().toString());
        tot=tot(price,qty);


        data.add(prodname);
        data1.add(String.valueOf(price));
        data2.add(String.valueOf(qty));
        data3.add(String.valueOf(tot));



        TableLayout table=(TableLayout) findViewById(R.id.tb2);

        TableRow row=new TableRow(this);
        TextView tbl1=new TextView(this);
        TextView tbl2=new TextView(this);
        TextView tbl3=new TextView(this);
        TextView tbl4=new TextView(this);

        String total;

        int totalsum=0;

        for (int i=0;i<data.size(); i++)
        {
            String pname=data.get(i);
            String prc=data1.get(i);
            String qtyy=data2.get(i);
            total=data3.get(i);



            tbl1.setText(pname);
            tbl2.setText(prc);
            tbl3.setText(qtyy);
            tbl4.setText(total);

            totalsum= totalsum+totalsum(Integer.parseInt(data3.get(i).toString()));
        }
        row.addView(tbl1);
        row.addView(tbl2);
        row.addView(tbl3);
        row.addView(tbl4);
        table.addView(row);

        subtotal.setText(String.valueOf(totalsum));
        classid.setText("");
        classfee.setText("");
        attendence.setText("");
        classid.requestFocus();

    }
   public static int totalsum(int calc){
        int sum1=0;
        sum1 = sum1+calc;
        return sum1;
    }
    public static int tot(int price,int qty){
        return price*qty;
    }

}