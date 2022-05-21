package com.Nexos.Inventory.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RequestInventoryLogs {
    @JsonProperty("inventory_id")
    private String inventoryId;
    private String name;
    private String quantity;

    @JsonProperty("admission_date")
    private String admissionDate;

    @JsonProperty("origin_person")
    private String originPerson;

    @JsonProperty("person_modifications")
    private String personModifications;

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
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

    public String getOriginPerson() {
        return originPerson;
    }

    public void setOriginPerson(String originPerson) {
        this.originPerson = originPerson;
    }

    public String getPersonModifications() {
        return personModifications;
    }

    public void setPersonModifications(String personModifications) {
        this.personModifications = personModifications;
    }
}
