package x.x.x.jobstoday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button log_log,log_can;
    EditText log_user,log_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        log_user= (EditText) findViewById(R.id.log_user);
        log_pass= (EditText) findViewById(R.id.log_pass);

        log_log= (Button) findViewById(R.id.log_log);
        log_can= (Button) findViewById(R.id.log_can);

        log_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean complete=true;
                if(TextUtils.isEmpty(log_user.getText()))
                {
                    complete=false;
                    log_user.setError("Field required");
                }
                if(TextUtils.isEmpty(log_pass.getText()))
                {
                    complete=false;
                    log_pass.setError("Field required");
                }
                if(complete==true)
                {
                    startActivity(new Intent(Login.this,MainActivity.class));
                }
            }
        });

        log_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Login Cancelled", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Login.this,JsonCreator.class));
            }
        });

    }
}
