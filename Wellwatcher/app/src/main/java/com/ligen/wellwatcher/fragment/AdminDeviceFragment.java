package com.ligen.wellwatcher.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ligen.wellwatcher.R;

import java.util.List;

/**
 * 管理员界面中显示device
 * Created by ligen on 2016/5/18.
 */
public class AdminDeviceFragment extends Fragment{

    String mTitle;
    List<String> mDevices;

    RecyclerView mRvDetail;
    View mView;

    public AdminDeviceFragment() {
    }

    public AdminDeviceFragment(String title, List<String> devices) {
        mTitle = title;
        mDevices = devices;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_watcher, container, false);
        TextView tv = (TextView) mView.findViewById(R.id.tv);
        tv.setText(mTitle);
        mRvDetail = (RecyclerView) mView.findViewById(R.id.rv_checkpoints);
        mRvDetail.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvDetail.setAdapter(new DetailAdapter());

        return mView;
    }



    class DetailAdapter extends RecyclerView.Adapter<DetailViewHolder> {

        @Override
        public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            DetailViewHolder holder = new DetailViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_recycler_checkpoint, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(DetailViewHolder holder, int position) {
            holder.tv.setText(mDevices.get(position));
        }

        @Override
        public int getItemCount() {
            return mDevices.size();
        }
    }

    class DetailViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public DetailViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
