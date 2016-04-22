package com.tech.mike.views;

import io.dropwizard.views.View;

public class HomeView extends View {

    public HomeView() {
        super("/templates/home.ftl");
    }
}
