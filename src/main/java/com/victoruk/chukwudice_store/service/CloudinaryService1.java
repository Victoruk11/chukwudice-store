package com.victoruk.chukwudice_store.service;



import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class CloudinaryService1 {

        private final Cloudinary cloudinary;

        // Constructor to initialize Cloudinary with values from application properties or environment variables
        public CloudinaryService1(@Value("${cloudinary.cloud_name}") String cloudName,
                                 @Value("${cloudinary.api_key}") String apiKey,
                                 @Value("${cloudinary.api_secret}") String apiSecret) {
            Map<String, String> valuesMap = new HashMap<>();
            valuesMap.put("cloud_name", cloudName);
            valuesMap.put("api_key", apiKey);
            valuesMap.put("api_secret", apiSecret);
            this.cloudinary = new Cloudinary(valuesMap);
        }

        // Method to upload a file to Cloudinary
        public Map<String, Object> upload(MultipartFile multipartFile) throws Exception {
            File file = convert(multipartFile);

            // Upload file to Cloudinary
            Map<String, Object> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

            // Delete the temporary file after upload
            if (!Files.deleteIfExists(file.toPath())) {
                throw new IOException("Failed to delete temporary file: " + file.getAbsolutePath());
            }

            return result;
        }

        // Private method to convert MultipartFile to a File object
        private File convert(MultipartFile multipartFile) throws Exception {
            File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            try (FileOutputStream fo = new FileOutputStream(file)) {
                fo.write(multipartFile.getBytes());
            }
            return file;
        }

}
