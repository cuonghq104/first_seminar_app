package ptit.cuonghq.hny.data.networks.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonInfo {

    @SerializedName("imdb_id")
    private String imdbId;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("profile_path")
    private String profilePath;
    @SerializedName("place_of_birth")
    private String placeOfBirth;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("biography")
    private String biography;
    @SerializedName("gender")
    private int gender;
    @SerializedName("also_known_as")
    private List<String> alsoKnownAs;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private int id;
    @SerializedName("deathday")
    private String deathday;
    @SerializedName("known_for_department")
    private String knownForDepartment;
    @SerializedName("birthday")
    private String birthday;

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeathday() {
        return deathday;
    }

    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }

    public String getKnownForDepartment() {
        return knownForDepartment;
    }

    public void setKnownForDepartment(String knownForDepartment) {
        this.knownForDepartment = knownForDepartment;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
