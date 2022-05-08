package de.pamLights.lakehydrant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button2 = findViewById(R.id.button);
        TextView testView = findViewById(R.id.testText);


        button2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            testView.setText("new Text");

            Intent i = new Intent(MainActivity.this, HydrantMap.class);
            startActivity(i);
          }
        });
    }
}
