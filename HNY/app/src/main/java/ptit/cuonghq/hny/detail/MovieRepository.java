package ptit.cuonghq.hny.detail;

public class MovieRepository {

    private MovieRemoteDataSource remoteDataSource;

    private MovieRepository(MovieRemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    private static MovieRepository sInstance;

    public static MovieRepository getInstance() {
        if (sInstance == null) {
            sInstance = new MovieRepository(MovieRemoteDataSource.getInstance());
        }
        return sInstance;
    }

    public void getMovieDetail(int idMovie, MovieDataSource.LoadMovieDetailCallback callback) {
        if (remoteDataSource != null) {
            remoteDataSource.getDetailInformation(idMovie, callback);
        }
    }

    public void getMovieCredit(int idMovie, MovieDataSource.LoadMovieCreditCallback callback) {
        if (remoteDataSource != null) {
            remoteDataSource.getMovieCredit(idMovie, callback);
        }
    }
}
