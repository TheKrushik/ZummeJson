package info.krushik.android.zummejson.model;


import com.google.gson.annotations.SerializedName;


public class RequestUser {

    @SerializedName("currency")
    private String currency;

    @SerializedName("language")
    private String language;

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("platform")
    private String platform;

    @SerializedName("user_id")
    private Integer userId;

    public RequestUser(String currency, String language, String phoneNumber, String platform, Integer userId) {
        this.currency = currency;
        this.language = language;
        this.phoneNumber = phoneNumber;
        this.platform = platform;
        this.userId = userId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}

