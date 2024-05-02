package com.example.articalcrudserver.entity;
import com.example.articalcrudserver.dto.ArticalDto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "contacts")
public class Artical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional=false)
    private Long id;
    private String title;
    private String auther;
    private String publicUrl;
    private String articalDate;
    private String accesCatagory;
    private String expiryDate;
    private String description;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] featuredImg;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;
    // private MultipartFile image;
    
    

    public ArticalDto getDto() {
        ArticalDto articalDto=new ArticalDto();
        articalDto.setId(id);
        articalDto.setTitle(title);
        articalDto.setAuther(auther);
        articalDto.setPublicUrl(publicUrl);
        articalDto.setArticalDate(articalDate);
        articalDto.setAccesCatagory(accesCatagory);
        articalDto.setExpiryDate(expiryDate);
        articalDto.setFeaturedImgByte(img);
        articalDto.setImgByte(featuredImg);
        return articalDto;
    }
}
