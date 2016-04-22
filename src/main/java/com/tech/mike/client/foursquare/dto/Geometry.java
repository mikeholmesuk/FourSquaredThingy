package com.tech.mike.client.foursquare.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {

}

//          "geometry": {
//              "center": {
//                  "lat": 51.69815,
//                  "lng": 0.11055
//              },
//              "bounds": {
//                  "ne": {
//                      "lat": 51.71185359578459,
//                      "lng": 0.12487559578452827
//                  },
//                  "sw": {
//                      "lat": 51.69364440421522,
//                      "lng": 0.10666640421515862
//                   }
//        }
