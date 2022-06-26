package com.example.oddsmathfetcher.client.raw;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RawLiveScore {

    public String uid;
    public String status;
    public String value;
    public int status_code;
    public boolean finished;
    @JsonProperty("1stHalf")
    public String _1stHalf;
    @JsonProperty("2ndHalf")
    public String _2ndHalf;
    public boolean gameinfo;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String get_1stHalf() {
        return _1stHalf;
    }

    public void set_1stHalf(String _1stHalf) {
        this._1stHalf = _1stHalf;
    }

    public String get_2ndHalf() {
        return _2ndHalf;
    }

    public void set_2ndHalf(String _2ndHalf) {
        this._2ndHalf = _2ndHalf;
    }

    public boolean isGameinfo() {
        return gameinfo;
    }

    public void setGameinfo(boolean gameinfo) {
        this.gameinfo = gameinfo;
    }
}
