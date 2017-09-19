package myapplication.com.sql.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import myapplication.com.sql.Model.Countries;
import myapplication.com.sql.R;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {
 
    private Context mContext;
    private List<Countries> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count,t1,t2;
        public ImageView thumbnail;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.text1);
            count = (TextView) view.findViewById(R.id.text2);
            thumbnail=(ImageView) view.findViewById(R.id.thumbnail);
            t1=(TextView) view.findViewById(R.id.text3);
            t2=(TextView) view.findViewById(R.id.text4);

        }
    }
 
 
    public AlbumsAdapter(Context mContext, List<Countries> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Countries album = albumList.get(position);
        holder.title.setText(album.getCountryname());
        holder.count.setText(album.getLanguage());
        Glide.with(mContext)
                .load(album.getFlag())
                .crossFade()
        .into(holder.thumbnail);
        holder.t1.setText(album.getCapital());
        holder.t2.setText(album.getCurrency().getCurrencyCode());
    }
 

 
    @Override
    public int getItemCount() {
        return albumList.size();
    }
}