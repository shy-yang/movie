package com.woniu.movie.service.impl;

import com.woniu.movie.vo.ShowSiteQueryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.woniu.movie.mapper.ShowSiteMapper;
import com.woniu.movie.pojo.ShowSite;
import com.woniu.movie.service.IShowSiteService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShowSiteServiceImpl implements IShowSiteService {

    @Resource
    private ShowSiteMapper showSiteMapper;

    @Override
    public int removeShowSiteByShowSiteId(Integer showSiteId) {
        return showSiteMapper.deleteByPrimaryKey(showSiteId);
    }

    @Override
    public int add(ShowSite record) {
        return showSiteMapper.insert(record);
    }

    @Override
    public int addSelective(ShowSite record) {
        return showSiteMapper.insertSelective(record);
    }

    @Override
    public ShowSite findShowSiteByShowSiteId(Integer showSiteId) {
        return showSiteMapper.selectByPrimaryKey(showSiteId);
    }

    @Override
    public int modifyShowSiteByShowSiteIdSelective(ShowSite record) {
        return showSiteMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int modifyShowSiteByShowSiteId(ShowSite record) {
        return showSiteMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ShowSite> findAllShowSite(ShowSiteQueryVo queryVo) {
        return showSiteMapper.selectAllShowSite(queryVo);
    }

    @Override
    public int showSiteCount() {
        return showSiteMapper.showSiteCount();
    }

    @Override
    public int removeShowSiteByShowSiteIds(String[] str) {
        return showSiteMapper.deleteByPrimaryKeys(str);
    }

}
