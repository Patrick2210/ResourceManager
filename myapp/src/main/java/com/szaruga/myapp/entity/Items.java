package com.szaruga.myapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "modification_date")
    private LocalDateTime modificationDate;
    @Column(name = "owner_id")
    private Integer ownerId;
    @Column(name = "object_type")
    private String objectType;

    @Column(name = "metadata")
    private String metaData;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})

    private Members theMember;

    public Items() {
    }

    public Items(String itemName,
                 LocalDateTime creationDate,
                 LocalDateTime modificationDate,
                 Integer ownerId,
                 String objectType,
                 String metaData) {
        this.itemName = itemName;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.ownerId = ownerId;
        this.objectType = objectType;
        this.metaData = metaData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public Members getTheMember() {
        return theMember;
    }

    public void setTheMember(Members theMember) {
        this.theMember = theMember;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", ownerId=" + ownerId +
                ", objectType='" + objectType + '\'' +
                ", metaData='" + metaData + '\'' +
                '}';
    }
}
