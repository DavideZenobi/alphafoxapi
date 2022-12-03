package com.example.alphafoxapi.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "alphafox")
public class AlphafoxConfig {

    private GoogleConfig google;

    public GoogleConfig getGoogle() {
        return google;
    }

    public void setGoogle(GoogleConfig google) {
        this.google = google;
    }

    // ------------------------------------------------------------------

    static class GoogleConfig {

        private String credentials;

        public String getCredentials() {
            return credentials;
        }

        public void setCredentials(String credentials) {
            this.credentials = credentials;
        }

    }

}
