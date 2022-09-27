package com.ppwq.service.impl;

import com.ppwq.dao.PosterDao;
import com.ppwq.pojo.Poster;
import com.ppwq.service.PosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosterServiceImpl implements PosterService {
    @Autowired
    private PosterDao posterdao;

    public int insertad(Poster poster, String filename){
        this.posterdao.insertPoster(poster);
        this.posterdao.insertadpicname(poster.getAdid(),filename);
        return 1;
    }

    public int deletead(int adid){return this.posterdao.deletead(adid);}

    public List<Poster> getAllad() {
        return this.posterdao.getAllad();
    }



}
