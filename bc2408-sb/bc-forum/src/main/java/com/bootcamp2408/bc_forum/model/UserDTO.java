package com.bootcamp2408.bc_forum.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address; // One-to-one
    private String phone;
    private String website;
    private Company company; // One-to-one
    @Builder.Default
    private List<PostDTO> postDTO = new ArrayList<>();


    @Data
    @AllArgsConstructor
    @Builder
    @NoArgsConstructor
    public static class PostDTO{
    private int id;
    private String title;
    private String body;
    @Builder.Default
    private List<CommentDTO> commentDTO = new ArrayList<>();
    }

    @Data
    @AllArgsConstructor
    @Builder
    @NoArgsConstructor
    public static class CommentDTO{
    private int id;
    private String name;
    private String email;
    private String body;
    }

    @Data
    @AllArgsConstructor
    @Builder
    @NoArgsConstructor
    public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
  
      @Data
      @AllArgsConstructor
      @Builder
      @NoArgsConstructor
      public static class Geo {
        private String lat;
        private String lng;
      }
    }
  
    @Data
    @AllArgsConstructor
    @Builder
    @NoArgsConstructor
    public static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
    }
  }

