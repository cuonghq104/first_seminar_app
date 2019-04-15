package ptit.cuonghq.hny.data.networks.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonMovieCredit {

    @SerializedName("id")
    private int id;
    @SerializedName("cast")
    private List<Cast> cast;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }
}
