package com.digital_league.DTO;

import java.util.Date;

public class TA_TourDTO {

    private long tourId;
    private String name;
    private String description;
    private String location;
    private Date startDate;
    private Date endDate;
    private Integer countLimit;


    public long getTourId() {
        return tourId;
    }
    public void setTourId(long tourId) {
        this.tourId = tourId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCountLimit() {
        return countLimit;
    }
    public void setCountLimit(Integer countLimit) {
        this.countLimit = countLimit;
    }
}
