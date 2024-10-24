package com.bootcamp2408.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp2408.bc_forum.entity.PostEntity;
import com.bootcamp2408.bc_forum.model.Post;


// JPHMapper -> object (bean) -> map()
@Component
public class PostMapper {
  // reivse from static method to instance
  public PostEntity map(Post postDTO) {
    return PostEntity.builder() //
        .post_id(postDTO.getId()).title(postDTO.getTitle()).body(postDTO.getBody())
//        .commentEntity(postDTO.())//
        .build();
  }
}
