package ptit.cuonghq.hny.person;

import ptit.cuonghq.hny.data.datasource.PersonDataSource;
import ptit.cuonghq.hny.data.networks.models.PersonImage;
import ptit.cuonghq.hny.data.networks.models.PersonInfo;
import ptit.cuonghq.hny.data.networks.models.PersonMovieCredit;
import ptit.cuonghq.hny.data.repositories.PersonRepository;

public class PersonPresenter implements PersonContract.Presenter {

    private PersonRepository mRepository;
    private PersonContract.View mView;

    public PersonPresenter(PersonContract.View mView) {
        this.mView = mView;
        mRepository = PersonRepository.getInstance();
    }

    @Override
    public void loadInformation(int id) {
        mRepository.getPersonInfo(id, new PersonDataSource.LoadInformationCallback() {
            @Override
            public void success(PersonInfo info) {
                mView.loadInformationSuccess(info);
            }

            @Override
            public void failed(String msg) {
                mView.loadInformationFailed(msg);
            }
        });
    }

    @Override
    public void loadImages(int id) {
        mRepository.getPersonImages(id, new PersonDataSource.LoadImagesCallback() {
            @Override
            public void success(PersonImage image) {
                mView.loadImagesSuccess(image);
            }

            @Override
            public void failed(String msg) {
                mView.loadImagesFailed(msg);
            }
        });
    }

    @Override
    public void loadRelatedMovies(int id) {
        mRepository.getMovieCredit(id, new PersonDataSource.LoadRelatedMovieCallback() {
            @Override
            public void success(PersonMovieCredit credit) {
                mView.loadRelatedMoviesSuccess(credit);
            }

            @Override
            public void failed(String msg) {
                mView.loadRelatedMovieFailed(msg);
            }
        });
    }
}
