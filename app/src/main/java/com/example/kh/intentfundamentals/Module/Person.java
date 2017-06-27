package com.example.kh.intentfundamentals.Module;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by kh on 6/27/2017.
 */

public class Person   implements Parcelable{
    private String name;
    private int old;
    private Date date;
    public Person(String name,  int old, Date date){
        this.name = name;
        this.old = old;
        this.date = date;
    }

    public Person(Parcel input){
        name = input.readString();
        old = input.readInt();
        date = new java.sql.Date(input.readLong());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(old);
        dest.writeLong(date.getTime());
    }

    public static final Parcelable.Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
