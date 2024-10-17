package com.bootcamp2408.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp2408.bc_forum.entity.CommentEntity;
import com.bootcamp2408.bc_forum.model.CommentDTO;

// JPHMapper -> object (bean) -> map()
@Component
public class CommentMapper {
  // reivse from static method to instance
  public CommentEntity map(CommentDTO commentDTO) {
    return CommentEntity.builder() //
        .id(commentDTO.getId()).name(commentDTO.getName())
        .email(commentDTO.getEmail()).body(commentDTO.getBody()).build();
  }
}
