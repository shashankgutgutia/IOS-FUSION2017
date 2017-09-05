package com.adgvit.iosfusion2017;

public class ApiUtils {

    public static final String BASE_URL="https://ios-fusion.herokuapp.com/";
    public static ApiServices getAPIService(){
        return RetrofitClient.getClient(BASE_URL).create(ApiServices.class);
    }

}
