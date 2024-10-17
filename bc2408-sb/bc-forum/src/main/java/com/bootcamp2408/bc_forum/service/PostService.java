package com.bootcamp2408.bc_forum.service;

import java.util.List;
import com.bootcamp2408.bc_forum.entity.PostEntity;
import com.bootcamp2408.bc_forum.model.PostDTO;



public interface PostService {
  List<PostDTO> getPosts();
  List<PostEntity> savePosts();
  PostEntity updatePost(Long id, PostEntity entity);
  
} 
  

