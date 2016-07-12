package x.x.x.jobstoday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonCreator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_creator);
        JSONArray ja=new JSONArray();
        JSONObject jo=new JSONObject();
        JSONObject subobject=new JSONObject();
        JSONObject mainobject=new JSONObject();
        try {
            //Company Details
            /*jo.put("cid","1");
            jo.put("cname","Yusoft Info Solutions");
            jo.put("calias","Palarivattom");
            jo.put("cdesc","IT Company");
            ja.put(jo);
            mainobject.put("status","true");
            mainobject.put("employee",ja);*/

            //Login
            jo.put("userid","AA001");
            jo.put("name","celia");
            jo.put("phonenumber","9902166881");
            jo.put("address","house no.234, Lane , Kerala");
            jo.put("email","celia@gmail.com");
            jo.put("dob","15-12-1991");
            jo.put("qualification","Btech");
            jo.put("usrname","yusoft");
            jo.put("password","password");
            ja.put(jo);
            mainobject.put("status","true");
            mainobject.put("UserMaster",ja);

            //interview
            jo.put("cid","1");
            jo.put("datentime","12th June, 10am");
            jo.put("venue","Yusoft");
            jo.put("designation","developer");
            jo.put("jobcode","SWdev2001");
            jo.put("salary","15k");
            jo.put("criteria","Btech");
            ja.put(jo);
            mainobject.put("status","true");
            mainobject.put("interview",ja);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.v("json",""+mainobject);
        Toast.makeText(JsonCreator.this,""+ja,Toast.LENGTH_SHORT).show();
    }
}