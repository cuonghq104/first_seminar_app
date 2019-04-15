package ptit.cuonghq.hny.detail;

public class MovieDataSource {

    interface LoadMovieDetailCallback {

        void onDataLoaded(MovieDetail movieDetail);

        void onDataNotAvailable();
    }

    interface LoadMovieCreditCallback {

        void onDataLoaded(Credit credit);

        void onDataNotAvailable(String msg);
    }

    interface RemoteDataSource {

        void getDetailInformation(int idMovie, LoadMovieDetailCallback callback);

        void getMovieCredit(int idMovie, LoadMovieCreditCallback callback);
    }
}
