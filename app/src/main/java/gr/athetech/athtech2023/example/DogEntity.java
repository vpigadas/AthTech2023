package gr.athetech.athtech2023.example;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "Dog")
public class DogEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "image")
    private String image;
    @ColumnInfo(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DogEntity dogEntity = (DogEntity) o;
        return id == dogEntity.id && Objects.equals(image, dogEntity.image) && Objects.equals(name, dogEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image, name);
    }
}
