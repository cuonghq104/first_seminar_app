package ptit.cuonghq.hny.data.datasource.remotes;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ptit.cuonghq.hny.data.datasource.PersonDataSource;
import ptit.cuonghq.hny.data.networks.models.PersonImage;
import ptit.cuonghq.hny.data.networks.models.PersonInfo;
import ptit.cuonghq.hny.data.networks.models.PersonMovieCredit;
import ptit.cuonghq.hny.data.networks.services.PersonServices;
import ptit.cuonghq.hny.detail.NetworkClient;

public class PersonRemoteDS implements PersonDataSource.RemoteDS {

    private static PersonRemoteDS sInstance;

    public static PersonRemoteDS getInstance() {
        if (sInstance == null) {
            sInstance = new PersonRemoteDS();
        }
        return sInstance;
    }
    @Override
    public void loadInformation(int id, PersonDataSource.LoadInformationCallback callback) {
        personInfoObservable(id).subscribeWith(personInfoDisposableObserver(callback));
    }

    private Observable<PersonInfo> personInfoObservable(int id) {
        return NetworkClient.getRetrofit()
                .create(PersonServices.class)
                .getPersonInfo(id, "0215b006821d0643612f3462ea61ce1c")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<PersonInfo> personInfoDisposableObserver(final PersonDataSource.LoadInformationCallback callback) {

        return new DisposableObserver<PersonInfo>() {
            @Override
            public void onNext(PersonInfo info) {
                callback.success(info);
            }

            @Override
            public void onError(Throwable e) {
                callback.failed(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }

    @Override
    public void loadImages(int id, PersonDataSource.LoadImagesCallback callback) {
        personImageObservable(id).subscribeWith(personImageDisposableObserver(callback));
    }

    private Observable<PersonImage> personImageObservable(int id) {
        return NetworkClient.getRetrofit()
                .create(PersonServices.class)
                .getPersonImages(id, "0215b006821d0643612f3462ea61ce1c")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<PersonImage> personImageDisposableObserver(final PersonDataSource.LoadImagesCallback callback) {
        return new DisposableObserver<PersonImage>() {
            @Override
            public void onNext(PersonImage personImage) {
                callback.success(personImage);
            }

            @Override
            public void onError(Throwable e) {
                callback.failed(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }

    @Override
    public void loadRelatedMovies(int id, PersonDataSource.LoadRelatedMovieCallback callback) {
        personMovieCreditObservable(id).subscribeWith(personMovieCreditDisposableObserver(callback));
    }

    private Observable<PersonMovieCredit> personMovieCreditObservable(int id) {
        return NetworkClient.getRetrofit()
                .create(PersonServices.class)
                .getMovieCredit(id, "0215b006821d0643612f3462ea61ce1c")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<PersonMovieCredit> personMovieCreditDisposableObserver(final PersonDataSource.LoadRelatedMovieCallback callback) {
        return new DisposableObserver<PersonMovieCredit>() {
            @Override
            public void onNext(PersonMovieCredit movieCredit) {
                callback.success(movieCredit);
            }

            @Override
            public void onError(Throwable e) {
                callback.failed(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }
}
