package info.krushik.android.zummejson.model;


import com.google.gson.annotations.SerializedName;


public class ResponseApp {

    @SerializedName("registration_bonus")
    private String registrationBonus;

    @SerializedName("messenger_name")
    private String messengerName;

    @SerializedName("connection_fee")
    private Double connectionFee;

    @SerializedName("sms_price")
    private Double smsPrice;

    @SerializedName("rating")
    private Double rating;

    @SerializedName("call_price")
    private Double callPrice;

    @SerializedName("number_of_comments")
    private Integer numberOfComments;

    @SerializedName("google_store_link")
    private String googleStoreLink;

    public String getRegistrationBonus() {
        return registrationBonus;
    }

    public void setRegistrationBonus(String registrationBonus) {
        this.registrationBonus = registrationBonus;
    }

    public String getMessengerName() {
        return messengerName;
    }

    public void setMessengerName(String messengerName) {
        this.messengerName = messengerName;
    }

    public Double getConnectionFee() {
        return connectionFee;
    }

    public void setConnectionFee(Double connectionFee) {
        this.connectionFee = connectionFee;
    }

    public Double getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(Double smsPrice) {
        this.smsPrice = smsPrice;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getCallPrice() {
        return callPrice;
    }

    public void setCallPrice(Double callPrice) {
        this.callPrice = callPrice;
    }

    public Integer getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(Integer numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public String getGoogleStoreLink() {
        return googleStoreLink;
    }

    public void setGoogleStoreLink(String googleStoreLink) {
        this.googleStoreLink = googleStoreLink;
    }

}
