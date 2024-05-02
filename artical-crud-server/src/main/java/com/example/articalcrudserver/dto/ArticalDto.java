package com.example.articalcrudserver.dto;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class ArticalDto {

    private Long id;
    private String title;
    private String auther;
    private String publicUrl;
    private String articalDate;
    private String accesCatagory;
    private String expiryDate;
    private String description;
    private byte[] imgByte;
    private byte[] featuredImgByte;
    private MultipartFile featuredImg;
    private MultipartFile img ;
    
}
