package com.woniu.movie.service;

import com.woniu.movie.pojo.ShowSite;
import com.woniu.movie.vo.ShowSiteQueryVo;

import java.util.List;

public interface IShowSiteService {


    int removeShowSiteByShowSiteId(Integer showSiteId);

    int add(ShowSite record);

    int addSelective(ShowSite record);

    ShowSite findShowSiteByShowSiteId(Integer showSiteId);

    int modifyShowSiteByShowSiteIdSelective(ShowSite record);

    int modifyShowSiteByShowSiteId(ShowSite record);

    List<ShowSite> findAllShowSite(ShowSiteQueryVo queryVo);

    int showSiteCount();
}
