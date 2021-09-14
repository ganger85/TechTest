package com.ganger85.repository;


import java.util.LinkedHashMap;
import java.util.Objects;

public class Record {
    String id;

    public Record(String s) {
        id = s;
    }

    public Record() {
    }

    public Record(LinkedHashMap l) {
        this.setId((String) l.get("id"));
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(id, record.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                '}';
    }
}


