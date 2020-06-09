package com.lhzh.solrdemo;

import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
   private IUserService userService;

    //通过当前的方法 把数据 添加到solr
    @GetMapping("addsolr/{name}/{num}")
    public Map<String,Object> addSolr(@PathVariable("name") String name, @PathVariable("num") Integer num){
        //TODO:参数合法校验

        userService.addSolr(name,num);

        return success();
    }

    //搜索，从solr中 通过关键词 搜索数据
    @GetMapping("query/{word}")
    public SolrDocumentList querySolr(@PathVariable("word") String word){
        //TODO:参数合法校验
        return userService.selectSolr(word);

    }

}
