package com.bootcamp2408.bc_forum.service;

import java.util.List;
import com.bootcamp2408.bc_forum.entity.PostEntity;
import com.bootcamp2408.bc_forum.model.Post;



public interface PostService {
  List<Post> getPosts();
  List<PostEntity> savePosts();
  PostEntity updatePost(Long id, PostEntity entity);
  List<PostEntity> findPostEntity(String title);
  List<PostEntity> saveAll(List<PostEntity> postEntities);
} 
  

