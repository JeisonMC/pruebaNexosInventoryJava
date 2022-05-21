package com.Nexos.Inventory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Entity
@Table(name = "inventory_log")
public class InventoryLog {
    @Id
    @Column(name = "inventory_log_id", nullable = false, unique = true)
    private UUID inventoryLogId = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "id")
    private Inventory inventory;

    @Column
    private String name;

    @Column
    private String quantity;

    @Column(name = "admission_date")
    private String admissionDate;

    @Column(name = "origin_user_id")
    private UUID originUserId;

    @Column(name = "person_modifications")
    private String personModifications;

    @Column(name = "create_at")
    private LocalDateTime createAt = LocalDateTime.now(ZoneOffset.UTC);

    @Column(name = "update_at")
    private LocalDateTime updateAt = LocalDateTime.now(ZoneOffset.UTC);

    public InventoryLog() {

    }

    public InventoryLog(UUID inventoryLogId, Inventory inventory, String name, String quantity, String admissionDate, UUID originUserId, String personModifications, LocalDateTime createAt, LocalDateTime updateAt) {
        this.inventoryLogId = inventoryLogId;
        this.inventory = inventory;
        this.name = name;
        this.quantity = quantity;
        this.admissionDate = admissionDate;
        this.originUserId = originUserId;
        this.personModifications = personModifications;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public UUID getInventoryLogId() {
        return inventoryLogId;
    }

    public void setInventoryLogId(UUID inventoryLogId) {
        this.inventoryLogId = inventoryLogId;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public UUID getOriginUserId() {
        return originUserId;
    }

    public void setOriginUserId(UUID originUserId) {
        this.originUserId = originUserId;
    }

    public String getPersonModifications() {
        return personModifications;
    }

    public void setPersonModifications(String personModifications) {
        this.personModifications = personModifications;
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
        return "InventoryLog{" +
                "inventoryLogId=" + inventoryLogId +
                ", inventory=" + inventory +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", admissionDate='" + admissionDate + '\'' +
                ", originUserId=" + originUserId +
                ", personModifications='" + personModifications + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
