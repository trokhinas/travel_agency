package com.digital_league.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "travel_agency")
public class TA_UserEntity {

    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean active;
    private Date birthday;
    private String nickname;


    private List<TA_OrderEntity> orders;


    @Id
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }


    @Basic
    @Column(name = "first_name", nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Basic
    @Column(name = "last_name", nullable = false, length = 50)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    @Basic
    @Column(name = "password", nullable = false, length = 25)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    @Basic
    @Column(name = "active", nullable = false)
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }


    @Basic
    @Column(name = "birthday", nullable = false)
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
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
        TA_UserEntity that = (TA_UserEntity) o;
        return userId == that.userId &&
                active == that.active &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(birthday, that.birthday);
    }
    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, password, active, birthday);
    }


}
