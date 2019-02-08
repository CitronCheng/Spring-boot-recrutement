package com.bloom.recrutement.controller;


import com.bloom.recrutement.service.FileSystemStorageService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;


@Component
@Path("uploads")
public class FileUpload {
    @Autowired
    FileSystemStorageService fileSystemStorageService;

    Logger logger = LoggerFactory.getLogger(FileUpload.class);



//    @CrossOrigin(origins = {"http://localhost:8088"})
//    @PostMapping(value = "/uploads/lettre",consumes = "multipart/form-data")
//    public void HandlelettreUpload(@RequestParam("lettre") MultipartFile lettre){
//        fileSystemStorageService.store(lettre,"lettres");
//    }
    @GET
    @Path("/test")
    public String test(){
        return "this is a rest test";
    }

    @POST
    @Path("/cv")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void HandleCVUpload(
            @FormDataParam("cv") InputStream uploadedInputStream,
            @FormDataParam("cv") FormDataContentDisposition fileDetail
    ){
        fileSystemStorageService.store(uploadedInputStream,"cvs",fileDetail);
    }
}
