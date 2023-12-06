package gr.athetech.athtech2023.example;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import gr.athetech.athtech2023.R;

public class DogViewHolder extends RecyclerView.ViewHolder {

    public DogViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(DogEntity dog) {

        ImageView imageView = itemView.findViewById(R.id.holder_dog_img);

        Glide.with(itemView.getContext()).load(dog.getImage()).into(imageView);
    }
}
