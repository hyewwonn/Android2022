package com.cookandroid.and0804_02_dbcuradpidol;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class IdolAdapter extends CursorAdapter {
    public IdolAdapter(Context context, Cursor c,Boolean autoRequery){
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.list_item, null);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtNum = view.findViewById(R.id.txtNum);

        txtName.setText(cursor.getString(1));
        txtNum.setText(cursor.getString(2));
    }
}
