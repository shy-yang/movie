package com.woniu.movie.mapper;

import com.woniu.movie.pojo.ShowSite;
import com.woniu.movie.vo.ShowSiteQueryVo;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.Pattern;
import java.util.List;

public interface ShowSiteMapper {
    int deleteByPrimaryKey(Integer showSiteId);

    int insert(ShowSite record);

    int insertSelective(ShowSite record);

    ShowSite selectByPrimaryKey(Integer showSiteId);

    int updateByPrimaryKeySelective(ShowSite record);

    int updateByPrimaryKey(ShowSite record);

    List<ShowSite> selectAllShowSite(@Param("qv") ShowSiteQueryVo queryVo);

    int showSiteCount();

    int deleteByPrimaryKeys(String[] str);
}