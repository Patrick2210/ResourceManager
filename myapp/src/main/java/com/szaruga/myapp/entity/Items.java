package com.szaruga.myapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "items_name")
    private String itemsName;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "modification_date")
    private LocalDateTime modificationDate;
    @Column(name = "owner_id")
    private Integer ownerId;
    @Column(name = "type")
    private String type;

    @Column(name = "megadata")
    private String metaData;

    public Items() {
    }

    public Items(String itemsName,
                 LocalDateTime creationDate,
                 LocalDateTime modificationDate,
                 Integer ownerId,
                 String type,
                 String metaData) {
        this.itemsName = itemsName;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.ownerId = ownerId;
        this.type = type;
        this.metaData = metaData;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return itemsName;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public String getType() {
        return type;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.itemsName = firstName;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", itemsName='" + itemsName + '\'' +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", ownerId=" + ownerId +
                ", type='" + type + '\'' +
                ", metaData='" + metaData + '\'' +
                '}';
    }
}
