package com.bootcamp2408.bc_forum.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PostDTO {
    private Integer id;
    private String title;
    private String body;
    @Builder.Default
    private List<CommentDTO> commentDTO = new ArrayList<>();
}
