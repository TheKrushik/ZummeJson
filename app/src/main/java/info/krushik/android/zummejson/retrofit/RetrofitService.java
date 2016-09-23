package info.krushik.android.zummejson.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitService {

    private static String API_URL = "https://zumme.net";
    private static ApiInterface service;
    private static  Retrofit retrofit;

    public static ApiInterface getApi() {
        if (service == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(ApiInterface.class);
            return service;
        } else {
            return service;
        }
    }
}

