package ptit.cuonghq.hny.data.networks.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cast {
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("overview")
    private String overview;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("title")
    private String title;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("genre_ids")
    private List<Integer> genreIds;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("video")
    private boolean video;
    @SerializedName("id")
    private int id;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("credit_id")
    private String creditId;
    @SerializedName("character")
    private String character;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
