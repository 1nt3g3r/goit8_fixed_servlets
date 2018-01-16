package com.annotationservlet;

import com.annotationservlet.entity.Cat;
import com.annotationservlet.storage.HibernateCatStorage;
import com.annotationservlet.storage.ICatStorage;
import com.annotationservlet.storage.InMemoryCatStorage;

public class App {
    private static final App INSTANCE = new App();

    private ICatStorage storage = new HibernateCatStorage();

    private App() {
    }

    public static App getInstance() {
        return INSTANCE;
    }

    public ICatStorage getStorage() {
        return storage;
    }
}
