package com.markcorazon.animals.dto;

import javax.validation.constraints.*;

public class AnimalDto {
    private long id;

    @NotNull
    @Positive
    private long ownerId;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    private String type;

    @Positive
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
