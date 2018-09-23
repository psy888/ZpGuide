package com.example.android.zaporozhuyeguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;

import static android.view.View.OnClickListener;

public class more extends AppCompatActivity {

    //go to previous fragment by pressing up button in acton bar

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent parentIntent = NavUtils.getParentActivityIntent(this);
                assert parentIntent != null;
                parentIntent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(parentIntent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        // Распаковываем преданый объект
        final Sights sight = Parcels.unwrap(getIntent().getParcelableExtra("currentSight"));

        final OnClickListener click = new OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.bigPhone:
                        String phoneNumber = sight.getPhone();
                        Intent call = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null));
                        startActivity(call);
                        break;
                    case R.id.bigAdress:
                        String location = sight.getAdress();
                        Intent adressIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("geo:0,0?q=%s",
                                Uri.parse(location))));
                        startActivity(adressIntent);
                        break;
                    default:
                        break;
                }
            }
        };


        //Заполняем вьюшки из объекта

        //ToDo: possibility to list more photos
        ImageView bigPic = findViewById(R.id.bigImg);
        bigPic.setImageResource(sight.getBigPic());

        TextView name = findViewById(R.id.bigSightName);
        name.setText(sight.getName());
        TextViewCompat.setAutoSizeTextTypeWithDefaults(name, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);


        TextView about = findViewById(R.id.about);
        about.setText(sight.getAbout());


        TextView phone = findViewById(R.id.bigPhone);
        String phoneNumber = sight.getPhone();

        if(phoneNumber.contentEquals("-")) {
            phone.setVisibility(View.GONE);
        }
        else
        {
            phone.setText(phoneNumber);
            //click listener and call intent
            phone.setOnClickListener(click);
        }



        TextView adress = findViewById(R.id.bigAdress);
        adress.setText(R.string.map );
        // click listener and maps intent
        adress.setOnClickListener(click);


    }
}
