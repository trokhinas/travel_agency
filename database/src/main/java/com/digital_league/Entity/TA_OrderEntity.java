package com.digital_league.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "public", catalog = "travel_agency")
public class TA_OrderEntity {

    private long orderId;
    private boolean confirmed;
    private Date timeKey;


    private TA_UserEntity user;
    private TA_TourEntity tour;


    @Id
    @Column(name = "order_id", nullable = false)
    public long getOrderId() {
        return orderId;
    }
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }


    @Basic
    @Column(name = "confirmed", nullable = false)
    public boolean isConfirmed() {
        return confirmed;
    }
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }


    @Basic
    @Column(name = "time_key", nullable = true)
    public Date getTimeKey() {
        return timeKey;
    }
    public void setTimeKey(Date timeKey) {
        this.timeKey = timeKey;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "user_id")
    public TA_UserEntity getUser() {
        return user;
    }
    public void setUser(TA_UserEntity user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tourId", referencedColumnName = "tour_id")
    public TA_TourEntity getTour() {
        return tour;
    }
    public void setTour(TA_TourEntity tour) {
        this.tour = tour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TA_OrderEntity that = (TA_OrderEntity) o;
        return orderId == that.orderId &&
                confirmed == that.confirmed &&
                Objects.equals(timeKey, that.timeKey);
    }
    @Override
    public int hashCode() {
        return Objects.hash(orderId, confirmed, timeKey);
    }



}
