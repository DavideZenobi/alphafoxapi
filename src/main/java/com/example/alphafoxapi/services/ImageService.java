package com.example.alphafoxapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.alphafoxapi.entities.Image;
import com.example.alphafoxapi.repositories.ImageRepository;

@Service
public class ImageService {
    
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> getAllByPlaceId(int id) {
        List<Image> images = imageRepository.findAllByPlaceId(id);
        return images;
    }

}
