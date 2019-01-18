package com.example.ilham.katalogfilm.utilities;

import android.view.View;

/**
 * Created by dityara on 05/12/18.
 */

public class CustomOnItemClickListener implements View.OnClickListener {

    private int mPosition;
    private OnItemClickCallback mOnItemClickCallback;

    public CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback) {
        this.mPosition = position;
        this.mOnItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onClick(View v) {
        this.mOnItemClickCallback.onItemClicked(v, mPosition);
    }

    public interface OnItemClickCallback {
        void onItemClicked(View view, int position);
    }
}
