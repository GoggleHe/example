package org.example.springboot.integration.mybatis.controller;

import org.example.springboot.integration.mybatis.mapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("my")
public class MyController {

    private final MyMapper myMapper;

    public MyController(@Autowired MyMapper myMapper) {
        this.myMapper = myMapper;
    }

    @GetMapping("select")
    @ResponseBody
    public List<Integer> select() {
        List<Integer> integer = null;
        try {
            integer = myMapper.selectOne();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integer;
    }

    @GetMapping("updateMany")
    @ResponseBody
    public Integer updateMany(){
        return myMapper.updateMulti(1, "啊", 2, "喔");
    }
}
