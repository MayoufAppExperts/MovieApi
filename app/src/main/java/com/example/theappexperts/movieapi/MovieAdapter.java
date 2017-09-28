package com.example.theappexperts.movieapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.theappexperts.movieapi.pojo.PlayerInfo;
import com.example.theappexperts.movieapi.pojo.Result;

import java.util.List;

/**
 * Created by TheAppExperts on 28/09/2017.
 */

class MovieAdapter extends RecyclerView.Adapter <MovieAdapter.MovieViewHolder>{

    List<Result> playerInfo;
    int row;
    Context applicationContext;

    public MovieAdapter(List<Result> playerInfo, int row, Context applicationContext) {
        this.playerInfo = playerInfo;
        this.row=row;
        this.applicationContext = applicationContext;
    }



    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, null);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

        holder.tvTitle.setText(playerInfo.get(position).getTitle());
        holder.tvSubtitle.setText(playerInfo.get(position).getOverview());
        holder.tvDescription.setText(playerInfo.get(position).getOverview());
        holder.tvRating.setText(playerInfo.get(position).getVoteAverage().toString());

    }

    @Override
    public int getItemCount() {
        return playerInfo.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle, tvSubtitle, tvDescription, tvRating;

        public MovieViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView)itemView.findViewById(R.id.title);
            tvSubtitle = (TextView)itemView.findViewById(R.id.subtitle);
            tvDescription=(TextView)itemView.findViewById(R.id.description);
            tvRating = (TextView) itemView.findViewById(R.id.rating);
        }
    }
}
