package de.pamLights.lakehydrant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import de.pamLights.lakehydrant.modals.OsmNode;
import de.pamLights.lakehydrant.services.JsonService;
import de.pamLights.lakehydrant.services.OsmService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private OsmService osmService;
    private JsonService jsonService;

    public MainActivity () throws IOException {
//        this.osmService = new OsmService(new URL("http://overpass-api.de/api/interpreter?data=[out:json];node[emergency=fire_hydrant](47.6260228,9.2962146,47.7580326,9.5434338);out;"));
        this.osmService = new OsmService();
        this.jsonService = new JsonService();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        TextView testView = findViewById(R.id.testText);


        button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            testView.setText("new Text");

            System.out.println("Start Download");
            osmService.getHydrants(new Callback() {
              @Override
              public void onFailure(@NonNull Call call, @NonNull IOException e) {
                System.err.println("Call failed");
              }

              @Override
              public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                jsonService.getAllFireHydrants(response.body().string());
              }
            });
          }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent i = new Intent(MainActivity.this, HydrantMap.class);
              startActivity(i);
            }
        });
    }
}
