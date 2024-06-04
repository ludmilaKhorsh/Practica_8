// Book.java
package com.example.horsheva;

import java.util.UUID;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Book {
    private UUID mId;
    private String mTitle;
    private String mDate; // Тип изменен на String
    private boolean mReaded;

    public Book() {
        mId = UUID.randomUUID();
        mReaded = false;
        // Форматирование текущей даты и сохранение ее как строки
        mDate = DateFormat.getDateInstance(DateFormat.LONG, new Locale("ru", "RU")).format(new Date());
    }

    // Геттеры и сеттеры
    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public boolean isReaded() {
        return mReaded;
    }

    public void setReaded(boolean readed) {
        mReaded = readed;
    }
}

