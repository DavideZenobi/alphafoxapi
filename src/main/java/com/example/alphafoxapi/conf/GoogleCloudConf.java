package com.example.alphafoxapi.conf;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class GoogleCloudConf {

    private static Credentials getCredentials(final String credentialsJsonString) throws IOException {
        InputStream in = new ByteArrayInputStream(credentialsJsonString.getBytes());
        return GoogleCredentials.fromStream(in);
    }

    @Bean
    public Storage googleCloudStorage(final AlphafoxConfig alphafoxConfig) throws IOException {
        final Credentials credentials = getCredentials(alphafoxConfig.getGoogle().getCredentials());

        return StorageOptions.newBuilder()
                .setCredentials(credentials)
                .setProjectId("alpine-gasket-370515")
                .build()
                .getService();
    }

}
