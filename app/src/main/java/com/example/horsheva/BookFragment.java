package com.example.horsheva;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;

public class BookFragment extends Fragment {
    private Book mBook;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mReadedCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBook = new Book(); // Создание нового объекта Book
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_book, container, false);

        mDateButton = (Button) v.findViewById(R.id.book_date);
        mDateButton.setText(mBook.getDate() != null ? mBook.getDate().toString() : "No date set");
        mDateButton.setEnabled(false);

        mTitleField = (EditText) v.findViewById(R.id.book_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBook.setTitle(s.toString()); // Обновление заголовка книги
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mReadedCheckBox = (CheckBox) v.findViewById(R.id.book_readed);
        mReadedCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> mBook.setReaded(isChecked));

        return v;
    }
}

// Класс BookHolder теперь определен корректно
class BookHolder extends RecyclerView.ViewHolder {
    private TextView mTitleTextView;
    private TextView mDateTextView;
    private CheckBox mReadedCheckBox;
    private Book mBook; // Переменная для хранения книги

    public BookHolder(View itemView) {
        super(itemView);
        mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_book_title_text_view);
        mDateTextView = (TextView) itemView.findViewById(R.id.list_item_book_date_text_view);
        mReadedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_book_readed_check_box);
    }

    // Метод для связывания данных книги с ViewHolder
    public void bindBook(Book book) {
        mBook = book;
        mTitleTextView.setText(mBook.getTitle());
        mDateTextView.setText(mBook.getDate().toString());
        mReadedCheckBox.setChecked(mBook.isReaded());

    }
}
