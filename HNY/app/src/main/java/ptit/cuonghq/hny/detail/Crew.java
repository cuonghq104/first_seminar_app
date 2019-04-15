package ptit.cuonghq.hny.detail;

import com.google.gson.annotations.SerializedName;

public class Crew extends Person{
    @SerializedName("job")
    private String job;
    @SerializedName("department")
    private String department;
    @SerializedName("credit_id")
    private String creditId;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }
}
