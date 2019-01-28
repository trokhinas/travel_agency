package com.digital_league.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tours", schema = "public", catalog = "travel_agency")
public class TA_TourEntity {

    private long tourId;
    private String name;
    private String description;
    private String location;
    private Date startDate;
    private Date endDate;
    private Integer countLimit;


    private List<TA_OrderEntity> orders;


    @Id
    @Column(name = "tour_id", nullable = false)
    @SequenceGenerator( name = "tour_sequence", sequenceName = "tours_tour_id_seq", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "tour_sequence")
    public long getTourId() {
        return tourId;
    }
    public void setTourId(long tourId) {
        this.tourId = tourId;
    }


    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "description", nullable = true, length = 500)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    @Basic
    @Column(name = "location", nullable = true, length = 50)
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }


    @Basic
    @Column(name = "start_date", nullable = false)
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    @Basic
    @Column(name = "end_date", nullable = false)
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    @Basic
    @Column(name = "count_limit", nullable = true)
    public Integer getCountLimit() {
        return countLimit;
    }
    public void setCountLimit(Integer countLimit) {
        this.countLimit = countLimit;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tour" )
    public List<TA_OrderEntity> getOrders() {
        return orders;
    }
    public void setOrders(List<TA_OrderEntity> orders) {
        this.orders = orders;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TA_TourEntity that = (TA_TourEntity) o;
        return tourId == that.tourId &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(location, that.location) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(countLimit, that.countLimit);
    }
    @Override
    public int hashCode() {
        return Objects.hash(tourId, name, description, location, startDate, endDate, countLimit);
    }


}
