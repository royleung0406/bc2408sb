package com.bootcamp.demo.demo_sb_restapi.controller.impl;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_sb_restapi.controller.DatabaseOperation;
import com.bootcamp.demo.demo_sb_restapi.model.Database;



@Controller
@ResponseBody
public class DatabaseController implements DatabaseOperation{
  // APIs
  // 1. int put(int index, int integer)
  public int put(@PathVariable int index, @PathVariable int value) {
    if (index < 0 || index > Database.integers.length - 1)
      return -1;
    Database.integers[index] = value;
    return value;
  }

  // 2. int get(int index)
 public int get(@PathVariable int index) {
    return Database.integers[index];
  }


public int get2(@RequestParam ( value = "idx") int idx){
  return Database.integers[idx];
}

  // 3. List<Integer> getAll()
  public List<Integer> getAll() {
    return Arrays.stream(Database.integers) //
        .boxed() //
        .collect(Collectors.toList());
  }

}