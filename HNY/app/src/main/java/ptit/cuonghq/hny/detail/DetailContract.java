package ptit.cuonghq.hny.detail;

public class DetailContract {

    interface View {

        void getMovieDetailInformationSuccess(MovieDetail detail);

        void getMovieDetailInformationFailed(String msg);

        void getMovieCreditSuccess(Credit credit);

        void getMovieCreditFailed(String msg);
    }

    interface Presenter {

        void getMovieDetailInformation(int movieId);

        void getMovieCredit(int movieId);
    }
}
