package com.example.alphafoxapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.alphafoxapi.dto.ImageOutputDTO;
import com.example.alphafoxapi.entities.Image;
import com.example.alphafoxapi.services.AdvancedService;
import com.example.alphafoxapi.services.ConverterService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(path = "/api/image")
public class ImageController {
    
    private final AdvancedService advancedService;
    private final ConverterService converterService;

    public ImageController(AdvancedService advancedService, ConverterService converterService) {
        this.advancedService = advancedService;
        this.converterService = converterService;
    }

    @GetMapping(path = "/{placeId}")
    public List<ImageOutputDTO> getAllByPlaceId(@PathVariable int placeId) {
        List<Image> images = advancedService.getFilteredImagesByPlaceId(placeId);
        List<ImageOutputDTO> imagesDTO = new ArrayList<>();

        for (Image image : images) {
            imagesDTO.add(converterService.fromImageToImageOutputDTO(image));
        }

        return imagesDTO;
    }
}
