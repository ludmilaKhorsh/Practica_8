package com.example.horsheva;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.CheckBox;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {
    private List<Book> mBooks;

    public BookAdapter(List<Book> books) {
        mBooks = books;
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_book, parent, false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        Book book = mBooks.get(position);
        holder.bindBook(book);
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public static class BookHolder extends RecyclerView.ViewHolder {

        private TextView mTitleTextView;
        private CheckBox mReadedCheckBox;
        private Book mBook;

        public BookHolder(View itemView) {
            super(itemView);
            mTitleTextView = itemView.findViewById(R.id.list_item_book_title_text_view);
            mReadedCheckBox = itemView.findViewById(R.id.list_item_book_readed_check_box);
        }

        public void bindBook(Book book) {
            mBook = book;
            mTitleTextView.setText(mBook.getTitle());
            mReadedCheckBox.setChecked(mBook.isReaded());
        }
    }
}

