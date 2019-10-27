package cl.infomatico.examples.retrofit.networking;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface RetrofitApi {
    @GET("get/")
    Call<Response> get();

    @FormUrlEncoded
    @POST("formUrlEncode-Post/")
    Call<Response> formUrlEncode_post(
            @Header("head") String head,
            @Field("body") String body
    );

    @Multipart
    @POST("multiPart-Post/")
    Call<Response> multiPart_Post(
            @Part("requestBody") RequestBody requestBody,
            @Part MultipartBody.Part part
    );
}