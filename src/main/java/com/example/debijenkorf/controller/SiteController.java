package com.example.debijenkorf.controller;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.example.debijenkorf.exception.InvalidFileFormatException;
import com.example.debijenkorf.exception.InvalidFileSizeException;
import com.example.debijenkorf.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SiteController {
    @Autowired
    private UploadService uploadService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/upload")
    @ResponseBody
    public  Map<String, String> upload(@RequestParam("file") MultipartFile file) {

        Map<String, String> response = new HashMap<>();

        boolean isOperationSuccess = false;
        String message = "";
        String imageUrl = "";

        try{
            imageUrl = uploadService.uploadImage(file);
            message = "Image successfully uploaded.";
            isOperationSuccess = true;
        }catch (IOException e){
            message = "HTTP 404 NOT FOUND";
            logger.error("HTTP 404 NOT FOUND");
            e.printStackTrace();
        }catch (InvalidFileFormatException e){
            message = "HTTP 404 NOT FOUND";
            e.printStackTrace();
        }catch (InvalidFileSizeException e){

            logger.warn("HTTP 404 NOT FOUND");
            e.printStackTrace();
        }catch (AmazonServiceException e){
            message = "HTTP 404 NOT FOUND";
            logger.warn("HTTP 404 NOT FOUND");
            e.printStackTrace();
        }catch (SdkClientException e){
            message = "HTTP 404 NOT FOUND";
            e.printStackTrace();
        }


        response.put("success", String.valueOf(isOperationSuccess));
        response.put("message", message);
        response.put("url", imageUrl);

        return response;
    }
}
