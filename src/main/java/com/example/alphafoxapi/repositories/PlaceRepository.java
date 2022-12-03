package com.example.alphafoxapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.alphafoxapi.entities.Place;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
    
    public List<Place> findAll();
    public List<Place> findAllByOrderByCodeAsc();
    public Place getReferenceById(Integer id);
}
