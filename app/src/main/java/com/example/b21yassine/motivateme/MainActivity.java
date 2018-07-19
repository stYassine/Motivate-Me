package com.example.b21yassine.motivateme;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.b21yassine.motivateme.adapters.QuotesPagerAdapter;
import com.example.b21yassine.motivateme.data.QuoteListAsyncResponse;
import com.example.b21yassine.motivateme.data.RequestData;
import com.example.b21yassine.motivateme.fragments.QuoteFragment;
import com.example.b21yassine.motivateme.models.Quote;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    QuotesPagerAdapter adapter;

    private List<Fragment> fragmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager =(ViewPager) findViewById(R.id.view_pager);

        adapter =new QuotesPagerAdapter(getSupportFragmentManager(), fragmentList());

        viewPager.setAdapter(adapter);

    }

    public List<Fragment> fragmentList(){

        fragmentList =new ArrayList<>();

        new RequestData(this).loadQuotes(new QuoteListAsyncResponse() {
            @Override
            public void proccessFinished(List<Quote> quoteList) {

                for(int i =0; i < quoteList.size(); i++){
                    QuoteFragment fragment =QuoteFragment.newInstance(quoteList.get(i).getQuote(), quoteList.get(i).getAuthor());

                    fragmentList.add(fragment);
                }
                adapter.notifyDataSetChanged();

            }
        });

        return fragmentList;

    }




}
