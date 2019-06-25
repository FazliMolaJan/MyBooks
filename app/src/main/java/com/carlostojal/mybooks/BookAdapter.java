package com.carlostojal.mybooks;

//
// Copyright (c) Carlos Tojal (carlostojal)
// BookAdapter.java
// MyBooks
// github.com/carlostojal/MyBooks
//

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {

    private final Context context;
    private final ArrayList<Book> books;

    public BookAdapter(Context context,ArrayList<Book> books) {
        super(context,R.layout.book,books);
        this.context = context;
        this.books = books;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.book,parent,false);

        TextView title = (TextView) rowView.findViewById(R.id.title_element);
        TextView writer = (TextView) rowView.findViewById(R.id.writer_element);
        TextView progress = (TextView) rowView.findViewById(R.id.progress);

        //calculates and sets progress details on preview
        int cpage = books.get(position).getCpage();
        int npages = books.get(position).getNpages();
        int percentage = (cpage/npages)*100;
        String progressText = percentage+"% ("+cpage+"/"+npages+")";

        title.setText(books.get(position).getTitle());
        writer.setText(books.get(position).getWriter());
        progress.setText(progressText);

        return rowView;
    }
}
