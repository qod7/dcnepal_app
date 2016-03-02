package com.dcnepal.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dcnepal.R;


public class FragmentMyNewsSingleCategory extends Fragment{

    protected int mNewsCategory = 0;

    public FragmentMyNewsSingleCategory() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mNewsCategory = getArguments().getInt("newsCategory");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_news_single_category, container, false);
        TextView textView = (TextView) view.findViewById(R.id.categoryNamePlaceholder);
        textView.setText(getResources().getStringArray(R.array.my_news_categories)[mNewsCategory]);
        return view;
    }

}
