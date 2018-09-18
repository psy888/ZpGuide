package com.example.android.zaporozhuyeguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.parceler.Parcels;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Категория Музеи
 */
public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //определяем где будет отображаться фрагмент (родительский Актиивити xml)
        View rootView = inflater.inflate(R.layout.sights_list, container, false);


        //Сосдаем массив объектов достопремечательностей
        final ArrayList<Sights> museums = new ArrayList<>();

        //Добавляем записи в массив
        museums.add(new Sights("Хортица", "о.Хортица", "0612223111", "Заповежник остров хортица", R.drawable.khort));

        //Создание экземпляра адаптера для ListView
        SightsAdapter sightsAdapter = new SightsAdapter(getActivity(), museums);

        //Инициализация целевого  ListView
        ListView listView = rootView.findViewById(R.id.list);

        //Прикрепление адаптер к ListView
        listView.setAdapter(sightsAdapter);

        //Установка OnItemClickListener для каждого элемента
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Создание намеренья открыть класс more
                Intent moreIntent = new Intent(getActivity(), more.class);
                //  упаковка текущего (нажатого) объекта в Parcel и добавление к намеренью как Extra
                moreIntent.putExtra("currentSight", Parcels.wrap(museums.get(position)));
                // Запуск активити (more class) с переданным объектом
                startActivity(moreIntent);

            }
        });
        //Возвращаем наполненый View объект для отображения на экране
        return rootView;
    }

}