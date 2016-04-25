package com.tech.mike.builder.foursquare;

import com.tech.mike.client.foursquare.dto.Address;
import com.tech.mike.client.foursquare.dto.Location;

public class AddressBuilder {
    private Location location = new LocationBuilder().build();
    private String addressLine;
    private String city;
    private String postalCode;

    public AddressBuilder withLocation(Location location) {
        this.location = location;
        return this;
    }

    public AddressBuilder withAddressLine(String addressLine) {
        this.addressLine = addressLine;
        return this;
    }

    public AddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public Address build() {
        Address address = new Address();
        address.setLongitude(this.location.getLongitude());
        address.setLatitude(this.location.getLatitude());
        address.setAddressLine(this.addressLine);
        address.setCity(this.city);
        address.setPostalCode(this.postalCode);

        return address;
    }
}
