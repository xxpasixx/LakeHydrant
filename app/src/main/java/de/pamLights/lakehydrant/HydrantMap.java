package de.pamLights.lakehydrant;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

public class HydrantMap extends AppCompatActivity {
  private final int REQUEST_PERMISSIONS_REQUEST_CODE = 1;
  private MapView map = null;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Context ctx = getApplicationContext();
    Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

    setContentView(R.layout.activity_hydrant_map);

    map = (MapView) findViewById(R.id.osmMap);
    map.setTileSource(TileSourceFactory.MAPNIK);

    map.setBuiltInZoomControls(true);
    map.setMultiTouchControls(true);
    map.setMaxZoomLevel(23.0);
    map.setMinZoomLevel(10.0);

    IMapController mapController = map.getController();
    mapController.setZoom(16.0);
    GeoPoint startPoint = new GeoPoint(47.673310, 9.415790);
    mapController.setCenter(startPoint);

    MyLocationNewOverlay mLocationOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(ctx),map);
    mLocationOverlay.enableMyLocation();
    map.getOverlays().add(mLocationOverlay);

    CompassOverlay compassOverlay = new CompassOverlay(this, map);
    compassOverlay.enableCompass();
    map.getOverlays().add(compassOverlay);

    RotationGestureOverlay mRotationGestureOverlay = new RotationGestureOverlay(map);
    mRotationGestureOverlay.setEnabled(true);
    map.getOverlays().add(mRotationGestureOverlay);


    final DisplayMetrics dm = ctx.getResources().getDisplayMetrics();
    ScaleBarOverlay mScaleBarOverlay = new ScaleBarOverlay(map);
    mScaleBarOverlay.setCentred(true);
    //play around with these values to get the location on screen in the right place for your application
    mScaleBarOverlay.setScaleBarOffset(dm.widthPixels / 2, 10);
    map.getOverlays().add(mScaleBarOverlay);

    setPoint(map);

    requestPermissionsIfNecessary(new String[] {
       Manifest.permission.ACCESS_FINE_LOCATION,
      Manifest.permission.WRITE_EXTERNAL_STORAGE
    });
  }

  @Override
  public void onResume() {
    super.onResume();
    //this will refresh the osmdroid configuration on resuming.
    //if you make changes to the configuration, use
    //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
    map.onResume(); //needed for compass, my location overlays, v6.0.0 and up
  }

  @Override
  public void onPause() {
    super.onPause();
    //this will refresh the osmdroid configuration on resuming.
    //if you make changes to the configuration, use
    //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    //Configuration.getInstance().save(this, prefs);
    map.onPause();  //needed for compass, my location overlays, v6.0.0 and up
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    ArrayList<String> permissionsToRequest = new ArrayList<>();
    for (int i = 0; i < grantResults.length; i++) {
      permissionsToRequest.add(permissions[i]);
    }
    if (permissionsToRequest.size() > 0) {
      ActivityCompat.requestPermissions(
        this,
        permissionsToRequest.toArray(new String[0]),
        REQUEST_PERMISSIONS_REQUEST_CODE);
    }
  }

  private void requestPermissionsIfNecessary(String[] permissions) {
    ArrayList<String> permissionsToRequest = new ArrayList<>();
    for (String permission : permissions) {
      if (ContextCompat.checkSelfPermission(this, permission)
        != PackageManager.PERMISSION_GRANTED) {
        // Permission is not granted
        permissionsToRequest.add(permission);
      }
    }
    if (permissionsToRequest.size() > 0) {
      ActivityCompat.requestPermissions(
        this,
        permissionsToRequest.toArray(new String[0]),
        REQUEST_PERMISSIONS_REQUEST_CODE);
    }
  }

  private void setPoint(MapView map) {
    GeoPoint geoPoint = new GeoPoint(47.673310, 9.415790);
    Marker marker = new Marker(map);
    marker.setPosition(geoPoint);
    marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER);
    marker.setSubDescription("Ich bin eine Beschreibung, lol :D");
    marker.setTitle("Titel, haha xD");
    map.getOverlays().add(marker);
  }
}
