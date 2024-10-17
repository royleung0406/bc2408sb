package com.bootcamp2408.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp2408.bc_forum.entity.CommentEntity;
import com.bootcamp2408.bc_forum.model.CommentDTO;

public interface CommentOperation {


  @GetMapping("/bcf/comments")
  List<CommentDTO> getComments();

  @PostMapping("/bcf/comments")
  List<CommentEntity> createComments();

  
  @PutMapping("/bcf/comments") // by PK
  CommentEntity updateComment(@RequestParam Long id, @RequestBody CommentEntity entity); 
}

