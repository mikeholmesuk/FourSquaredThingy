package com.tech.mike.builder.foursquare;

import com.tech.mike.client.foursquare.dto.Contact;

public class ContactBuilder {
    private String phone = null;
    private String twitter = null;
    private String facebook = null;

    public ContactBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ContactBuilder withTwitter(String twitter) {
        this.twitter = twitter;
        return this;
    }

    public ContactBuilder withFacebook(String facebook) {
        this.facebook = facebook;
        return this;
    }

    public Contact build() {
        Contact contact = new Contact();
        contact.setPhone(this.phone);
        contact.setTwitter(this.twitter);
        contact .setFacebook(this.facebook);
        return contact;
    }
}
