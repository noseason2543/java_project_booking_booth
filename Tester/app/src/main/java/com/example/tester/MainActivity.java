package com.example.tester;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView textViewdatashow;
    EditText editTextvalue;
    Button buttonfetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewdatashow =(TextView)findViewById(R.id.tvshowdata);
        editTextvalue = (EditText)findViewById(R.id.etvalue);
        buttonfetch = (Button)findViewById(R.id.buttonfetchdata);

        buttonfetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getData();

            }
        });

    }
    private void getData() {


        String id = editTextvalue.getText().toString().trim();


        if (id.equals("")) {

            Toast.makeText(this, "Check Detail!", Toast.LENGTH_LONG).show();
            return;
        }

        String url = Config.DATA_URL + editTextvalue.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSONS(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSONS(String response) {
        String username = "";


        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            username = collegeData.getString(Config.KEY_NAME);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        textViewdatashow.setText("" + username);
    }
}
//package com.example.tester;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.MenuItem;
//import android.view.View;
//import android.graphics.Color;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//
//public class MainActivity extends AppCompatActivity {
//    public int t = 0;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
//        bottomNav.setOnNavigationItemSelectedListener(navListener);
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
//    }
//        private BottomNavigationView.OnNavigationItemSelectedListener navListener =
//                new BottomNavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                        Fragment selectedFragment = null;
//
//                        switch (item.getItemId()){
//                            case R.id.nav_home:
//                                selectedFragment = new HomeFragment();
//                                break;
//                        }
//                        switch (item.getItemId()){
//                            case R.id.nav_search:
//                                selectedFragment = new SearchFragment();
//                                break;
//                        }
//                        switch (item.getItemId()){
//                            case R.id.nav_setting:
//                                selectedFragment = new SettingFragment();
//                                break;
//                        }
//
//                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
//                        return  true;
//
//                    }
//                };
//
//
////
////    public void disable(View v){
////        v.setEnabled(false);
////    }
////    public void changetext(View v){
////        TextView my = findViewById(R.id.TextView1);
////        if(t%2==0) {
////            my.setText("Non");
////        }
////        else{
////            my.setText("AOatP");
////        }
////        t++;
////    }
////    public void changecolor(View v){
////        TextView my = findViewById(R.id.TextView1);
////        if(t%2==0){
////            my.setBackgroundColor(Color.YELLOW);
////        }
////        else{
////            my.setBackgroundColor(Color.RED);
////        }
////        t++;
////    }
////    public void handleText(View v){
////        TextView a = findViewById(R.id.gg);
////        String input = a.getText().toString();
////        ((TextView)findViewById(R.id.TextView1)).setText(input);
////        Log.d( "info", input);
////    }
////    public void launchSetting(View v){
////        Intent i = new Intent(this, settingActivity.class);
////        String message = ((TextView)findViewById(R.id.gg)).getText().toString();
////        i.putExtra("text1",message);
////        startActivity(i);
////
////    }
//
//}
