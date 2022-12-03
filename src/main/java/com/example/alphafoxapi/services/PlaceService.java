package com.example.alphafoxapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.alphafoxapi.entities.Place;
import com.example.alphafoxapi.entities.PlaceLanguage;
import com.example.alphafoxapi.repositories.PlaceLanguageRepository;
import com.example.alphafoxapi.repositories.PlaceRepository;

@Service
public class PlaceService {
    
    private PlaceRepository placeRepository;
    private PlaceLanguageRepository placeLanguageRepository;

    public PlaceService(PlaceRepository placeRepository, PlaceLanguageRepository placeLanguageRepository) {
        this.placeRepository = placeRepository;
        this.placeLanguageRepository = placeLanguageRepository;
    }

    public List<Place> findAll() {
        List<Place> places = placeRepository.findAll();
        return places;
    }

    public List<Place> findAllSorted() {
        List<Place> places = placeRepository.findAllByOrderByCodeAsc();
        return places;
    }

    public List<PlaceLanguage> findByLanguageCode(String languageCode) {
        List<PlaceLanguage> places = placeLanguageRepository.findByLanguageCode(languageCode);
        return places;
    }

    public Place getOneById(int id) {
        Place place = placeRepository.getReferenceById(id);
        return place;
    }
}
