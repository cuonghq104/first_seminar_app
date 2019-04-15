package ptit.cuonghq.hny.detail;

import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("profile_path")
    protected String profilePath;
    @SerializedName("name")
    protected String name;
    @SerializedName("id")
    protected int id;
    @SerializedName("gender")
    protected int gender;

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
