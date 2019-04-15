package ptit.cuonghq.hny.detail;

import com.google.gson.annotations.SerializedName;

public class ProductionCompanies {
    @SerializedName("origin_country")
    private String originCountry;
    @SerializedName("name")
    private String name;
    @SerializedName("logo_path")
    private String logoPath;
    @SerializedName("id")
    private int id;

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
