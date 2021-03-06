package com.appteamnith.hillffair.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appteamnith.hillffair.R;
import com.appteamnith.hillffair.modals.ClubEvent;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

/**
 * Created by Sahil on 3/23/2016.
 */
public class ClubEventAdapter extends RecyclerView.Adapter<ClubEventAdapter.EventViewHolder> {

    private ArrayList<ClubEvent> clubEventArrayList = new ArrayList<ClubEvent>();
    private Context context;

    public ClubEventAdapter(Context context) {
        this.context = context;
    }

    public void refresh(ArrayList<ClubEvent> clubEventArrayList) {
        this.clubEventArrayList = clubEventArrayList;
        notifyDataSetChanged();

    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventcard_view_layout, parent, false);
        EventViewHolder eventViewHolder = new EventViewHolder(view);
        return eventViewHolder;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        ClubEvent clubEvent=clubEventArrayList.get(position);
        if(clubEvent.getName()!=null&&!clubEvent.getName().isEmpty()){
            holder.club_name.setText(clubEvent.getName());
        }
        if(clubEvent.getImage_id()!=null&&!clubEvent.getImage_id().isEmpty()){
            Glide.with(context).load(clubEvent.getImage_id()).diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.person).into(holder.club_image);
        }

    }

    @Override
    public int getItemCount() {
        return clubEventArrayList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {

        ImageView club_image;
        TextView club_name;

        public EventViewHolder(View view) {
            super(view);
         club_image= (ImageView) view.findViewById(R.id.club_image);
            club_name= (TextView) view.findViewById(R.id.club_name);
        }
    }
}
