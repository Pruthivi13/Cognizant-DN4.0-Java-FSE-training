package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private int id;

    @Column(name = "st_code")
    private String code;
    
    @Column(name = "st_date")
    private java.sql.Date date;

    @Column(name = "st_close")
    private java.math.BigDecimal close;

    @Column(name = "st_open")
    private java.math.BigDecimal open;

    @Column(name = "st_volume")
    private long volume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public java.math.BigDecimal getClose() {
        return close;
    }

    public void setClose(java.math.BigDecimal close) {
        this.close = close;
    }

    public java.math.BigDecimal getOpen() {
        return open;
    }

    public void setOpen(java.math.BigDecimal open) {
        this.open = open;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Stock [id=" + id + ", code=" + code + ", date=" + date +
                ", open=" + open + ", close=" + close + ", volume=" + volume + "]";
    }
}
