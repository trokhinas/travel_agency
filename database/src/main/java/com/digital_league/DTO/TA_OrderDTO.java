package com.digital_league.DTO;

import java.util.Date;

public class TA_OrderDTO {

    private long orderId;
    private boolean confirmed;
    private Date timeKey;

    //constraint info
    private long userId;
    private long tourId;


    public long getOrderId() {
        return orderId;
    }
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Date getTimeKey() {
        return timeKey;
    }
    public void setTimeKey(Date timeKey) {
        this.timeKey = timeKey;
    }

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTourId() {
        return tourId;
    }
    public void setTourId(long tourId) {
        this.tourId = tourId;
    }
}
