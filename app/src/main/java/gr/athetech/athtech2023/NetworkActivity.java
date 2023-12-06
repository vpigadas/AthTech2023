package gr.athetech.athtech2023;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class NetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://dog.ceo/api/breeds/image/random";

        // Request a string response from the provided URL.

        // Add the request to the RequestQueue.
        //queue.add(stringRequest);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("userInformations", Activity.MODE_PRIVATE);
        sharedPreferences.getString("name", "");
        sharedPreferences.getInt("age", 0);
    }
}