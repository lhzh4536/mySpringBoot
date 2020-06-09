package com.lhzh.solrdemo;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    SolrClient solrClient;
    @Override
    public void addSolr(String name, Integer num) {
        //声明 一个 document对象 用来存储数据
        SolrInputDocument solrInputDocument = new SolrInputDocument();
        //key-value 的形式，向solr中 拼装数据
        solrInputDocument.addField("game_name",name);
        solrInputDocument.addField("game_num",num);
        solrInputDocument.addField("game_id",1000);

        try {
            //将拼装好的数据，提交给 需要存储的core
            solrClient.add("javasm",solrInputDocument);
            //提交core
            solrClient.commit("javasm");
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SolrDocumentList selectSolr(String word) {
        if(word!=null && !word.isEmpty()){
            //创建一个 solr查询对象
            SolrQuery query = new SolrQuery();
            //设置检索条件
            query.setQuery(word);
            try {
                //获得 响应对象
                QueryResponse response = solrClient.query("javasm", query);
                //拿到响应的数据
                SolrDocumentList solrDocumentList = response.getResults();
                return solrDocumentList;
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
