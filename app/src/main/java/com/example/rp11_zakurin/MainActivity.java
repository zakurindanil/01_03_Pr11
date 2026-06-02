package com.example.rp11_zakurin;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    LocationManager _LocationManager;
    int ACCESS_FINE_LOCATION;
    int ACCESS_COARSE_LOCATION;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    LocationListener _LocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            if(location == null) return;
            else{
                String message = "";
                if(location.getProvider().equals(LocationManager.GPS_PROVIDER)){
                    message += "\nместоположение определено с помощью  GPS: долгота - " +
                            location.getLatitude() + "широта - " + location.getLongitude();
                }
                if(location.getProvider().equals(LocationManager.NETWORK_PROVIDER)){
                    message += "\nместоположение определено с помощью  интернета: долгота - " +
                            location.getLatitude() + "широта - " + location.getLongitude();
                }
                result.setText(message);
            }
        }
    };
}