package com.example.alphafoxapi.controllers;

import com.example.alphafoxapi.services.GoogleStorageService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://wowguessrweb.herokuapp.com",
        "https://wowguessrweb.herokuapp.com",
        "http://www.wowguessr.com",
        "https://www.wowguessr.com"
})
@RequestMapping(path = "/api/static/images/places")
public class StaticImagesController {

    private final GoogleStorageService googleCloudService;

    public StaticImagesController(GoogleStorageService googleCloudService) {
        this.googleCloudService = googleCloudService;
    }

    @GetMapping(path = "/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable final String imageName) throws IOException {
        final GoogleStorageService.GetImageResult result = googleCloudService.getImage(imageName);

        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(24, TimeUnit.HOURS))
                .contentLength(result.file().length())
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(new FileInputStream(result.file())));
    }

}
