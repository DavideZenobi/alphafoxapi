package com.example.alphafoxapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.alphafoxapi.entities.Image;

@Service
public class AdvancedService {
    
    private final ImageService imageService;

    public AdvancedService(ImageService imageService) {
        this.imageService = imageService;
    }

    public List<Image> getFilteredImagesByPlaceId(int placeId) {
        List<Image> filteredImages = new ArrayList<>();
        List<Image> images = imageService.getAllByPlaceId(placeId);
        int tiers = 5;
        for (int i = 0; i < tiers; i++) {
            int j = i;
            List<Image> imagesByTier = images.stream().filter(image -> image.getTier() == j + 1).collect(Collectors.toList());
            Image imageSelected = selectRandomImage(imagesByTier);
            filteredImages.add(imageSelected);
        }

        return filteredImages;
    }


    public Image selectRandomImage(List<Image> images) {
        Random random = new Random();
        Image image = images.get(random.nextInt(images.size()));
        return image;
    }


}
