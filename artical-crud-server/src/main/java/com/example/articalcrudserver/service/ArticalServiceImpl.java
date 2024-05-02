package com.example.articalcrudserver.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.articalcrudserver.dto.ArticalDto;
import com.example.articalcrudserver.entity.Artical;
import com.example.articalcrudserver.reposertory.ArticalRepo;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ArticalServiceImpl implements ArticalService {

    
    private final ArticalRepo articalRepo;

    @Override
    public ArticalDto addArtical(ArticalDto articalDto){
        Artical artical =new Artical();
        artical.setId(articalDto.getId());
        artical.setTitle(articalDto.getTitle());
        artical.setAuther(articalDto.getAuther());
        artical.setArticalDate(articalDto.getArticalDate());
        artical.setAccesCatagory(articalDto.getAccesCatagory());
        artical.setExpiryDate(articalDto.getExpiryDate());

        try {
            artical.setImg(articalDto.getImg().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            artical.setFeaturedImg(articalDto.getFeaturedImg().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        
        return articalRepo.save(artical).getDto();
    }

    @Override
    public List<ArticalDto> getAllArtical() {
        List<Artical> articals = articalRepo.findAll();
        return articals.stream().map(Artical::getDto).collect(Collectors.toList());
    }

    @Override
    
    public ArticalDto getArticalById(Long id) {
        Optional<Artical> optionalArtical = articalRepo.findById(id);
        Artical artical = optionalArtical.orElseThrow(() -> new RuntimeException("Artical not found with id: " + id));
        return artical.getDto();
    }

    @Override
    public Artical updateArtical(ArticalDto articalDto){
        Artical artical=articalRepo.findById(articalDto.getId()).orElseThrow();
        artical.setId(articalDto.getId());
        artical.setTitle(articalDto.getTitle());
        artical.setAuther(articalDto.getAuther());   
        artical.setArticalDate(articalDto.getArticalDate());
        artical.setExpiryDate(articalDto.getExpiryDate());
        artical.setDescription(articalDto.getDescription());
        try {
            artical.setImg(articalDto.getImg().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            artical.setFeaturedImg(articalDto.getFeaturedImg().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return articalRepo.save(artical);
    }

    @Override
    public void deleteArtical(Long aid) {
       articalRepo.deleteById(aid);
    }
   
}
