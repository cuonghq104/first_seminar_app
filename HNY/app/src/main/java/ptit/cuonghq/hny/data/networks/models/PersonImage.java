package ptit.cuonghq.hny.data.networks.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonImage {

    @SerializedName("id")
    private int id;
    @SerializedName("profiles")
    private List<Profiles> profiles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Profiles> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profiles> profiles) {
        this.profiles = profiles;
    }
}
