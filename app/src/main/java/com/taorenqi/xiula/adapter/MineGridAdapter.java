package com.taorenqi.xiula.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.taorenqi.xiula.R;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.impl.OnCompatItemClickListener;

import java.util.List;

/**
 * Created by Administrator on 2017-06-12.
 */

public class MineGridAdapter extends RecyclerView.Adapter<MineGridAdapter.ImageViewHolder> {

    private LayoutInflater mInflater;
    private int itemSize;
    private List<String> mImagePathList;
    private OnCompatItemClickListener mItemClickListener;

    public MineGridAdapter(Context context, OnCompatItemClickListener itemClickListener, int itemSize) {
        this.mInflater = LayoutInflater.from(context);
        this.mItemClickListener = itemClickListener;
        this.itemSize = itemSize;
    }

    public void notifyDataSetChanged(List<String> imagePathList) {
        this.mImagePathList = imagePathList;
        super.notifyDataSetChanged();
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageViewHolder viewHolder = new ImageViewHolder(itemSize, mInflater.inflate(R.layout.item_mine_image, parent, false));
        viewHolder.mItemClickListener = mItemClickListener;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        holder.loadImage(mImagePathList.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return mImagePathList == null ? 0 : mImagePathList.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private OnCompatItemClickListener mItemClickListener;
        private int itemSize;
        ImageView mIvIcon;

        public ImageViewHolder(int itemSize, View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.itemSize = itemSize;
            itemView.getLayoutParams().height = itemSize;
            itemView.requestLayout();
            mIvIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
        }

        public void loadImage(String imagePath) {
            Album.getAlbumConfig().getImageLoader().loadImage(mIvIcon, imagePath, itemSize, itemSize);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

}