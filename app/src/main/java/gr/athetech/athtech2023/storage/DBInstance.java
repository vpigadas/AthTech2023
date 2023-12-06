package gr.athetech.athtech2023.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class DBInstance extends RoomDatabase {
    abstract UserDao getUserDao();
}
