package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;



public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] SearchList;
    ArrayList<SearchActivity> arraylist = new ArrayList<SearchActivity>();
    private Object Search;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchactivity);

        // Generate sample data

        Search = new String[]{"aa", "bb", "cc ",
                "dd", "ee", "ff ", " gg ", "hh",
                " ii"," ee "," oo"};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < SearchList.length; i++) {
           Search  = new Search(SearchList[i]);
            // Binds all strings into an array
            arraylist.add((SearchActivity) Search);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}

