package com.bootcamp2408.bc_forum.service;


import java.util.List;
import com.bootcamp2408.bc_forum.entity.CommentEntity;
import com.bootcamp2408.bc_forum.model.CommentDTO;

public interface CommentService {
  List <CommentDTO> getComments();
  List <CommentEntity> saveComments();
  CommentEntity updateComment(Long id, CommentEntity entity);
  
} 
  

