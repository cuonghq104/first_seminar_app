package ptit.cuonghq.hny.data.datasource;

import ptit.cuonghq.hny.data.networks.models.PersonImage;
import ptit.cuonghq.hny.data.networks.models.PersonInfo;
import ptit.cuonghq.hny.data.networks.models.PersonMovieCredit;

public class PersonDataSource {

    public interface LoadInformationCallback {

        void success(PersonInfo info);

        void failed(String msg);
    }

    public interface LoadImagesCallback {

        void success(PersonImage image);

        void failed(String msg);
    }

    public interface LoadRelatedMovieCallback {

        void success(PersonMovieCredit credit);

        void failed(String msg);
    }

    public interface RemoteDS {

        void loadInformation(int id, LoadInformationCallback callback);

        void loadImages(int id, LoadImagesCallback callback);

        void loadRelatedMovies(int id, LoadRelatedMovieCallback callback);
    }
}
