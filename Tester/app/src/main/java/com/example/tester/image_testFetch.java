package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.threeten.bp.LocalDateTime; // use with android java use >> java.time.LocalDateTime;

import java.io.IOException;
import java.io.InputStream;


public class image_testFetch extends AppCompatActivity {
    LocalDateTime time = LocalDateTime.now();
    TextInputEditText textInputEditTextSelectBooth;
    Button buttonSelectBooth;
    ImageView ivResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_test_fetch);


        textInputEditTextSelectBooth = findViewById(R.id.selectbooth);
        buttonSelectBooth = findViewById(R.id.bookbooth);
        buttonSelectBooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectbooth,username,event,zone,booktime;
                selectbooth = String.valueOf(textInputEditTextSelectBooth.getText());
                KeepUserLogin a = new KeepUserLogin();
                select_booth b = new select_booth();
                username = a.getUser();
                event = String.valueOf(b.getEvent());
                zone = String.valueOf(b.getZone());
                booktime = String.valueOf(time);
                if(!selectbooth.equals("")) {
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            String[] field = new String[5];
                            field[0] = "username";
                            field[1] = "event_id";
                            field[2] = "zone_id";
                            field[3] = "booth_id";
                            field[4] = "booking_time";
                            String[] data = new String[5];
                            data[0] = username;
                            data[1] = event;
                            data[2] = zone;
                            data[3] = selectbooth;
                            data[4] = booktime;
                            HttpsTrustManager.allowAllSSL();
                            PutData putData = new PutData("https://192.168.64.2/LoginAndRegister/book.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Book Success")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }

                            }

                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(),"All fields required", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ivResult = findViewById(R.id.imageView);
        select_booth c= new select_booth();
        if(c.getZone()==1 && c.getBooth_type().equalsIgnoreCase("general")){
            String urlLink = "https://scontent.fbkk2-8.fna.fbcdn.net/v/t1.0-9/123145878_3441741302573117_7515296274702643021_n.jpg?_nc_cat=103&ccb=2&_nc_sid=730e14&_nc_ohc=M5oWRD5Zu3oAX92t4m4&_nc_ht=scontent.fbkk2-8.fna&oh=754ec0534f6400de2f0f8064b6456a93&oe=5FC73ECC";
            LoadImage loadImage = new LoadImage(ivResult);
            loadImage.execute(urlLink);
        }
        else if(c.getZone()==1 && c.getBooth_type().equalsIgnoreCase("premium")){
            String urlLink = "https://scontent.fbkk2-4.fna.fbcdn.net/v/t1.0-9/123215535_3441741482573099_4923849758575855961_n.jpg?_nc_" +
                    "cat=101&ccb=2&_nc_sid=730e14&_nc_ohc=5PM2vzPWe4YAX8Rdqn2&_nc_ht=scontent.fbkk2-4.fna&oh=684fafb286d1ea4c759979d7df9e1f0f&oe=5FC6552B";
            LoadImage loadImage = new LoadImage(ivResult);
            loadImage.execute(urlLink);
        }
        else if(c.getZone()==2 && c.getBooth_type().equalsIgnoreCase("general")){
            String urlLink = "https://scontent.fbkk2-7.fna.fbcdn.net/v/t1.0-9/124009818_3441741695906411_6270032176152887294_n.jpg?_nc_cat=108&ccb=2&_nc_sid=730e14&_nc_ohc=D38ECE4OFsMAX8dDAKp&_nc_ht=scontent.fbkk2-7.fna&oh=05404f545ffbd385bd647e8db73cd5b0&oe=5FC73AA8";
            LoadImage loadImage = new LoadImage(ivResult);
            loadImage.execute(urlLink);
        }
        else if(c.getZone()==2 && c.getBooth_type().equalsIgnoreCase("premium")){
            String urlLink = "https://scontent.fbkk22-3.fna.fbcdn.net/v/t1.0-9/123142838_3441741892573058_6407395695962887719_n.jpg?_nc_cat=110&ccb=2&_nc_sid=730e14&_nc_eui2=AeF7wYKfZ7mtzbQbksFPI2wUqUu-4fnNscmpS77h-c2xyQLyqYoRDy34NLZU0OU318FhdERiPuU8pZ_jWzVAdKiB&_nc_ohc=sqZm9eLnT4MAX8J6lIY&_nc_ht=scontent.fbkk22-3.fna&oh=82c5e955f2511924a78ab42fd1ab9bb8&oe=5FC6E324";
            LoadImage loadImage = new LoadImage(ivResult);
            loadImage.execute(urlLink);
        }
        else if(c.getZone()==3 && c.getBooth_type().equalsIgnoreCase("general")){
            String urlLink = "https://scontent.fbkk22-4.fna.fbcdn.net/v/t1.0-9/123330143_3441742145906366_5992142263038175579_n.jpg?_nc_cat=109&ccb=2&_nc_sid=730e14&_nc_eui2=AeHoAnr9YnEHHA-bqRCdLUF6y9Cy1LFbpK_L0LLUsVukrxAIZ7HNPzbVGUh4AoAd3IdHrSTWYGfyz-ZhV2jtEkv-&_nc_ohc=aYIKhgsgnYAAX_5Nwoy&_nc_ht=scontent.fbkk22-4.fna&oh=bcf175621dd24f91f4111a5403c0d147&oe=5FC97AD5";
            LoadImage loadImage = new LoadImage(ivResult);
            loadImage.execute(urlLink);
        }
        else if(c.getZone()==3 && c.getBooth_type().equalsIgnoreCase("premium")){
            String urlLink = "https://scontent.fbkk22-3.fna.fbcdn.net/v/t1.0-9/123288475_3441742155906365_2871930250126236722_n.jpg?_nc_cat=103&ccb=2&_nc_sid=730e14&_nc_eui2=AeGx8iF7mjjv6w_vROd5lfWEZsoG3bKpRdpmygbdsqlF2vl7W1IVY-jdY-obvEmGMz6ujRRIwZBK1GxO1NQujwkm&_nc_ohc=h8OU-jz1Ep4AX_1K4K3&_nc_oc=AQlyX3ixHsHUqkrwZCk-100ZoFACJOitVcKLiqQTAnMahGgdvKpJs7PPF6yfUlrkHNI&_nc_ht=scontent.fbkk22-3.fna&oh=7777307ae898708ee6e05f25982d056a&oe=5FC796AD";
            LoadImage loadImage = new LoadImage(ivResult);
            loadImage.execute(urlLink);
        }
        else if(c.getZone()==4 && c.getBooth_type().equalsIgnoreCase("general")){
            String urlLink = "https://scontent.fbkk22-3.fna.fbcdn.net/v/t1.0-9/123390371_3441742162573031_7334762878412861092_n.jpg?_nc_cat=103&ccb=2&_nc_sid=730e14&_nc_eui2=AeF_gCUnc-vi_TaZC7GOUsZwu7H0lWJIGFe7sfSVYkgYV4y7gY5UUWw9aFaR5GEHNQKnHTn0Uw_Ljz5d07lad3JP&_nc_ohc=jbs4s7cRaM8AX-L2LMA&_nc_ht=scontent.fbkk22-3.fna&oh=0e29e8fea79032a8760fc273ed2593a8&oe=5FC98432";
            LoadImage loadImage = new LoadImage(ivResult);
            loadImage.execute(urlLink);
        }
        else if(c.getZone()==4 && c.getBooth_type().equalsIgnoreCase("premium")){
            String urlLink = "https://scontent.fbkk22-1.fna.fbcdn.net/v/t1.0-9/123137258_3441742219239692_5718189960904070973_n.jpg?_nc_cat=100&ccb=2&_nc_sid=730e14&_nc_eui2=AeHCInE-ThcZhOqvgkNP3_83XStxicjv5RpdK3GJyO_lGk2GsRpjoWQqHDpSF5Aootv05MbEQRP98oMkc9O1ibHZ&_nc_ohc=CIHSJVRg7oYAX-nsUrl&_nc_ht=scontent.fbkk22-1.fna&oh=cd0524333246fca5ac4b9fa6305715cf&oe=5FC9DB23";
            LoadImage loadImage = new LoadImage(ivResult);
            loadImage.execute(urlLink);
        }
        else if(c.getZone()==5 && c.getBooth_type().equalsIgnoreCase("general")){
            String urlLink = "https://scontent.fbkk22-6.fna.fbcdn.net/v/t1.0-9/123318548_3441742229239691_6467149127063997407_n.jpg?_nc_cat=104&ccb=2&_nc_sid=730e14&_nc_eui2=AeFAUzhD0xM62bdLHASKKk6jF_V2PyDm31oX9XY_IObfWkrL7yPQ1F6FD1KELef3VY5UJgNUsKfHyfx735PFXv9C&_nc_ohc=IqLUrFQQDoAAX8hTb1D&_nc_ht=scontent.fbkk22-6.fna&oh=7803d7c72bc85952a2d10c2f87bdc4a7&oe=5FC7F93B";
            LoadImage loadImage = new LoadImage(ivResult);
            loadImage.execute(urlLink);
        }
        else if(c.getZone()==5 && c.getBooth_type().equalsIgnoreCase("premium")){
            String urlLink = "https://scontent.fbkk22-4.fna.fbcdn.net/v/t1.0-9/123393284_3441742272573020_3435425085701283190_n.jpg?_nc_cat=111&ccb=2&_nc_sid=730e14&_nc_eui2=AeEuKOy2fgmQmKb4fENOwfpQ5aecsgJrx0blp5yyAmvHRv5OCjiE2GkwaGbl7Tuv9D8grE80oD6jHZP4xhcnDVzv&_nc_ohc=zv57sqnlLF8AX_ipKv7&_nc_ht=scontent.fbkk22-4.fna&oh=dec6f2d1adca3f2204403bd1fe48893d&oe=5FC7D91A";
            LoadImage loadImage = new LoadImage(ivResult);
            loadImage.execute(urlLink);
        }

    }
    private class LoadImage extends AsyncTask<String,Void, Bitmap>{
        ImageView imageView;
        public LoadImage(ImageView ivResult){
            this.imageView = ivResult;
        }
        @Override
        protected Bitmap doInBackground(String... strings) {
            String urlLink = strings[0];
            Bitmap bitmap = null;
            try {
                InputStream inputStream = new java.net.URL(urlLink).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            ivResult.setImageBitmap(bitmap);
        }
    }
}