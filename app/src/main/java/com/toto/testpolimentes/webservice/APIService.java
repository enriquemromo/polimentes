package com.toto.testpolimentes.webservice;


import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Query;

public interface APIService {

    @PATCH("solicitantes/getByEmail/1/")
    Call<ResponseBody> requestCredit(@Query("user") String user);

    @GET("helloworld/images")
    Call<List<?>> getImages();

}
