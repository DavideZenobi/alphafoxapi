package com.example.alphafoxapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.alphafoxapi.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    
    public List<Image> findAll();

    @Query("SELECT i FROM Image i WHERE i.placeId = :placeId ")
    public List<Image> findAllByPlaceId(Integer placeId);
}
