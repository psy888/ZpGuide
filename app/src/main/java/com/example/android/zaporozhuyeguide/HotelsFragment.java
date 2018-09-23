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
 */
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //определяем где будет отображаться фрагмент (родительский Актиивити xml)
        View rootView = inflater.inflate(R.layout.sights_list, container, false);


        //Сосдаем массив объектов достопремечательностей
        final ArrayList<Sights> hotels = new ArrayList<>();

        //Добавляем записи в массив
        hotels.add(new Sights(
                getString(R.string.intouristhotel_name),
                getString(R.string.intouristhotel_adr),
                getString(R.string.intouristhotel_phone),
                getString(R.string.intouristhotel_about),
                R.drawable.intourist,
                R.drawable.big_intourist));
        hotels.add(new Sights(
                getString(R.string.soborniyhotel_name),
                getString(R.string.soborniyhotel_adr),
                getString(R.string.soborniyhotel_phone),
                getString(R.string.soborniyhotel_about),
                R.drawable.hotelsoborniy,
                R.drawable.big_hotelsoborniy
        ));
        hotels.add(new Sights(
                getString(R.string.teatralniyhotel_name),
                getString(R.string.teatralniyhotel_adr),
                getString(R.string.teatralniyhotel_phone),
                getString(R.string.teatralniyhotel_about),
                R.drawable.teatralniy,
                R.drawable.big_teatralniy
        ));
        hotels.add(new Sights(
                getString(R.string.khorticahotel_name),
                getString(R.string.khorticahotel_adr),
                getString(R.string.khorticahotel_phone),
                getString(R.string.khorticahotel_about),
                R.drawable.khortica_palace,
                R.drawable.big_khortica_palace
        ));
        hotels.add(new Sights(
                getString(R.string.praguehotel_name),
                getString(R.string.praguehotel_adr),
                getString(R.string.praguehotel_phone),
                getString(R.string.praguehotel_about),
                R.drawable.prague,
                R.drawable.big_prague
        ));
        hotels.add(new Sights(
                getString(R.string.sunricsehotel_name),
                getString(R.string.sunricsehotel_adr),
                getString(R.string.sunricsehotel_phone),
                getString(R.string.sunricsehotel_about),
                R.drawable.sunricsehotel,
                R.drawable.big_sunricsehotel
        ));


        //Создание экземпляра адаптера для ListView
        SightsAdapter sightsAdapter = new SightsAdapter(getActivity(), hotels);

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
                moreIntent.putExtra("currentSight", Parcels.wrap(hotels.get(position)));
                // Запуск активити (more class) с переданным объектом
                startActivity(moreIntent);

            }
        });
        //Возвращаем наполненый View объект для отображения на экране
        return rootView;
    }

}
