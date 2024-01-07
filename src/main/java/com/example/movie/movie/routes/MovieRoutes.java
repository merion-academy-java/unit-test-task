package com.example.movie.movie.routes;

import com.example.movie.base.routes.BaseRoutes;

public class MovieRoutes {
    private final static String ROOT = BaseRoutes.API + "/movie";

    public final static String CREATE = ROOT;
    public final static String BY_ID = ROOT + "/{id}";
    public final static String EDIT = BY_ID;
    public final static String SEARCH = ROOT;
}
