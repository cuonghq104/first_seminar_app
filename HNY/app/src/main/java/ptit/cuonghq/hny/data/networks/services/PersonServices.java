package ptit.cuonghq.hny.data.networks.services;

import io.reactivex.Observable;
import ptit.cuonghq.hny.data.networks.models.PersonImage;
import ptit.cuonghq.hny.data.networks.models.PersonInfo;
import ptit.cuonghq.hny.data.networks.models.PersonMovieCredit;
import ptit.cuonghq.hny.detail.Credit;
import ptit.cuonghq.hny.detail.MovieDetail;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PersonServices {

    @GET("person/{id_person}")
    Observable<PersonInfo> getPersonInfo(@Path("id_person") int idPerson, @Query("api_key") String apiKey);

    @GET("person/{id_person}/images")
    Observable<PersonImage> getPersonImages(@Path("id_person") int idPerson, @Query("api_key") String apiKey);

    @GET("person/{id_person}/movie_credits")
    Observable<PersonMovieCredit> getMovieCredit(@Path("id_person") int idPerson, @Query("api_key") String apiKey);
}
