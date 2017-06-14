package com.taorenqi.xiula.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taorenqi.xiula.R;
import com.taorenqi.xiula.adapter.MineGridAdapter;
import com.taorenqi.xiula.common.fragmentation.SwipeBackFragment;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.impl.OnCompatItemClickListener;
import com.yanzhenjie.album.util.DisplayUtils;
import com.yanzhenjie.album.widget.recyclerview.AlbumVerticalGirdDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends SwipeBackFragment {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.none_view)
    TextView noneView;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;

    private static final int ACTIVITY_REQUEST_SELECT_PHOTO = 100;
    private static final int ACTIVITY_REQUEST_TAKE_PICTURE = 101;
    private static final int ACTIVITY_REQUEST_PREVIEW_PHOTO = 102;

    private MineGridAdapter mGridAdapter;
    private ArrayList<String> mImageList;

    public static MineFragment newInstance() {
        // Required empty public constructor
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        toolbarTitle.setText("我的");

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.decoration_white, null);
        mRecyclerView.addItemDecoration(new AlbumVerticalGirdDecoration(drawable));

        assert drawable != null;
        int itemSize = (DisplayUtils.screenWidth - (drawable.getIntrinsicWidth() * 4)) / 3;
        mGridAdapter = new MineGridAdapter(mActivity, new OnCompatItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                previewImage(position);
            }
        }, itemSize);
        mRecyclerView.setAdapter(mGridAdapter);

        mImageList = new ArrayList<>();
    }

    //逻辑操作（网络请求）
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    /**
     * Select image from fromAlbum.
     */
    private void fromAlbum() {
        Album.album(this)
                .requestCode(ACTIVITY_REQUEST_SELECT_PHOTO)
                .toolBarColor(ContextCompat.getColor(mActivity, R.color.colorPrimary)) // Toolbar color.
                .statusBarColor(ContextCompat.getColor(mActivity, R.color.colorPrimaryDark)) // StatusBar color.
                .navigationBarColor(ActivityCompat.getColor(mActivity, R.color.colorPrimaryDark)) // NavigationBar color.
                .selectCount(9) // select count.
                .columnCount(2) // span count.
                .camera(true) // has fromCamera function.
                .checkedList(mImageList) // The picture has been selected for anti-election.
                .start();
    }

    /**
     * Take a picture from fromCamera.
     */
    private void fromCamera() {
        Album.camera(this)
                .requestCode(ACTIVITY_REQUEST_TAKE_PICTURE)
//                .imagePath() // Specify the image path, optional.
                .start();
    }

    /**
     * Preview image.
     *
     * @param position current position.
     */
    private void previewImage(int position) {
        Album.gallery(this)
                .requestCode(ACTIVITY_REQUEST_PREVIEW_PHOTO)
                .toolBarColor(ContextCompat.getColor(mActivity, R.color.colorPrimary)) // Toolbar color.
                .statusBarColor(ContextCompat.getColor(mActivity, R.color.colorPrimaryDark)) // StatusBar color.
                .navigationBarColor(ActivityCompat.getColor(mActivity, R.color.colorPrimaryDark)) // NavigationBar color.
                .checkedList(mImageList) // Image list.
                .currentPosition(position) // Preview first to show the first few.
                .checkFunction(true) // Does the user have an anti-selection when previewing.
                .start();

    }

    @Override
    protected void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        switch (requestCode) {
//            case ACTIVITY_REQUEST_SELECT_PHOTO: {
//                if (resultCode == RESULT_OK) { // Successfully.
//                    mImageList = Album.parseResult(data); // Parse select result.
//                    refreshImage();
//                } else if (resultCode == RESULT_CANCELED) { // User canceled.
//                    Snackbar.make(noneView, R.string.cancel_select_photo_hint, Snackbar.LENGTH_LONG).show();
//                }
//                break;
//            }
//            case ACTIVITY_REQUEST_TAKE_PICTURE: {
//                if (resultCode == RESULT_OK) { // Successfully.
//                    List<String> imageList = Album.parseResult(data); // Parse path.
//                    mImageList.addAll(imageList);
//                    refreshImage();
//                } else if (resultCode == RESULT_CANCELED) { // User canceled.
//                    Snackbar.make(noneView, R.string.cancel_select_photo_hint, Snackbar.LENGTH_LONG).show();
//                }
//                break;
//            }
//            case ACTIVITY_REQUEST_PREVIEW_PHOTO: {
//                if (resultCode == RESULT_OK) { // Successfully.
//                    mImageList = Album.parseResult(data); // Parse select result.
//                    refreshImage();
//                }
//                break;
//            }
        }
    }

    /**
     * Process selection results.
     */
    private void refreshImage() {
        mGridAdapter.notifyDataSetChanged(mImageList);
        if (mImageList == null || mImageList.size() == 0) {
            noneView.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        } else {
            noneView.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
