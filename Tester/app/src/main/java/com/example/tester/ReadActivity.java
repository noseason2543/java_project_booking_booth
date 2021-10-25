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

public class ReadActivity extends AppCompatActivity {

    TextView textViewdatashow;
    EditText editTextvalue;
    Button buttonfetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

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
                        Toast.makeText(ReadActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
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