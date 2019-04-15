package ptit.cuonghq.hny.person;

import ptit.cuonghq.hny.data.networks.models.PersonImage;
import ptit.cuonghq.hny.data.networks.models.PersonInfo;
import ptit.cuonghq.hny.data.networks.models.PersonMovieCredit;

public class PersonContract {

    interface View {

        void loadInformationSuccess(PersonInfo info);

        void loadInformationFailed(String msg);

        void loadImagesSuccess(PersonImage image);

        void loadImagesFailed(String msg);

        void loadRelatedMoviesSuccess(PersonMovieCredit movieCredit);

        void loadRelatedMovieFailed(String msg);
    }

    interface Presenter {

        void loadInformation(int id);

        void loadImages(int id);

        void loadRelatedMovies(int id);
    }
}
