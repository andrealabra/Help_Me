package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.project3.adapter.ListViewAdapter;
import com.example.project3.model.SearchNames;

import java.util.ArrayList;



public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] searchNameList;
    ArrayList<SearchNames> arraylist = new ArrayList<SearchNames>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchactivity);

        // Generate sample data

        searchNameList = new String[]{"on", "Time", "go",
                "java", "csueb", "phone", "apple", "hello",
                "bye","why","Money"};

        // Locate the ListView in listview_main.xml
        list = findViewById(R.id.listview);

        for (String s :searchNameList) {
            SearchNames searchNames = new SearchNames(s);
            // Binds all strings into an array
            arraylist.add(searchNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this,arraylist );

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }
}
