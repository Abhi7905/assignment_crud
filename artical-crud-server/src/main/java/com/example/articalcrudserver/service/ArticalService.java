package com.example.articalcrudserver.service;

import java.util.List;

import com.example.articalcrudserver.dto.ArticalDto;
import com.example.articalcrudserver.entity.Artical;

public interface ArticalService {


    ArticalDto addArtical(ArticalDto articalDto);
    List<ArticalDto> getAllArtical();
    ArticalDto getArticalById(Long id);
    Artical updateArtical(ArticalDto articalDto);
    public void  deleteArtical(Long aid);
}
