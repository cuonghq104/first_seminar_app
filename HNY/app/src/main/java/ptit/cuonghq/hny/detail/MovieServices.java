package ptit.cuonghq.hny.detail;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieServices {

    @GET("movie/{id_movie}")
    Observable<MovieDetail> getMovieDetail(@Path("id_movie") int idMovie, @Query("api_key") String apiKey);

    @GET("movie/{id_movie}/credits")
    Observable<Credit> getMovieCredit(@Path("id_movie") int idMovie, @Query("api_key") String apiKey);
}
