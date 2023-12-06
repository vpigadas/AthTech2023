package gr.athetech.athtech2023.example;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DogEntity.class}, version = 1)
public abstract class DogInstanceDB extends RoomDatabase {
    abstract public DogDao getDogDao();
}
