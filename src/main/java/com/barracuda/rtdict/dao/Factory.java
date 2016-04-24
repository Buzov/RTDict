package com.barracuda.rtdict.dao;

import com.barracuda.rtdict.dao.impl.WordDaoImplH2;

public class Factory {

    private static WordDaoImplH2 wordDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public WordDaoImplH2 getWordDAO() {
        if (wordDAO == null) {
            wordDAO = new WordDaoImplH2();
        }
        return wordDAO;
    }
}
