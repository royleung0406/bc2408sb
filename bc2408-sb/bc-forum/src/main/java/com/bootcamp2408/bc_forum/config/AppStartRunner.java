package com.bootcamp2408.bc_forum.config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp2408.bc_forum.entity.CommentEntity;
import com.bootcamp2408.bc_forum.entity.PostEntity;
import com.bootcamp2408.bc_forum.entity.UserEntity;
import com.bootcamp2408.bc_forum.mapper.CommentMapper;
import com.bootcamp2408.bc_forum.mapper.PostMapper;
import com.bootcamp2408.bc_forum.mapper.UserMapper;
import com.bootcamp2408.bc_forum.model.Comment;
import com.bootcamp2408.bc_forum.model.Post;
import com.bootcamp2408.bc_forum.model.User;
import com.bootcamp2408.bc_forum.service.CommentService;
import com.bootcamp2408.bc_forum.service.PostService;
import com.bootcamp2408.bc_forum.service.UserService;

// @Autowired(required = false)
// private CommandLineRunner runner;
// runner.run();

@Component
public class AppStartRunner implements CommandLineRunner {
  @Autowired
  private PostService postService;

  @Autowired
  private PostMapper postMapper;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private CommentMapper commentMapper;

  @Autowired
  private UserService userService;

  @Autowired
  private CommentService commentService;

  @Override
  public void run(String... args) throws Exception {
    // call jph service
    // insert into database (design tables by entity)
    List<Post> posts = this.postService.getPosts();
    List<Comment> comments = this.commentService.getComments();
    List<User> users = this.userService.getUsers();

    List<UserEntity> userEntities = users.stream()//
        .map(user -> {
          List<PostEntity> postEntities = posts.stream()//
              .filter(post -> post.getUserId().equals(user.getId()))//
              .map(post -> {
                List<CommentEntity> commentEntities = comments.stream()//
                    .filter(comment -> comment.getPostId().equals(post.getId()))//
                    .map(comment -> {
                      CommentEntity commentEntity = commentMapper.map(comment);
                      return commentEntity;
                    })//
                    .collect(Collectors.toList());
                PostEntity postEntity = postMapper.map(post);
                postEntity.setCommentEntity(commentEntities);
                return postEntity;
              })//
              .collect(Collectors.toList());
          UserEntity userEntity = userMapper.map(user);
          userEntity.setPosts(postEntities);
          return userEntity;
        })//
        .collect(Collectors.toList());
    userService.saveAll(userEntities);
  }
}
