package com.markcorazon.animals.models;

import javax.persistence.*;

@Table(name = "animals")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "age", nullable = false)
    private Integer age;

    public Animal(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public Animal() {

    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}