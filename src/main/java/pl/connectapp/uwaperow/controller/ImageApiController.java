package pl.connectapp.uwaperow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.connectapp.uwaperow.model.Image;
import pl.connectapp.uwaperow.model.dto.ImageDTO;
import pl.connectapp.uwaperow.repository.ImageRepository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ImageApiController {

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/getAllFromRepo")
    public ResponseEntity<List<ImageDTO>> getAllProducts() {
        List<Image> images = imageRepository.findAll();

        List<ImageDTO> imageDTOs = images.stream()
                .map(image -> new ImageDTO(image.getImageUrl()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(imageDTOs);
    }
}
