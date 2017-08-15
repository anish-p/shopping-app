package com.tw.shoppingapp.entities;

public abstract class Entity {

    private Long id;

    protected Entity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
