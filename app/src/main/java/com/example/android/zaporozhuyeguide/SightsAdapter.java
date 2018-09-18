package com.example.android.zaporozhuyeguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SightsAdapter extends ArrayAdapter<Sights> {

    public SightsAdapter(@NonNull Activity context, ArrayList<Sights> array) {
        super(context, 0, array);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        // Проверяем, используется ли существующее представление повторно, иначе раздуйте представление
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        final Sights currentSight = getItem(position);
        //ToDo: потом допишем что куда выводить..
        //Выводим изображение
        ImageView imageView = listItemView.findViewById(R.id.sightPic);
        imageView.setImageResource(currentSight.getPic());

        //Выводим имя достопремечательности
        TextView name = listItemView.findViewById(R.id.sightName);
        name.setText(currentSight.getName());

        //Выводим телефон
        TextView phone = listItemView.findViewById(R.id.phone);
        phone.setText(currentSight.getPhone());

        return listItemView;

    }


}
