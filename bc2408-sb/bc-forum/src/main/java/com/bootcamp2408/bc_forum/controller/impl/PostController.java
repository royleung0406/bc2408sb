package com.bootcamp2408.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp2408.bc_forum.controller.PostOperation;
import com.bootcamp2408.bc_forum.entity.PostEntity;
import com.bootcamp2408.bc_forum.model.PostDTO;
import com.bootcamp2408.bc_forum.service.PostService;


@RestController
public class PostController implements PostOperation {
// A new Thread
// JPHController c = get bean from Context
// c.getUsers();

  @Autowired
  private PostService postService; // Interface

  @Override
  public List<PostDTO> getPosts(){
    return this.postService.getPosts();
  }


  @Override
  public List<PostEntity> createPosts(){
    return this.postService.savePosts();
  }

  
  @Override
  public PostEntity updatePost(Long id, PostEntity entity){
    return this.postService.updatePost(id, entity);
  }

 
}



  