package com.tech.mike.client.foursquare.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue {
    @NotNull(message = "'id' field cannot be NULL")
    @JsonProperty(value = "id")
    private String id;
    @NotNull(message = "'name' field cannot be NULL")
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "contact")
    private Contact contact;
    @JsonProperty(value = "location")
    private Address address;
    @JsonProperty(value = "categories")
    private List<Category> categories;
    @JsonProperty(value = "url")
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}