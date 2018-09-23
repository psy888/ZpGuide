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
        museums.add(new Sights(
                getString(R.string.khortitsa_n_n_r_name),
                getString(R.string.khortitsa_n_n_r_adr),
                getString(R.string.khortitsa_n_n_r_phone),
                getString(R.string.khortitsa_n_n_r_about),
                R.drawable.hortica,
                R.drawable.big_hortica));

        museums.add(new Sights(
                getString(R.string.ges_name),
                getString(R.string.ges_adr),
                getString(R.string.ges_phone),
                getString(R.string.ges_about),
                R.drawable.ges,
                R.drawable.big_ges));
        museums.add(new Sights(
                getString(R.string.cityhall_name),
                getString(R.string.cityhall_adr),
                getString(R.string.cityhall_phone),
                getString(R.string.cityhall_about),
                R.drawable.cityhall,
                R.drawable.big_cityhall));
        museums.add(new Sights(
                getString(R.string.voznespark_name),
                getString(R.string.voznespark_adr),
                getString(R.string.voznespark_phone),
                getString(R.string.voznespark_about),
                R.drawable.rainbow,
                R.drawable.big_rainbow));
        museums.add(new Sights(
                getString(R.string.sobornyave_name),
                getString(R.string.sobornyave_adr),
                getString(R.string.sobornyave_phone),
                getString(R.string.sobornyave_about),
                R.drawable.soborniy,
                R.drawable.big_soborniy));
        museums.add(new Sights(
                getString(R.string.preobrazhensky_name),
                getString(R.string.preobrazhensky_adr),
                getString(R.string.preobrazhensky_phone),
                getString(R.string.preobrazhensky_about),
                R.drawable.bridge,
                R.drawable.big_bridge));
        museums.add(new Sights(
                getString(R.string.faeton_name),
                getString(R.string.faeton_adr),
                getString(R.string.faeton_phone),
                getString(R.string.faeton_about),
                R.drawable.phaeton,
                R.drawable.big_phaeton));
        
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
