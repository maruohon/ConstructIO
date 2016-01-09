package com.nitrodev.constructio.recipes;

import com.google.common.collect.Lists;

import java.util.List;

public class CiocraftManager {

    private static final CiocraftManager instance = new CiocraftManager();
    private final List recipes = Lists.newArrayList();


    public static CiocraftManager getInstance() {
        //The static instance of this class
        return instance;
    }

    private CiocraftManager() {

    }

}

