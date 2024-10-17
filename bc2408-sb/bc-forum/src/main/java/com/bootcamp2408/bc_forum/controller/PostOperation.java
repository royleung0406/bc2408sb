package com.bootcamp2408.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp2408.bc_forum.entity.PostEntity;
import com.bootcamp2408.bc_forum.model.PostDTO;

public interface PostOperation {


  @GetMapping("/bcf/posts")
  List<PostDTO> getPosts();

  /**
   * Service Layer call external JPH service directly to refresh the user list.
   * @return
   */
  @PostMapping("/bcf/posts")
  List<PostEntity> createPosts();

  
  @PutMapping("/bcf/posts") // by PK
  PostEntity updatePost(@RequestParam Long id, @RequestBody PostEntity entity);

 
}

