package com.example.alphafoxapi.services;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GoogleStorageService {

    private static final Path TMP_PATH = Path.of("alphafox");

    private final Storage googleCloudStorage;

    private final Map<String, GetImageResult> tmpImageFiles;

    public GoogleStorageService(Storage googleCloudStorage) {
        this.googleCloudStorage = googleCloudStorage;
        this.tmpImageFiles = new ConcurrentHashMap<>();
    }

    public GetImageResult getImage(final String imageName) throws IOException {
        if (tmpImageFiles.containsKey(imageName)) {
            return tmpImageFiles.get(imageName);
        }

        final Bucket alphafoxBucket = googleCloudStorage.get("alphafox");
        final Blob image = alphafoxBucket.get(imageName);

        if (!Files.exists(TMP_PATH)) {
            Files.createDirectory(TMP_PATH);
        }

        final Path imagePath = Files.createTempFile(TMP_PATH, null, image.getName());
        image.downloadTo(imagePath);

        final File imageFile = imagePath.toFile();
        final GetImageResult result = new GetImageResult(imageFile);

        tmpImageFiles.put(imageName, result);

        return result;
    }

    public record GetImageResult(File file) { }

}
