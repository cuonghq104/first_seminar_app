package ptit.cuonghq.hny.detail;

import com.google.gson.annotations.SerializedName;

public class Cast extends Person{
    @SerializedName("order")
    private int order;
    @SerializedName("character")
    private String character;
    @SerializedName("cast_id")
    private int castId;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getCastId() {
        return castId;
    }

    public void setCastId(int castId) {
        this.castId = castId;
    }
}
