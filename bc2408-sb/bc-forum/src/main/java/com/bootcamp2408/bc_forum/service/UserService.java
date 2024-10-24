package com.bootcamp2408.bc_forum.service;

import com.bootcamp2408.bc_forum.entity.PostEntity;
import com.bootcamp2408.bc_forum.entity.UserEntity;
import com.bootcamp2408.bc_forum.model.User;
import java.util.List;

public interface UserService {
  List<User> getUsers();
  List<UserEntity> saveUsers();
  UserEntity updateUser(Long id, UserEntity entity);
  List<UserEntity> saveAll(List<UserEntity> userEntities);

} 
  

