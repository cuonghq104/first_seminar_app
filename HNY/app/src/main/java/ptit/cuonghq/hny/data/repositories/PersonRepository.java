package ptit.cuonghq.hny.data.repositories;

import ptit.cuonghq.hny.data.datasource.PersonDataSource;
import ptit.cuonghq.hny.data.datasource.remotes.PersonRemoteDS;

public class PersonRepository {

    private PersonRemoteDS remoteDS;

    private PersonRepository(PersonRemoteDS remoteDS) {
        this.remoteDS = remoteDS;
    }

    private static PersonRepository sInstance;

    public static PersonRepository getInstance() {
        if (sInstance == null) {
            sInstance = new PersonRepository(PersonRemoteDS.getInstance());
        }
        return sInstance;
    }

    public void getPersonInfo(int id, PersonDataSource.LoadInformationCallback callback) {
        if (remoteDS != null) {
            remoteDS.loadInformation(id, callback);
        }
    }

    public void getPersonImages(int id, PersonDataSource.LoadImagesCallback callback) {
        if (remoteDS != null) {
            remoteDS.loadImages(id, callback);
        }
    }

    public void getMovieCredit(int id, PersonDataSource.LoadRelatedMovieCallback callback) {
        if (remoteDS != null) {
            remoteDS.loadRelatedMovies(id, callback);
        }
    }

}
