package com.taorenqi.xiala.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by Eric on 2017-03-29.
 */

public class RqJsonConverterFactory extends Converter.Factory{

    private final Gson gson;
    public static RqJsonConverterFactory create() {
        return create(new Gson());
    }


    public static RqJsonConverterFactory create(Gson gson) {
        return new RqJsonConverterFactory(gson);
    }


    private RqJsonConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }


    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {

        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new AesGsonResponseBodyConverter(gson, adapter); //响应
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {

        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new AesJsonRequestBodyConverter<>(gson, adapter); //请求
    }
}
