package com.bootcamp.demo.demo_sb_restapi.controller.impl;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_sb_restapi.dto.GovCatDTO;
import com.bootcamp.demo.demo_sb_restapi.mapper.GovMapper;
import com.bootcamp.demo.demo_sb_restapi.model.Cat;
import com.bootcamp.demo.demo_sb_restapi.model.Color;

@ResponseBody
@Controller
public class GovController {

    @GetMapping(value = "/govcats")
  public List<GovCatDTO> getCats() {
    List<Cat> cats = List.of(new Cat("Vincent", 13, Color.RED, 13.0),
        new Cat("Peter", 10, Color.BLUE, 8));
    return GovMapper.govMap(cats);
  
}
}
