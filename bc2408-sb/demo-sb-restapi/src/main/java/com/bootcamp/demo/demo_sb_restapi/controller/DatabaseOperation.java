package com.bootcamp.demo.demo_sb_restapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface DatabaseOperation {

  //1.
  @PostMapping("/integers/{index}/{value}")
  public int put(@PathVariable int index, @PathVariable int value) ;

  // 2. int get(int index)
  @GetMapping("/integers/{index}")
  public int get(@PathVariable int index);

  // 3.
  @GetMapping("/integers")
  public int get2(@RequestParam (value = "idx") int idx);

  // 4. List<Integer> getAll()
  @GetMapping("/integers/getall")
  public List<Integer> getAll();
  
  

}
  

  

