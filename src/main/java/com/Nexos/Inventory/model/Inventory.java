package com.Nexos.Inventory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @Column(name = "id", unique = true)
    private UUID id = UUID.randomUUID();

    @Column(unique = true)
    private String name;

    @Column
    private int quantity;

    @Column(name = "admission_date")
    private String admissionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(mappedBy = "inventory")
    private Set<InventoryLog> inventoryLog;

    @Column(name = "create_at")
    private LocalDateTime createAt = LocalDateTime.now(ZoneOffset.UTC);

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    public Inventory() {

    }

    public Inventory(UUID id, String name, int quantity, String admissionDate, Person person, Set<InventoryLog> inventoryLog, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.admissionDate = admissionDate;
        this.person = person;
        this.inventoryLog = inventoryLog;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<InventoryLog> getInventoryLog() {
        return inventoryLog;
    }

    public void setInventoryLog(Set<InventoryLog> inventoryLog) {
        this.inventoryLog = inventoryLog;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", admissionDate='" + admissionDate + '\'' +
                ", person=" + person +
                ", inventoryLog=" + inventoryLog +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
