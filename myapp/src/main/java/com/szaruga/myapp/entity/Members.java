package com.szaruga.myapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "members")
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nickname")
    private String nickName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "modification_date")
    private LocalDateTime modificationDate;
    @Column(name = "user_type")
    private String userType;

    public Members() {
    }

    public Members(String nickName,
                 String firstName,
                 String lastName,
                 LocalDateTime creationDate,
                 LocalDateTime modificationDate,
                 String userType) {

        this.nickName = nickName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.userType = userType;
    }

    public Integer getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Members{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", userType='" + userType + '\'' +
                '}';
    }
}
