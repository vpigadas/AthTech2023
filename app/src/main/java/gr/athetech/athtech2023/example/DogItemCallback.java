package gr.athetech.athtech2023.example;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class DogItemCallback  extends DiffUtil.ItemCallback<DogEntity> {
    @Override
    public boolean areItemsTheSame(@NonNull DogEntity oldItem, @NonNull DogEntity newItem) {
        return oldItem.equals(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull DogEntity oldItem, @NonNull DogEntity newItem) {
        return oldItem.equals(newItem);
    }
}
