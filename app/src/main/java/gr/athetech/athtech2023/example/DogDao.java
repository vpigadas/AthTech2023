package gr.athetech.athtech2023.example;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(DogEntity entity);

    @Delete
    void delete(DogEntity entity);

    @Query("SELECT * FROM Dog")
    @NonNull
    List<DogEntity> get();
}
