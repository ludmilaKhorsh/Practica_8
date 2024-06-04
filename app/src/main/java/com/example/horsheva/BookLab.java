package com.example.horsheva;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookLab {
    private static BookLab sBookLab;
    private List<Book> mBooks;

    // Статический метод для получения экземпляра BookLab
    public static BookLab get(Context context) {
        if (sBookLab == null) {
            sBookLab = new BookLab(context);
        }
        return sBookLab;
    }

    // Конструктор класса BookLab
    private BookLab(Context context) {
        mBooks = new ArrayList<>();
        // Заполнение списка книгами
        for (int i = 0; i < 100; i++) {
            Book book = new Book();
            book.setTitle("Book #" + i);
            book.setReaded(i % 2 == 0); // Для каждого второго объекта
            mBooks.add(book);
        }
    }

    // Метод для получения списка всех книг
    public List<Book> getBooks() {
        return mBooks;
    }

    // Метод для получения книги по ID
    public Book getBook(UUID id) {
        for (Book book : mBooks) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}
