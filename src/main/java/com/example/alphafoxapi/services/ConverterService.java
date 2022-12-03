package com.example.alphafoxapi.services;

import org.springframework.stereotype.Service;

import com.example.alphafoxapi.dto.ImageOutputDTO;
import com.example.alphafoxapi.dto.PlaceLanguageOutputDTO;
import com.example.alphafoxapi.dto.PlaceOutputDTO;
import com.example.alphafoxapi.entities.Image;
import com.example.alphafoxapi.entities.Place;
import com.example.alphafoxapi.entities.PlaceLanguage;

@Service
public class ConverterService {
    
    public PlaceOutputDTO fromPlaceToPlaceOutputDTO(Place place) {
        PlaceOutputDTO placeOutputDTO = new PlaceOutputDTO();
        placeOutputDTO.setId(place.getId());
        placeOutputDTO.setName(place.getName());
        placeOutputDTO.setCode(Integer.valueOf(place.getId()).hashCode());
        return placeOutputDTO;
    }

    public ImageOutputDTO fromImageToImageOutputDTO(Image image) {
        ImageOutputDTO imageOutputDTO = new ImageOutputDTO();
        imageOutputDTO.setFilename(image.getFilename());
        imageOutputDTO.setTier(image.getTier());
        return imageOutputDTO;
    }

    public PlaceLanguageOutputDTO fromPlaceLanguageToPlaceLanguageOutputDTO(PlaceLanguage placeLanguage) {
        PlaceLanguageOutputDTO placeLanguageOutputDTO = new PlaceLanguageOutputDTO();
        placeLanguageOutputDTO.setName(placeLanguage.getName());
        return placeLanguageOutputDTO;
    }

}
