package com.jaehyun.sue.outsidermanagement.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.places.*;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jaehyun.sue.outsidermanagement.R;

import static android.support.constraint.Constraints.TAG;

public class SearchFragment extends Fragment
        implements OnMapReadyCallback
{
    private MapView mapView = null;

    public SearchFragment()
    {
        // required
    }


    EditText l_editText,ll_editText;
    ImageButton btn;
    ImageButton btn2;
    GoogleMap googleMap;
    Double latitude = 0.0;
    Double longitude =0.0;
    LocationManager manager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View layout = inflater.inflate(R.layout.fragment_search2 , container, false);


        mapView = (MapView)layout.findViewById(R.id.map);
        mapView.getMapAsync(this);



//    PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
//          getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

//  autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
//        @Override
//        public void onPlaceSelected(Place place) {
//            Location location = new Location("");
//            location.setLatitude(place.getLatLng().latitude);
//            location.setLongitude(place.getLatLng().longitude);

//            setCurrentLocation(location, place.getName().toString(), place.getAddress().toString());
//        }

//        @Override
//        public void onError(Status status) {
//            Log.i(TAG, "An error occurred: " + status);
//        }
//    });





        //추가한 것것
        l_editText = (EditText) layout.findViewById(R.id.l_editText);
        ll_editText = (EditText) layout.findViewById(R.id.LL_editText);
        btn = (ImageButton) layout.findViewById(R.id.s_button);
        btn2 = (ImageButton) layout.findViewById(R.id.r_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                setGoogleMap(Double.parseDouble(ll_editText.getText().toString()),Double.parseDouble(l_editText.getText().toString()));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                setGoogleMap(latitude,longitude);
            }
        });

        startLocationService();
        return layout;
    }

    public void setGoogleMap(Double lat, Double lng){
        LatLng locate = new LatLng(lat, lng);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(locate);
        markerOptions.title("현 위치");
        markerOptions.snippet("위수지역 입니다.");
        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(locate));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    }
    //좌표 확인
    private void startLocationService()
    {
        manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        long minTime = 1000;
        float minDistance = 1;

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(getActivity(), "허가 받지 않았습니다", Toast.LENGTH_SHORT).show();
            return;
        }
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,minTime,minDistance,mLocationListener);
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,minTime,minDistance,mLocationListener);
    }

    private void stopLocationService()
    {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(getActivity(), "허가 받지 않았습니다", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();

            stopLocationService();
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };




    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onLowMemory();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //액티비티가 처음 생성될 때 실행되는 함수

        if(mapView != null)
        {
            mapView.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        this.googleMap = googleMap;
    }
}



