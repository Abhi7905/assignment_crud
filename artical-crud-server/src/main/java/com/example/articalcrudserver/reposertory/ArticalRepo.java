package com.example.articalcrudserver.reposertory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.articalcrudserver.entity.Artical;

@Repository
public interface ArticalRepo extends JpaRepository<Artical,Long>  {
    
}
