package com.tech.mike.builder.foursquare;

import com.tech.mike.client.foursquare.dto.*;
import uk.org.fyodor.generators.RDG;

import java.util.ArrayList;
import java.util.List;

public class VenueBuilder {
    private String id = RDG.string().next();
    private String name = RDG.string().next();
    private Contact contact = new ContactBuilder().build();
    private Address address = new AddressBuilder().build();
    private List<Category> categories = new ArrayList<>();
    private String url = RDG.uri().next().toString();

    public VenueBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public VenueBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public VenueBuilder withContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    public VenueBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }

    public VenueBuilder withCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public VenueBuilder withAddedCategory(Category category) {
        if (this.categories != null) {
            this.categories.add(category);
        }
        return this;
    }

    public VenueBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public Venue build() {
        Venue venue = new Venue();
        venue.setId(this.id);
        venue.setName(this.name);
        venue.setContact(this.contact);
        venue.setAddress(this.address);
        venue.setCategories(this.categories);
        venue.setUrl(this.url);
        return venue;
    }


}