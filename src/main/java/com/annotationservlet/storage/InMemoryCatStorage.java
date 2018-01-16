package com.annotationservlet.storage;

import com.annotationservlet.entity.Cat;

import java.util.*;

public class InMemoryCatStorage implements ICatStorage {
    private long catId;

    private Map<UUID, Cat> cats = new HashMap<UUID, Cat>();

    public Cat add(Cat cat) {
        UUID uuid = UUID.randomUUID();
        cat.setId(uuid);
        cats.put(cat.getId(), cat);
        return cat;
    }

    public void delete(Cat cat) {
        cats.remove(cat.getId());
    }

    public Cat get(UUID catId) {
        return cats.get(catId);
    }

    public List<Cat> listAllCats() {
        List<Cat> result = new ArrayList<Cat>();
        for(Cat cat : cats.values()) {
            result.add(cat);
        }
        return result;
    }

    public Cat update(Cat cat) {
        Cat original = cats.get(cat.getId());
        original.setName(cat.getName());
        original.setSex(cat.getSex());
        return original;
    }
}
