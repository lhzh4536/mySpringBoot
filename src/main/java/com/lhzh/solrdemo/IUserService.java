package com.lhzh.solrdemo;

import org.apache.solr.common.SolrDocumentList;

public interface IUserService {
    void addSolr(String name,Integer num);

    SolrDocumentList selectSolr(String word);
}
