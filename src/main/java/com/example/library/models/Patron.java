package com.example.library.models;

import java.util.Objects;

public class Patron {

    private String name;
    private String id;

    public Patron(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Patron [Name=" + name + ", ID=" + id + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Patron patron = (Patron) obj;
        return id.equals(patron.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}