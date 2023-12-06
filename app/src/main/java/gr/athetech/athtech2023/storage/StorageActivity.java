package gr.athetech.athtech2023.storage;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

import gr.athetech.athtech2023.R;

public class StorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        SharedPreferences preferences = getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", "Vassilis");
        editor.putInt("age", 100);
        //editor.commit();
        editor.apply();

        SharedPreferences sharedPreferences = getSharedPreferences("userInformations", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferences.edit();
        editor1.putInt("age", 100);
        editor1.apply();

        DBInstance database = Room.databaseBuilder(this, DBInstance.class, "athtech").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        DBInstance databaseNew = Room.databaseBuilder(this, DBInstance.class, "athtech2").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        List<UserEntity> data = database.getUserDao().read();
    }
}