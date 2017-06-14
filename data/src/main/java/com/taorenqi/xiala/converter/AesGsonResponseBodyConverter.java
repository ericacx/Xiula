package com.taorenqi.xiala.converter;

import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.StringReader;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Administrator on 2017-06-13.
 */

public class AesGsonResponseBodyConverter <T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    AesGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody responseBody) throws IOException {
//        try {
//            // TODO: 2016/12/26 设计你自己的响应体解密算法，下面使用了Base64解码
//
//            String response = responseBody.string();
//            String strResult = response.substring(1,response.length() - 1);
////            String decodeBody = DesWrapper.decodeValue(DesWrapper.getDecodeKey(), responseBody.toString());
////            String decodeBody = Base64.decode(responseBody.toString());
//            //Base64解码就上面一行，大家可以自行设计算法
//            Log.e("AesJsonFactory:", decodeBody);
//            JsonReader jsonReader = gson.newJsonReader(new StringReader(decodeBody));
//            try {
//                return adapter.read(jsonReader);
//            } finally {
//                responseBody.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }
}