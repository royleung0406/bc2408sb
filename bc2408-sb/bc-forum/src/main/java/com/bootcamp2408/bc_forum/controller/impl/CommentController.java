package com.bootcamp2408.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp2408.bc_forum.controller.CommentOperation;
import com.bootcamp2408.bc_forum.entity.CommentEntity;
import com.bootcamp2408.bc_forum.model.Comment;
import com.bootcamp2408.bc_forum.service.CommentService;


@RestController
public class CommentController implements CommentOperation {
// A new Thread
// JPHController c = get bean from Context
// c.getUsers();

  @Autowired
  private CommentService commentService; // Interface

  @Override
  public List<Comment> getComments(){
    return this.commentService.getComments();
  }


  @Override
  public List<CommentEntity> createComments(){
    return this.commentService.saveComments();
  }

  
  @Override
  public CommentEntity updateComment(Long id, CommentEntity entity){
    return this.commentService.updateComment(id, entity);
  }

 
}



  