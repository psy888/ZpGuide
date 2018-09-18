package com.example.android.zaporozhuyeguide;

import org.parceler.Parcel;

@Parcel // Анотация класса Parcel декоратором (из документации к Parcel)
public class Sights {
    String mName;
    String mAdress;
    String mPhone;
    String mAbout;
    int mPic;
    int mBigPic;

    // пустой конструктор без параметров из требование документации к Parcel
    public Sights() {
    }

    public Sights(String name, String adress, String phone, String about, int pic, int bigPic) {
        //Public потому что только так их можно передать в Intent как putExtras Parcelable.wrap
        mName = name;
        mAdress = adress;
        mPhone = phone;
        mAbout = about;
        mPic = pic;
        mBigPic = bigPic;
    }

    public String getName() {
        return mName;
    }

    public String getAdress() {
        return mAdress;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getAbout() {
        return mAbout;
    }

    public int getPic() {
        return mPic;
    }

    public int getBigPic() {
        return mBigPic;
    }
}
