package com.Nexos.Inventory.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RequestUpdateInventory {

    private String name;
    private String quantity;
    @JsonProperty("admission_date")
    private String admissionDate;
    @JsonProperty("current_person_email")
    private String currentPersonEmail;


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

    public String getCurrentPersonEmail() {
        return currentPersonEmail;
    }

    public void setCurrentPersonEmail(String currentPersonEmail) {
        this.currentPersonEmail = currentPersonEmail;
    }
}
