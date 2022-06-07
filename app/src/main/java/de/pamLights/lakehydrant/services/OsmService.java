package de.pamLights.lakehydrant.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OsmService {
    private OkHttpClient client;

    public OsmService() {
        this.client = new OkHttpClient();
    }

    public void getData(Callback callback, String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public void getHydrants(Callback callback) {
        getData(callback, "https://overpass-api.de/api/interpreter?data=[out:json];node[emergency=fire_hydrant](47.6260228,9.2962146,47.7580326,9.5434338);out;");
    }
}
