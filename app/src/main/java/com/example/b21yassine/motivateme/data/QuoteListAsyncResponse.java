package com.example.b21yassine.motivateme.data;

import com.example.b21yassine.motivateme.models.Quote;

import java.util.List;

public interface QuoteListAsyncResponse {
    void proccessFinished(List<Quote> quoteList);
}
