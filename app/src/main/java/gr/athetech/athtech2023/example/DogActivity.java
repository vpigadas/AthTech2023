package gr.athetech.athtech2023.example;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;
import java.util.Random;

import gr.athetech.athtech2023.R;

public class DogActivity extends AppCompatActivity {

    public DogInstanceDB databaseInstance;
    private RequestQueue queue;
    private ListDogAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);

        databaseInstance = Room.databaseBuilder(this, DogInstanceDB.class, "Dog")
                .allowMainThreadQueries()
                .build();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new ListDogAdapter();
        recyclerView.setAdapter(adapter);
//        DogAdapterList adapterList = new DogAdapterList(getDogs());
//
//        recyclerView.setAdapter(adapterList);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrieveDogsOverAPI();
            }
        });
    }

    public List<DogEntity> getDogs() {
        return databaseInstance.getDogDao().get();
    }

    public void retrieveDogsOverAPI() {
        if (queue == null) {
            queue = Volley.newRequestQueue(this);
        }
        String url = "https://dog.ceo/api/breeds/image/random";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("NETWORK", response);

                        JsonResponse objectResponse = new Gson().fromJson(response, JsonResponse.class);
                        Log.d("RESPONSE", objectResponse.toString());

                        DogEntity dogEntity = new DogEntity();
                        dogEntity.setName(String.valueOf(new Random().nextDouble()));
                        dogEntity.setImage(objectResponse.getMessage());

                        databaseInstance.getDogDao().save(dogEntity);
                        //refreshList();
                        refreshList2();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("NETWORK", "", error);
                    }
                });
        queue.add(request);
    }

    public void refreshList() {
        DogAdapterList adapterList = new DogAdapterList(getDogs());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapterList);
    }

    public void refreshList2() {
        adapter.submitList(getDogs());
    }
}