package com.example.alphafoxapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.alphafoxapi.entities.PlaceLanguage;

public interface PlaceLanguageRepository extends JpaRepository<PlaceLanguage, Integer> {
    
    public List<PlaceLanguage> findByLanguageCode(String languageCode);
}
