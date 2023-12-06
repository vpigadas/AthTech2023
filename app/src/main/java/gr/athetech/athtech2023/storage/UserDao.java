package gr.athetech.athtech2023.storage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface UserDao {

    @Insert
    void create(UserEntity user) throws Exception;

    @Update
    void update(UserEntity user) throws Exception;


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(UserEntity user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(List<UserEntity> users);

    @Delete
    void delete(UserEntity user);

    @Delete
    void delete(List<UserEntity> users);

    @Query("SELECT * FROM UserEntity")
    @NonNull
    List<UserEntity> read();

    @Query("SELECT * FROM UserEntity LIMIT 1")
    @Nullable
    UserEntity readFirst();

    @Query("SELECT * FROM UserEntity WHERE name LIKE :name")
    @NonNull
    List<UserEntity> read(String name);

    @Query("SELECT * FROM UserEntity WHERE name LIKE :name LIMIT 1")
    @Nullable
    UserEntity readFirst(String name);
}
