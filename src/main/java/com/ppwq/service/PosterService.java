package com.ppwq.service;

import com.ppwq.pojo.Poster;

import java.util.List;

public interface PosterService {

    int insertad(Poster poster, String filename);

    int deletead(int adid);

    List<Poster> getAllad();
}
