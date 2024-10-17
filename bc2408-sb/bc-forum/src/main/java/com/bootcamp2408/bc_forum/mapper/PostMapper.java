package com.bootcamp2408.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp2408.bc_forum.entity.PostEntity;
import com.bootcamp2408.bc_forum.model.PostDTO;


// JPHMapper -> object (bean) -> map()
@Component
public class PostMapper {
  // reivse from static method to instance
  public PostEntity map(PostDTO postDTO) {
    return PostEntity.builder() //
        .id(postDTO.getId()).title(postDTO.getTitle()).body(postDTO.getBody())
//        .commentEntity(postDTO.())//
        .build();
  }
}
