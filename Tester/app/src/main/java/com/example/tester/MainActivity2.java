package com.example.tester;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ListView listView;
    String mTitle[] = {"Event1","Event2","Event3","Event4","Event5"};
    String mDescription[] = {"E1","E2","E3","E4","E5"};
    int image[] = {R.drawable.facebook,R.drawable.instragram,R.drawable.twitter,R.drawable.youtube,R.drawable.line};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.navigation_view);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.nav_open,
                R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_edit: Intent i = new Intent(getApplicationContext(), EditActivity.class); startActivity(i); finish();
                        break;
                    case R.id.nav_logout: Intent j = new Intent(getApplicationContext(), Login.class); startActivity(j); finish();
                        break;
                }
                return true;
            }
        });

        listView = findViewById(R.id.ListView);
        MyAdapter adapter = new MyAdapter(this,mTitle,mDescription,image);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(MainActivity2.this, "Event1 Description", Toast.LENGTH_SHORT).show();
                    select_booth a = new select_booth();
                    a.setEvent(1);
                    Intent i = new Intent(getApplicationContext(),select_booth_event01.class);
                    startActivity(i);
                    finish();
                }
                if(position == 1){
                    Toast.makeText(MainActivity2.this, "Event2 Description", Toast.LENGTH_SHORT).show();
                }
                if(position == 2){
                    Toast.makeText(MainActivity2.this, "Event3 Description", Toast.LENGTH_SHORT).show();
                }
                if(position == 3){
                    Toast.makeText(MainActivity2.this, "Event4 Description", Toast.LENGTH_SHORT).show();
                }
                if(position == 4){
                    Toast.makeText(MainActivity2.this, "Event5 Description", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDescription[];
        int rImg[];

        MyAdapter(Context c,String title[],String Description[],int imgs[]){
            super(c,R.layout.row,R.id.textview1,title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = Description;
            this.rImg = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textview1);
            TextView myDescription = row.findViewById(R.id.textview2);

            images.setImageResource(rImg[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}