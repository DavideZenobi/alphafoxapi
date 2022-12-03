package com.example.alphafoxapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.alphafoxapi.dto.PlaceLanguageOutputDTO;
import com.example.alphafoxapi.dto.PlaceOutputDTO;
import com.example.alphafoxapi.entities.Place;
import com.example.alphafoxapi.entities.PlaceLanguage;
import com.example.alphafoxapi.services.ConverterService;
import com.example.alphafoxapi.services.PlaceService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(path = "/api/place")
public class PlaceController {
    
    private final PlaceService placeService;
    private final ConverterService converterService;

    public PlaceController(PlaceService placeService, ConverterService converterService) {
        
        this.placeService = placeService;
        this.converterService = converterService;
    }

    @GetMapping(path = "/")
    public List<PlaceOutputDTO> getAll() {
        List<Place> places = placeService.findAllSorted();
        List<PlaceOutputDTO> placesDTO = new ArrayList<PlaceOutputDTO>();

        for (Place place : places) {
            placesDTO.add(converterService.fromPlaceToPlaceOutputDTO(place));
        }

        return placesDTO;
    }

    @GetMapping(path = "/lang/{languageCode}")
    public List<PlaceLanguageOutputDTO> getAllByLanguageCode(@PathVariable String languageCode) {
        List<PlaceLanguage> places = placeService.findByLanguageCode(languageCode);
        List<PlaceLanguageOutputDTO> placesDTO = new ArrayList<PlaceLanguageOutputDTO>();

        for (PlaceLanguage place : places) {
            placesDTO.add(converterService.fromPlaceLanguageToPlaceLanguageOutputDTO(place));
        }

        return placesDTO;
    }

    @GetMapping(path = "/{id}")
    public PlaceOutputDTO getPlace(@PathVariable int id) {
        Place place = placeService.getOneById(id);
        PlaceOutputDTO placeOutputDTO = converterService.fromPlaceToPlaceOutputDTO(place);
        return placeOutputDTO;
    }
}
