package com.annotationservlet.storage;

import com.annotationservlet.entity.Cat;

import java.util.List;

public interface ICatStorage {
    Cat add(Cat cat);
    void delete(Cat cat);
    Cat get(long catId);
    List<Cat> listAllCats();
    Cat update(Cat cat);
}
