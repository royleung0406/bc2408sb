package com.bootcamp2408.bc_forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
// JPA library/ Framework
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Posts")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity implements Serializable {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer id;
    private String title;
    private String body;
    @Builder.Default
    private List<CommentEntity> commentEntity = new ArrayList<>();
    }
