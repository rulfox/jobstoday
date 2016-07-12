package x.x.x.jobstoday;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button reg_submit,reg_cancel,reg_btn_datepick;
    Button reg_datepicker;
    EditText reg_date,reg_pname,reg_address,reg_uname,reg_pass,reg_cpass;
    static final int DATE_PICKER_ID = 1;
    int year,month,day;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reg_pname= (EditText) findViewById(R.id.reg_pname);
        reg_address= (EditText) findViewById(R.id.reg_address);
        reg_uname= (EditText) findViewById(R.id.reg_username);
        reg_pass= (EditText) findViewById(R.id.reg_Password);
        reg_cpass= (EditText) findViewById(R.id.reg_confirm_password);
        reg_date= (EditText) findViewById(R.id.reg_date);

        reg_datepicker= (Button) findViewById(R.id.reg_datepicker);
        reg_submit= (Button) findViewById(R.id.reg_submit);
        reg_cancel= (Button) findViewById(R.id.reg_cancel);

        //Getting current date
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        reg_datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Date picker dialog is poped up
                showDialog(DATE_PICKER_ID);
            }
        });

        reg_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean complete=true;

                if(TextUtils.isEmpty(reg_pname.getText()))
                {
                    reg_pname.setError("Field Required");
                    complete=false;
                }
                if(TextUtils.isEmpty(reg_address.getText()))
                {
                    reg_address.setError("Field Required");
                    complete=false;
                }
                if(TextUtils.isEmpty(reg_date.getText()))
                {
                    reg_date.setError("Field Required");
                    complete=false;
                }
                if(TextUtils.isEmpty(reg_uname.getText()))
                {
                    reg_uname.setError("Field Required");
                    complete=false;
                }
                if(TextUtils.isEmpty(reg_pass.getText()))
                {
                    reg_pass.setError("Field Required");
                    complete=false;
                }
                if(TextUtils.isEmpty(reg_cpass.getText()))
                {
                    reg_cpass.setError("Field Required");
                    complete=false;
                }
                if(!reg_pass.getText().toString().equals(reg_cpass.getText().toString()))
                {
                    complete=false;
                    reg_pass.setError("");
                    reg_cpass.setError("");
                    Toast.makeText(MainActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                }
                if(complete==true)
                {
                    Toast.makeText(MainActivity.this, "Registration Succesful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reg_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Registration Cancelled", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,Login.class));
            }
        });
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == DATE_PICKER_ID) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        reg_date.setText(day+"/"+month+"/"+year);
    }
}
