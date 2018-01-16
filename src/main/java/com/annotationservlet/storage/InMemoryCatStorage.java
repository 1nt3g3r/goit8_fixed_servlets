package com.annotationservlet.storage;

import com.annotationservlet.entity.Cat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCatStorage implements ICatStorage {
    private long catId;

    private Map<Long, Cat> cats = new HashMap<Long, Cat>();

    public Cat add(Cat cat) {
        cat.setId(catId++);
        cats.put(cat.getId(), cat);
        return cat;
    }

    public void delete(Cat cat) {
        cats.remove(cat.getId());
    }

    public Cat get(long catId) {
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
