package ptit.cuonghq.hny.detail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDetail {

    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("video")
    private boolean video;
    @SerializedName("title")
    private String title;
    @SerializedName("tagline")
    private String tagline;
    @SerializedName("status")
    private String status;
    @SerializedName("spoken_languages")
    private List<SpokenLanguages> spokenLanguages;
    @SerializedName("runtime")
    private int runtime;
    @SerializedName("revenue")
    private int revenue;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("production_countries")
    private List<ProductionCountries> productionCountries;
    @SerializedName("production_companies")
    private List<ProductionCompanies> productionCompanies;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("overview")
    private String overview;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("imdb_id")
    private String imdbId;
    @SerializedName("id")
    private int id;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("genres")
    private List<Genres> genres;
    @SerializedName("budget")
    private int budget;
    @SerializedName("belongs_to_collection")
    private BelongsToCollection belongsToCollection;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("adult")
    private boolean adult;

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SpokenLanguages> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguages> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<ProductionCountries> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountries> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public List<ProductionCompanies> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompanies> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
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

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public BelongsToCollection getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(BelongsToCollection belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
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
}
