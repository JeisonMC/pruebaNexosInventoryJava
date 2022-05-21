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
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "person_id", nullable = false, unique = true)
    private UUID personId = UUID.randomUUID();

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private int age;

    @OneToMany(mappedBy = "person")
    private Set<Inventory> inventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "role_id")
    private Role role;

    @Column
    private LocalDateTime createAt = LocalDateTime.now(ZoneOffset.UTC);

    @Column
    private LocalDateTime updateAt;

    public Person() {

    }

    public Person(
            UUID personId,
            String email,
            String password,
            String name,
            int age,
            Role role,
            LocalDateTime createAt,
            LocalDateTime updateAt) {

        this.personId = personId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.role = role;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
}
