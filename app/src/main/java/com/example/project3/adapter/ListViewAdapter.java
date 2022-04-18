package com.example.project3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.project3.R;
import com.example.project3.model.Search;
import com.example.project3.SearchActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<com.example.project3.model.Search> Search = null;
    private ArrayList<Search> arraylist;

    public ListViewAdapter(Context context, ArrayList<SearchActivity> SearchList) {
        mContext = context;
        this.Search = Search;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Search>();
        this.arraylist.addAll(Search);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return Search.size();
    }

    @Override
    public Search getItem(int position) {
        return Search.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(Search.get(position).Search());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        Search.clear();
        if (charText.length() == 0) {
          Search.addAll(arraylist);
        } else {
            for (Search wp : arraylist) {
                if (wp.Search().toLowerCase(Locale.getDefault()).contains(charText)) {
                    Search.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
