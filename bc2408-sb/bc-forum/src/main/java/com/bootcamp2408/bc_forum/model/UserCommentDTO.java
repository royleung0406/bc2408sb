package com.bootcamp2408.bc_forum.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Setter; 

@Data
@Builder
public class UserCommentDTO {
  private Integer id;
  private String username;
  @Setter
  @Builder.Default
  List<UserComDTO> commentDTO = new ArrayList<>();

  

  @Data
  @Setter
  @Builder
  public static class UserComDTO {
    private Integer id;
    private String name;
    private String email;
    private String body;

  }
}

