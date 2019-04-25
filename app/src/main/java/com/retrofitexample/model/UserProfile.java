
package com.retrofitexample.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class UserProfile {

    @SerializedName("msg")
    private String mMsg;
    @SerializedName("response")
    private Response mResponse;
    @SerializedName("ridelist")
    private List<Object> mRidelist;
    @SerializedName("status")
    private String mStatus;

    public String getMsg() {
        return mMsg;
    }

    public void setMsg(String msg) {
        mMsg = msg;
    }

    public Response getResponse() {
        return mResponse;
    }

    public void setResponse(Response response) {
        mResponse = response;
    }

    public List<Object> getRidelist() {
        return mRidelist;
    }

    public void setRidelist(List<Object> ridelist) {
        mRidelist = ridelist;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "mMsg='" + mMsg + '\'' +
                ", mResponse=" + mResponse +
                ", mRidelist=" + mRidelist +
                ", mStatus='" + mStatus + '\'' +
                '}';
    }
}
