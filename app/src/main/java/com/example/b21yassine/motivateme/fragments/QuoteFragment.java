package com.example.b21yassine.motivateme.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.b21yassine.motivateme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {


    public QuoteFragment() {
        // Required empty public constructor
    }

    public TextView quoute_text;
    public TextView quoute_author;
    public CardView main_card;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_quote, container, false);

        quoute_text =(TextView) view.findViewById(R.id.quote_text);
        quoute_author =(TextView) view.findViewById(R.id.quote_author);
        main_card =(CardView) view.findViewById(R.id.main_card);

        String quote =getArguments().getString("quote");
        String author =getArguments().getString("author");

        quoute_text.setText(quote);
        quoute_author.setText(author);

        return view;
    }

    public static final QuoteFragment newInstance(String quote, String author){
        QuoteFragment fragment =new QuoteFragment();

        Bundle bundle =new Bundle();
        bundle.putString("quote", quote);
        bundle.putString("author", author);

        fragment.setArguments(bundle);

        return fragment;
    }

}
