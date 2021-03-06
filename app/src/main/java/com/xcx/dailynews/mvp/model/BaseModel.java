package com.xcx.dailynews.mvp.model;

import android.util.Log;

import com.xcx.dailynews.bean.CollectBean;
import com.xcx.dailynews.data.CacheLoader;
import com.xcx.dailynews.mvp.ui.view.OnGetDataListener;
import com.xcx.dailynews.util.UiUtil;

import java.util.List;

import retrofit2.Retrofit;
import rx.Subscriber;

/**
 * 获取新闻相关的网络数据
 * Created by xcx on 2016/11/1.
 */

public abstract class BaseModel {

    CacheLoader mCacheLoader = CacheLoader.getInstance();

    public void setOnGetDataListener(OnGetDataListener listener) {
        mListener = listener;
    }

    public abstract void removeMemeoryCache(String channelId);

    protected OnGetDataListener mListener;
    protected Retrofit mRetrofit;

    public BaseModel() {
        mRetrofit = UiUtil.getRetrofit();
    }

    public abstract void unSubscribe();

    protected abstract void getDataFromModel(String type, String channelId, int loadType, int
            pageNum);


    public void getData(String type, String channelId, int loadType, int pageNum) {
        getDataFromModel(type, channelId, loadType, pageNum);
    }

    public void getData(String url,String type, CollectBean collectBean){

    }

    protected void initDataBase() {

    }


    class MySubscriber<T> extends Subscriber<List<T>> {

        private int loadType;

        public MySubscriber(int loadType) {
            this.loadType = loadType;
        }

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mListener.onDataFailure(e.getMessage());
        }

        @Override
        public void onNext(List<T> list) {
            Log.e("TAG", "onNext: ");
            mListener.onDataSuccess(list, loadType);
        }
    }
}
