package com.example.ruchika.test4;

import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by ruchika on 4/6/15.
 */
public interface FileAPI {

    public static final String FILE_SVC_PATH = "/file";


    @FormUrlEncoded
    @POST("/login")
    public Void login(@Field("ruchika") String username, @Field("banerjee") String pass);

    @GET("/file")
    public String getFileList();
    
    @GET("/postfile")
    public String addFile(@Body String s);

}
