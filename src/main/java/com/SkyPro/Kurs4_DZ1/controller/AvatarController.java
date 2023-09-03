package com.SkyPro.Kurs4_DZ1.controller;

import com.SkyPro.Kurs4_DZ1.service.AvatarService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/avatar")
public class AvatarController {
    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Long> save (@RequestParam Long studentId,
                                      @RequestBody MultipartFile multipartFile)
    {
        try {
            Long avatarId = avatarService.save(studentId,multipartFile);
            return ResponseEntity.ok(avatarId);
                            }
    catch (IOException e){
           e.printStackTrace();
            return  ResponseEntity.badRequest().build();

    }
    }
}
