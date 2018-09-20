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
        museums.add(new Sights("Khortitsa National Nature Reserve", "47.839922,35.070024", "+380 95 914 7706", "Khortytsia is the heart of Zaporizhzhia, rightfully attracting the most people to the region. It is the biggest island on the Dnieper River and the subject of many myths and legends. The island is famous for its unique nature and interesting archeological findings. The traces of many cultures and epochs are interwoven here: in the past, Khortytsia was a home for Scythians, Sarmates, Pechenegs, and many others. But the most vivid scenes of the island’s history are undoubtedly connected to the Zaporizhian Cossacks, who founded the Cossacks' Republic here in the 16th century.", R.drawable.hortica, R.drawable.big_hortica));
        museums.add(new Sights("Dnieper Hydroelectric Station", "47.869343, 35.086892", "+380 (61) 223 93 59", "The Dnieper Hydroelectric Station is the largest hydroelectric power station on the Dnieper River, located in Zaporizhia, Ukraine. It is the fifth step of Dnieper hydroelectric stations cascade that provides electric power for Donets–Kryvyi Rih Industrial region.\n" +
                "\n" +
                "The station was built in two stages. DniproHES-1 was originally built between 1927-1932, but was destroyed during World War II to make use of the river as a natural obstacle. It was rebuilt between 1944-1950. DniproHES-2 was built between 1969-1980 and later modernized during the 2000s.\n" +
                "\n" +
                "The Dnieper Hydroelectric Station dam is an important crossing of the Dnieper. It has a water lock that allows navigation along the river and around the dam. There is also a bridge over the lock that carries a highway that connects the banks of the Dnieper.", R.drawable.ges, R.drawable.big_ges));
        museums.add(new Sights("City Hall", "Soborniy ave. 206", "+38 0612 334 881", "Zaporizhzhya city hall", R.drawable.cityhall, R.drawable.big_cityhall));
        museums.add(new Sights("Voznesenovsky Park","Pryberezhna Highway 72b","-","Voznesenovsky Park - one of the most romantic places in Zaporozhye. This open landscaped area of 4.5 hectares with elements of modern landscape design is located next to the cascade of fountains “Rainbow” on the embankment of the Dnieper.\n" + "The park was named after the village of Voznesenka, which in the old days was in this place. There is an artificial pond with fountains. This is one of the cleanest and well-organized parks in Zaporozhye, a place for recreation and various cultural events. Pryberezhna Highway.", R.drawable.rainbow, R.drawable.big_rainbow));
        museums.add(new Sights("Soborny Avenue", "Soborny Avenue", "-", "Soborny Avenue - one of the longest streets in Europe (about 11 km). It is the central, most beautiful and busiest street in Zaporozhye. The residential quarters of Sotsgorod in the area of the dam are considered one of the best examples of the city-planning art of the USSR of the pre-war period. Several squares with fountains, a lot of restaurants and cafes, most of the attractions of Zaporozhye are located on this street.", R.drawable.soborniy, R.drawable.big_soborniy));
        museums.add(new Sights("Preobrazhensky Bridges", "47.8453746,35.0813888,17", "-","Preobrazhensky Bridges (1949-1952) - two bridges connecting right and left banks of the Dnieper River through Khortytsia Island, a monument of cultural heritage of Ukraine. The bridges were named in honor of the author of the project - engineer and bridge builder B. Preobrazhensky. These bridges are the highest bridges in Ukraine (54 meters).", R.drawable.bridge, R.drawable.big_bridge ));
        museums.add(new Sights("Museum of Retro Cars “Faeton","Виборзька вулиця, 8, Запоріжжя","+38 0612 131 426","The main exhibits of the museum are 22 cars produced in the 1930s-1960s (Dodge, Willis, Ural-ZiS, ZiS-5, ZiS-6 (Katyusha) and others). In addition, you can see old weapons, equipment, military uniforms, badges, motorcycles, and a lot of other interesting collections. Vyborz’ka Street, 8. Opening hours: 09:00-17:00.",R.drawable.phaeton, R.drawable.big_phaeton));
        
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
