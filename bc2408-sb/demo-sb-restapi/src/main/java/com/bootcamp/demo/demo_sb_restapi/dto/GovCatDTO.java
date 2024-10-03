package com.bootcamp.demo.demo_sb_restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GovCatDTO {
  private Tail tail;

  @Getter
  @AllArgsConstructor
  public static class Tail {
    private double length;




  }
}

