package com.example.b21yassine.motivateme.data;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.b21yassine.motivateme.models.Quote;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RequestData {

    public String QUOTE_URL ="https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20";

    public Context context;
    public List<Quote> quotes_list;

    public RequestData(Context context) {
        this.context = context;
    }

    public void loadQuotes(final QuoteListAsyncResponse callback){

        quotes_list =new ArrayList<>();

        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest =new JsonArrayRequest(Request.Method.GET, QUOTE_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for(int i =0; i < response.length(); i++){

                            try {
                                JSONObject jsonObject =response.getJSONObject(i);

                                Quote quote =new Quote();
                                quote.setQuote(jsonObject.getString("quote"));
                                quote.setAuthor(jsonObject.getString("name"));

                                quotes_list.add(quote);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        if(quotes_list != null) callback.proccessFinished(quotes_list);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("ERROR : ", error.getMessage());
                    }
                }
        );

        queue.add(jsonArrayRequest);

    }

}
