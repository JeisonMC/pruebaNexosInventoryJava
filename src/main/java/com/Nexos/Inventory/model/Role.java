package com.Nexos.Inventory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "role_id", nullable = false, unique = true)
    private UUID roleId = UUID.randomUUID();

    @Column
    private String name;

    @Column
    private LocalDateTime createAt = LocalDateTime.now(ZoneOffset.UTC);

    @Column
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "role")
    @JsonBackReference
    private Set<Person> person;

    public Role(UUID roleId, String name, LocalDateTime createAt, LocalDateTime updateAt) {
        this.roleId = roleId;
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Role() {

    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId =" + roleId +
                ", name='" + name + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
