package com.example.muhamed.sunshine.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    public static class PlaceholderFragment extends Fragment {
        public PlaceholderFragment() {

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            String [] forecastArray = {
                    "Today - Sunny - 88/63",
                    "Tomorrow - Foggy - 70/64",
                    "Weds - Cloudy - 72/63",
                    "Thurs - Rainy - 64/51",
                    "Fri - Foggy - 70/46",
                    "Today - Sunny - 88/63",
                    "Tomorrow - Foggy - 70/64",
                    "Weds - Cloudy - 72/63",
                    "Thurs - Rainy - 64/51",
                    "Fri - Foggy - 70/46",
                    "Sat - Sunny - 76/68"
            };

            List<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));

            ArrayAdapter<String> mForecastAdapter =
                    new ArrayAdapter<String>(
                            getActivity(),
                            R.layout.list_item_forecast,
                            R.id.list_item_forecast_textview,
                            weekForecast);

            ListView mForecastListView = (ListView)rootView.findViewById(R.id.listview_forecast);
            mForecastListView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
