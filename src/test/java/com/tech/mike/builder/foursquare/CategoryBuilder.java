package com.tech.mike.builder.foursquare;

import com.tech.mike.client.foursquare.dto.Category;

import java.util.List;

public class CategoryBuilder {
    private String id;
    private String name;
    private String pluralName;
    private String shortName;
    private String icon;
    private String prefix;
    private List<Category> categories;

    public CategoryBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public CategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CategoryBuilder withPluralName(String pluralName) {
        this.pluralName = pluralName;
        return this;
    }

    public CategoryBuilder withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public CategoryBuilder withIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public CategoryBuilder withCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Category build() {
        return new Category();
    }
}
