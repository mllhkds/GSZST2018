package com.example.a13466.gsst.db;

import com.j256.ormlite.field.DatabaseField;

/**
 * TableDemo
 */
public class Table {
    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField
    private String carid;

    @DatabaseField
    private int violcount;

    @DatabaseField
    private int minutecount;

    public Table() {}

    public Table(String carid, int violcount, int minutecount) {
        this.carid = carid;
        this.violcount = violcount;
        this.minutecount = minutecount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public int getViolcount() {
        return violcount;
    }

    public void setViolcount(int violcount) {
        this.violcount = violcount;
    }

    public int getMinutecount() {
        return minutecount;
    }

    public void setMinutecount(int minutecount) {
        this.minutecount = minutecount;
    }
}
