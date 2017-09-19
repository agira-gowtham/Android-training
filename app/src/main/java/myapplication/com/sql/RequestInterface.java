package myapplication.com.sql;

/**
 * Created by root on 18/9/17.
 */
import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("android/jsonandroid")
    Call<JSONResponse> getJSON();
}
