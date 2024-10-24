package com.bootcamp2408.bc_forum.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.bootcamp2408.bc_forum.entity.CommentEntity;
import com.bootcamp2408.bc_forum.exception.JPHCommentError;
import com.bootcamp2408.bc_forum.mapper.CommentMapper;
import com.bootcamp2408.bc_forum.model.Comment;
import com.bootcamp2408.bc_forum.repository.CommentRepository;
import com.bootcamp2408.bc_forum.service.CommentService;
import com.bootcamp2408.bc_forum.util.Scheme;
import com.bootcamp2408.bc_forum.util.Url;


@Service // Component annotation -> bean
public class CommentServiceimpl implements CommentService {
  @Autowired
  // inject bean by speicifc bean name
  private RestTemplate restTemplate;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private CommentMapper commentMapper;

  // ! @Value (inject from yml) is similar to @Autowired (inject from Spring
  // Context)
  // Both of them has to be executed before server start
  @Value("${api.jph.domain}")
  private String jphDomain;

  @Value("${api.jph.endpoints.comments}")
  private String commentsEndpoint;

  @Override
  public List<Comment> getComments() {
    // ! You can use UriComponentBuilder directly
    String url = Url.builder() //
        .scheme(Scheme.HTTPS) //
        .domain(this.jphDomain) //
        .endpoint(this.commentsEndpoint) //
        .build() //
        .toUriString();
    System.out.println("url=" + url);
    Comment[] comments;
    try {
      comments = this.restTemplate.getForObject(url, Comment[].class);
    } catch (RestClientException e) {
      throw new JPHCommentError("Json PlaceHolder (comments)Exception");
    }
    return List.of(comments);
  }

  @Override
  public List<CommentEntity> saveComments() {
    // Call External JPH service
    List<Comment> commentDTOs = this.getComments();
    return this.saveComments(commentDTOs);
  }

  
  private List<CommentEntity> saveComments(List<Comment> commentDTOs) {
    // Mapper: from List<UserDTO> to List<UserEntity>
    List<CommentEntity> commentEntities = commentDTOs.stream()
    .map(e-> commentMapper.map(e))//
    .collect(Collectors.toList());
    
    return commentRepository.saveAll(commentEntities);
  }



  @Override
  public CommentEntity updateComment(Long id, CommentEntity entity) {
    if (id == null || entity == null || !id.equals(entity.getComment_id())) {
      throw new IllegalArgumentException();
    }
    if (this.commentRepository.findById(id).isPresent()) {
      return this.commentRepository.save(entity);
    }
    return null; // throw new NotFoundException()


  }
}
