package com.annotationservlet;

import com.annotationservlet.entity.Cat;
import com.annotationservlet.storage.ICatStorage;
import com.annotationservlet.storage.InMemoryCatStorage;

public class App {
    private static final App INSTANCE = new App();

    private ICatStorage storage = new InMemoryCatStorage();

    private App() {
//        for(int i = 0; i < 10; i++) {
//            Cat cat = new Cat();
//            cat.setName("Simon " + i);
//            cat.setSex(true);
//
//            storage.add(cat);
//        }
    }

    public static App getInstance() {
        return INSTANCE;
    }

    public ICatStorage getStorage() {
        return storage;
    }
}
