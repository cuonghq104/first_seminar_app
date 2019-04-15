package ptit.cuonghq.hny.detail;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MovieRemoteDataSource implements MovieDataSource.RemoteDataSource {

    private static MovieRemoteDataSource sInstance;

    private MovieRemoteDataSource() {

    }

    public static MovieRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new MovieRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getDetailInformation(int idMovie, MovieDataSource.LoadMovieDetailCallback callback) {
        movieDetailObservable(idMovie).subscribeWith(movieDetailDisposableObserver(callback));
    }

    @Override
    public void getMovieCredit(int idMovie, MovieDataSource.LoadMovieCreditCallback callback) {
        creditObservable(idMovie).subscribeWith(creditDisposableObserver(callback));
    }


    public Observable<MovieDetail> movieDetailObservable(int idMovie) {
        return NetworkClient.getRetrofit().create(MovieServices.class)
                .getMovieDetail(idMovie, "0215b006821d0643612f3462ea61ce1c")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<MovieDetail> movieDetailDisposableObserver(final MovieDataSource.LoadMovieDetailCallback callback) {
        return new DisposableObserver<MovieDetail>() {
            @Override
            public void onNext(MovieDetail movieDetail) {
                callback.onDataLoaded(movieDetail);
            }

            @Override
            public void onError(Throwable e) {
                callback.onDataNotAvailable();
            }

            @Override
            public void onComplete() {

            }
        };
    }

    public Observable<Credit> creditObservable(int idMovie) {
        return NetworkClient.getRetrofit()
                .create(MovieServices.class)
                .getMovieCredit(idMovie, "0215b006821d0643612f3462ea61ce1c")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<Credit> creditDisposableObserver(final MovieDataSource.LoadMovieCreditCallback callback) {
        return new DisposableObserver<Credit>() {
            @Override
            public void onNext(Credit credit) {
                callback.onDataLoaded(credit);
            }

            @Override
            public void onError(Throwable e) {
                callback.onDataNotAvailable(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }
}
