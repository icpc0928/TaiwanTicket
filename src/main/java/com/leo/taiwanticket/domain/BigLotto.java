package com.leo.taiwanticket.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BigLotto {

    @Id
    @GeneratedValue
    private long id;

    private String lottoNum;    //大樂透的號碼轉字串 (個位數+0前綴)
    private long userId;        //未來存放使用者個ID


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLottoNum() {
        return lottoNum;
    }

    public void setLottoNum(String lottoNum) {
        this.lottoNum = lottoNum;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BigLotto{" +
                "id=" + id +
                ", lottoNum='" + lottoNum + '\'' +
                ", userId=" + userId +
                '}';
    }
}
