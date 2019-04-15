package ptit.cuonghq.hny.detail;

public class DetailPresenter implements DetailContract.Presenter {

    private MovieRepository movieRepository;

    private DetailContract.View mView;

    public DetailPresenter(DetailContract.View mView) {
        this.mView = mView;
        movieRepository = MovieRepository.getInstance();
    }

    @Override
    public void getMovieDetailInformation(int movieId) {
        movieRepository.getMovieDetail(movieId, new MovieDataSource.LoadMovieDetailCallback() {
            @Override
            public void onDataLoaded(MovieDetail movieDetail) {
                mView.getMovieDetailInformationSuccess(movieDetail);
            }

            @Override
            public void onDataNotAvailable() {
                mView.getMovieDetailInformationFailed("");
            }
        });
    }

    @Override
    public void getMovieCredit(int movieId) {
        movieRepository.getMovieCredit(movieId, new MovieDataSource.LoadMovieCreditCallback() {
            @Override
            public void onDataLoaded(Credit credit) {
                mView.getMovieCreditSuccess(credit);
            }

            @Override
            public void onDataNotAvailable(String msg) {
                mView.getMovieCreditFailed(msg);
            }
        });
    }
}
