package com.example.articalcrudserver.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.articalcrudserver.dto.ArticalDto;
import com.example.articalcrudserver.service.ArticalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
@CrossOrigin
public class ArticalController {

    private final ArticalService articalService;
    
    @RequestMapping(value = "/add_artical", method=RequestMethod.POST)
    public ResponseEntity<ArticalDto> addArtical(@ModelAttribute ArticalDto articalDto) {

        ArticalDto articalDto2 =articalService.addArtical(articalDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(articalDto2);
        
    }
    @RequestMapping(value = "/get_artical", method=RequestMethod.GET)
    public ResponseEntity<ArticalDto> getArticalById(Long id) {
        ArticalDto articalDto = articalService.getArticalById(id);
       
        return ResponseEntity.status(HttpStatus.CREATED).body(articalDto);
        
    }

    @RequestMapping(value = "/get_artical", method=RequestMethod.GET)
    public ResponseEntity<List<ArticalDto>> getAllArtical() {
        List<ArticalDto> articalDto = articalService.getAllArtical();
       
        return ResponseEntity.status(HttpStatus.CREATED).body(articalDto);
        
    }

    @RequestMapping(value = "/delete_artical", method=RequestMethod.DELETE)
    public BodyBuilder deleteArticalById(Long id) {
        articalService.deleteArtical(id);
        return ResponseEntity.status(HttpStatus.CREATED);   
    }

    @RequestMapping(value = "/add_artical", method=RequestMethod.POST)
    public ResponseEntity<ArticalDto> updateArtical(@ModelAttribute ArticalDto articalDto) {

        ArticalDto articalDto2 = articalService.updateArtical(articalDto).getDto();
        return ResponseEntity.status(HttpStatus.CREATED).body(articalDto2);
        
    }

}
