package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @ManyToMany(mappedBy = "devices")
    private Set<User> users;


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Warehouse getWarehouse() {

        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {

        this.warehouse = warehouse;
    }

    public Set<User> getUsers() {

        return users;
    }

    public void setUsers(Set<User> users) {

        this.users = users;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Device() {
    }
}
