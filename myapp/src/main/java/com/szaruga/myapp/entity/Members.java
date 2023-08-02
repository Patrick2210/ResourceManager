package com.szaruga.myapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id")
    private List<Items> items;

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

    public List<Items> getItems() {
        return items;
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

    public void setItems(List<Items> items) {
        this.items = items;
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

    public void add(Items tempItems) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(tempItems);
    }

    public static class Builder {
        private int id;
        private String nickName;
        private String firstName;
        private String lastName;
        private LocalDateTime creationDate;
        private LocalDateTime modificationDate;
        private String userType;

        public Builder() {
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Builder modificationDate(LocalDateTime modificationDate) {
            this.modificationDate = modificationDate;
            return this;
        }

        public Builder userType(String userType) {
            this.userType = userType;
            return this;
        }

        public Members build() {
            Members members = new Members();
            members.id = this.id;
            members.nickName = this.nickName;
            members.firstName = this.firstName;
            members.lastName = this.lastName;
            members.creationDate = this.creationDate;
            members.modificationDate = this.modificationDate;
            members.userType = this.userType;
            return members;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}