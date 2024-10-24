package com.bootcamp2408.bc_forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
// JPA library/ Framework
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Posts")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity implements Serializable {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer post_id;
    private String title;
    private String body;
    @Builder.Default
    @Setter
    private List<CommentEntity> commentEntity = new ArrayList<>();

    @Builder.Default
    @OneToMany (mappedBy = "post", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private List <CommentEntity> comments = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "user_id" , nullable = false)
  private UserEntity user;
    }
