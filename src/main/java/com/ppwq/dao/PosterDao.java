package com.ppwq.dao;

import com.ppwq.pojo.Poster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PosterDao {

    int insertPoster(Poster poster);

    int deletead (int adid);

    int insertadpicname(@Param("adid") int adid, @Param("filename") String filename);

    List<Poster> getAllad();
}
