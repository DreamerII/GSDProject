package com.student.gsd.gsdstudentapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dreamfire on 26.05.16.
 */
public class AddCashRVAdapter extends RecyclerView.Adapter<AddCashRVAdapter.AddCashHolder> {
    private Context mContext;

    public AddCashRVAdapter(Context _c){
        mContext = _c;
    }

    public void updateData(){

    }

    @Override
    public AddCashHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AddCashHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class AddCashHolder extends RecyclerView.ViewHolder {

        public AddCashHolder(View itemView) {
            super(itemView);
        }
    }
}
