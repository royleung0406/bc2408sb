package com.bootcamp2408.bc_forum.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@Data
@Builder
@ToString
public class User {
  private Integer id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  @Getter
  @Builder
  @ToString
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

  @Getter
  @Builder
  @ToString
    public static class Geo {
      private String lat;
      private String lng;
    }
  }

  @Getter
  @Builder
  @ToString
  public static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}