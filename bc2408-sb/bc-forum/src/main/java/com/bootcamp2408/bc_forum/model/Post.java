package com.bootcamp2408.bc_forum.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.bootcamp2408.bc_forum.model.UserPostCommentDTO.CommentDTO;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Post {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
    @Builder.Default
    private List<CommentDTO> commentDTO = new ArrayList<>();
}
