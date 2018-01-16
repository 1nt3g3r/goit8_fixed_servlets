package com.annotationservlet.storage;

import com.annotationservlet.entity.Cat;

import java.util.List;
import java.util.UUID;

public interface ICatStorage {
    Cat add(Cat cat);
    void delete(Cat cat);
    Cat get(UUID catId);
    List<Cat> listAllCats();
    Cat update(Cat cat);
}
