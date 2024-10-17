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
import com.bootcamp2408.bc_forum.exception.JPHPostError;
import com.bootcamp2408.bc_forum.mapper.PostMapper;
import com.bootcamp2408.bc_forum.model.PostDTO;
import com.bootcamp2408.bc_forum.repository.PostRepository;
import com.bootcamp2408.bc_forum.service.PostService;
import com.bootcamp2408.bc_forum.util.Scheme;
import com.bootcamp2408.bc_forum.util.Url;



@Service // Component annotation -> bean
public class PostServiceImpl implements PostService {
  @Autowired 
  // inject bean by speicifc bean name
  private RestTemplate restTemplate;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private PostMapper PostMapper;

  // ! @Value (inject from yml) is similar to @Autowired (inject from Spring
  // Context)
  // Both of them has to be executed before server start
  @Value("${api.jph.domain}")
  private String jphDomain;

  @Value("${api.jph.endpoints.posts}")
  private String postsEndpoint;

  @Override
  public List<PostDTO> getPosts() {
    // ! You can use UriComponentBuilder directly
    String url = Url.builder() //
        .scheme(Scheme.HTTPS) //
        .domain(this.jphDomain) //
        .endpoint(this.postsEndpoint) //
        .build() //
        .toUriString();
    System.out.println("url=" + url);
    PostDTO[] posts;
    try {
      posts  = this.restTemplate.getForObject(url, PostDTO[].class);
    } catch (RestClientException e) {
      throw new JPHPostError("Json PlaceHolder (posts)Exception");
    } 
    return List.of(posts);
  }

  @Override
  public List<PostEntity> savePosts() {
    // Call External JPH service
    List<PostDTO> post = this.getPosts();
    return this.savePosts(post);
  }

  private List<PostEntity> savePosts(List<PostDTO> postDTOs) {
    // Mapper: from List<UserDTO> to List<UserEntity>
    List<PostEntity> postEntities = postDTOs.stream() //
        .map(e -> this.PostMapper.map(e)) //
        .collect(Collectors.toList());
    return postRepository.saveAll(postEntities);
  }

  @Override
  public PostEntity updatePost(Long id, PostEntity entity) {
    if (id == null || entity == null || !id.equals(entity.getId())) {
      throw new IllegalArgumentException();
    }
    if (this.postRepository.findById(id).isPresent()) {
      return this.postRepository.save(entity);
    }
    return null; // throw new NotFoundException()


}
}