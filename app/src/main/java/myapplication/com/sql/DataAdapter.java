package myapplication.com.sql;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 18/9/17.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<AndroidVersion> android;
    public DataAdapter(ArrayList<AndroidVersion> android){
        this.android=android;
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_name.setText(android.get(i).getName());
        viewHolder.tv_version.setText(android.get(i).getVersion());
        viewHolder.tv_api.setText(android.get(i).getApi());
        viewHolder.tv_img.setImageURI(Uri.parse(android.get(i).getApi()));

    }
    @Override
    public int getItemCount() {
        return android.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        private TextView tv_version;
        private TextView tv_api;
        private ImageView tv_img;
        public ViewHolder(View view) {
            super(view);

            tv_name = view.findViewById(R.id.tv_name);
            tv_version = view.findViewById(R.id.tv_version);
            tv_api = view.findViewById(R.id.tv_api);
            tv_img = view.findViewById(R.id.tv_img);

        }
    }
}
