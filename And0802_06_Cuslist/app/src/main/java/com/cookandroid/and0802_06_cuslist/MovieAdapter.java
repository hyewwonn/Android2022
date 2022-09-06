package com.cookandroid.and0802_06_cuslist;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    Context context; //메인 액티비티 컨텍스트 저장 변수
    ArrayList<Movie> data; //데이터
    //생성자
    public MovieAdapter(Context context, ArrayList<Movie> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();//배열 원소의 개수
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = View.inflate(context, R.layout.listitem, null);
        }
        ImageView img = view.findViewById(R.id.imgPoster);
        TextView txtTitle = view.findViewById(R.id.txtTitle);
        TextView txtGenre = view.findViewById(R.id.txtGenre);
        img.setImageDrawable(data.get(i).getImage());
        txtTitle.setText(data.get(i).getTitle());
        txtGenre.setText(data.get(i).getGenre());

        return view;
    }
}
