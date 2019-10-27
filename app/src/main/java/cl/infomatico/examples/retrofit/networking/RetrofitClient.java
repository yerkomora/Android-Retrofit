package cl.infomatico.examples.retrofit.networking;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.internal.EverythingIsNonNull;

public class RetrofitClient {

    private static final String URL = "https://example.cl/api/";
    private static final String API_KEY = "APIKEY";
    private RetrofitApi retrofitApi;

    public RetrofitClient() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitApi = retrofit.create(RetrofitApi.class);
    }

    public void get() {
        retrofitApi.get().enqueue(new Callback<Response>() {
            @Override
            @EverythingIsNonNull
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
            }

            @Override
            @EverythingIsNonNull
            public void onFailure(Call<Response> call, Throwable t) {
            }
        });
    }

    public void formUrlEncode_post() {
        retrofitApi.formUrlEncode_post("head", "body").enqueue(new Callback<Response>() {
            @Override
            @EverythingIsNonNull
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
            }

            @Override
            @EverythingIsNonNull
            public void onFailure(Call<Response> call, Throwable t) {
            }
        });
    }

    public void multiPart_Post() {
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), "requestBody");

        File file = new File("image.jpg");
        RequestBody requestBody2 = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("image", file.getName(), requestBody2);

        retrofitApi.multiPart_Post(requestBody, part).enqueue(new Callback<Response>() {
            @Override
            @EverythingIsNonNull
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
            }

            @Override
            @EverythingIsNonNull
            public void onFailure(Call<Response> call, Throwable t) {
            }
        });
    }
}