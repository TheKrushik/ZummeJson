
package info.krushik.android.zummejson.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class ResponseOperator implements Parcelable {

    @SerializedName("destination")
    private String destination;

    @SerializedName("isMobile")
    private Boolean isMobile;

    @SerializedName("rates")
    private List<ResponseApp> rates = new ArrayList<>();


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Boolean getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(Boolean isMobile) {
        this.isMobile = isMobile;
    }

    public List<ResponseApp> getRates() {
        return rates;
    }

    public void setRates(List<ResponseApp> rates) {
        this.rates = rates;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(destination);
        dest.writeByte((byte) (isMobile ? 1 : 0));
        dest.writeList(rates);
    }

    public static final Creator<ResponseOperator> CREATOR = new Creator<ResponseOperator>() {
        public ResponseOperator createFromParcel(Parcel in) {
            return new ResponseOperator(in);
        }
        public ResponseOperator[] newArray(int size) {
            return new ResponseOperator[size];
        }
    };

    public ResponseOperator(Parcel in) {
        destination = in.readString();
        isMobile = in.readByte() != 0;
        in.readList(rates, null);
    }
}
