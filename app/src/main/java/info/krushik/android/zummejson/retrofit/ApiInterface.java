package info.krushik.android.zummejson.retrofit;

import info.krushik.android.zummejson.model.RequestUser;
import info.krushik.android.zummejson.model.ResponseOperator;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface ApiInterface {

        @POST("/api/v1/rates/get/bynumber")
        Call<ResponseOperator> getOperatorApp(@Body RequestUser requestUser);
}
