package com.project.FeastFreedom.controller;


import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.project.FeastFreedom.config.AmazonS3BucketService;
import com.project.FeastFreedom.model.Kitchen;
import com.project.FeastFreedom.services.KitchenService;

@RequestMapping("/api")
@Controller
public class S3BucketController {

    private AmazonS3BucketService amazonS3BucketService;
    
    @Autowired
    private KitchenService kitchenService;

    S3BucketController(AmazonS3BucketService amazonS3BucketService) {
        this.amazonS3BucketService = amazonS3BucketService;
    }

    @PostMapping("/kitchen/{email}/uploadFile")
    public ResponseEntity<String> uploadFile(@PathVariable String email, @RequestPart(value = "file") MultipartFile file) {
    	String response = this.amazonS3BucketService.uploadFile(file);
    	
    	kitchenService.setKitchenImage(email, response);
    	
    	return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @PostMapping("/kitchen/deleteFile")
    public String deleteFile(@RequestBody String fileURL) {
        return this.amazonS3BucketService.deleteFileFromBucket(fileURL);
    }
}