package ps.edu.gu.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import ps.edu.gu.MainActivity;
import ps.edu.gu.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        try {
             Thread thread = new Thread(new Runnable() {
                 @Override
                 public void run() {
                     try {
                         Thread.sleep(2500);
                         finish();
                         Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                         startActivity(intent);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }

                 }
             });

             thread.start();
        } catch (Exception e) {

        }
    }
}
