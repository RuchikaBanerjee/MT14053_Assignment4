package com.example.ruchika.test4;

import retrofit.RestAdapter;

/**
 * Created by ruchika on 4/6/15.
 */
public class uploadfiles {

    private static FileAPI REST_CLIENT;
    private static final String TEST_URL =
            "http://localhost:8080";


    public uploadfiles() {}

    public static FileAPI get() {

        return REST_CLIENT;
    }

    private FileAPI file_test = new RestAdapter.Builder()
            .setEndpoint(TEST_URL)
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build()
            .create(FileAPI.class);


    public String testfile(String test) throws Exception{


        String s1 = file_test.getFileList();
        file_test.addFile("hello");
        System.out.println(test);
        System.out.println(s1);
        return s1;

    }
    public String addtestfile(String test) throws Exception{


        //String s1 = file_test.getFileList();
        String s = file_test.addFile("hello");
        System.out.println(test);
        //System.out.println(s1);
        return s;

    }

    public static void main(String args[]) throws Exception {

        uploadfiles uf = new uploadfiles();
        uf.testfile("Ruchika");
        uf.addtestfile("bhaiiiii");
        //VideoList vl = new VideoList("Comedy","Ruchika", "20", "5");
        //System.out.println(vl.getName());
        //uf.testfile(f);
    }
}