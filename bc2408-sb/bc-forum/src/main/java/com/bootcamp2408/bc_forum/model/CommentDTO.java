package com.bootcamp2408.bc_forum.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CommentDTO {
private Integer id;
private String name;
private String email;
private String body;
}
