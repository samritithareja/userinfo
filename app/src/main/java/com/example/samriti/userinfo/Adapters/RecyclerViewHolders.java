package com.example.samriti.userinfo.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.samriti.userinfo.R;


/**
 * Created by samriti on 9/6/2018.
 */

class RecyclerViewHolders extends RecyclerView.ViewHolder {

    private static final String TAG = RecyclerViewHolders.class.getSimpleName();

    public TextView profileHeader;

    public TextView profileContent;

    public RecyclerViewHolders(final View itemView) {
        super(itemView);
        profileHeader = (TextView)itemView.findViewById(R.id.heading);
        profileContent = (TextView) itemView.findViewById(R.id.profile_content);
    }}


