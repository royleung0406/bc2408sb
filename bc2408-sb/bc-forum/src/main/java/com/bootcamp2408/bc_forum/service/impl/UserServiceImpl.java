package com.bootcamp2408.bc_forum.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.bootcamp2408.bc_forum.entity.PostEntity;
import com.bootcamp2408.bc_forum.entity.UserEntity;
import com.bootcamp2408.bc_forum.exception.JPHUserError;
import com.bootcamp2408.bc_forum.mapper.UserMapper;
import com.bootcamp2408.bc_forum.model.User;
import com.bootcamp2408.bc_forum.repository.UserRepository;
import com.bootcamp2408.bc_forum.service.UserService;
import com.bootcamp2408.bc_forum.util.Scheme;
import com.bootcamp2408.bc_forum.util.Url;


@Service // Component annotation -> bean
public class UserServiceImpl implements UserService {
  @Autowired
  // inject bean by speicifc bean name
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserMapper UserMapper;

  // ! @Value (inject from yml) is similar to @Autowired (inject from Spring
  // Context)
  // Both of them has to be executed before server start
  @Value("${api.jph.domain}")
  private String jphDomain;

  @Value("${api.jph.endpoints.users}")
  private String usersEndpoint;

  @Override
  public List<User> getUsers() {
    // ! You can use UriComponentBuilder directly
    String url = Url.builder() //
        .scheme(Scheme.HTTPS) //
        .domain(this.jphDomain) //
        .endpoint(this.usersEndpoint) //
        .build() //
        .toUriString();
    System.out.println("url=" + url);
    User[] users;
    try {
      users  = this.restTemplate.getForObject(url, User[].class);
    } catch (RestClientException e) {
      throw new JPHUserError("Json PlaceHolder (users)Exception");
    } 
    return List.of(users);
  }

  @Override
  public List<UserEntity> saveUsers() {
    // Call External JPH service
    List<User> userDTOs = this.getUsers();
    return this.saveUsers(userDTOs);
  }

  private List<UserEntity> saveUsers(List<User> userDTOs) {
    // Mapper: from List<UserDTO> to List<UserEntity>
    List<UserEntity> userEntities = userDTOs.stream() //
        .map(e -> this.UserMapper.map(e)) //
        .collect(Collectors.toList());
    return userRepository.saveAll(userEntities);
  }

  @Override
  public UserEntity updateUser(Long id, UserEntity entity) {
    if (id == null || entity == null || !id.equals(entity.getUser_id())) {
      throw new IllegalArgumentException();
    }
    if (this.userRepository.findById(id).isPresent()) {
      return this.userRepository.save(entity);
    }
    return null; // throw new NotFoundException()


}

 @Override
  public List<UserEntity> saveAll(List<UserEntity> userEntities) {
  return userRepository.saveAll(userEntities);
}
}