package pl.connectapp.uwaperow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.connectapp.uwaperow.model.Image;
import pl.connectapp.uwaperow.model.dto.ImageDTO;
import pl.connectapp.uwaperow.repository.ImageRepository;


import java.util.List;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ImageApiController {

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/getImagesByKeyword")
    public ResponseEntity<List<ImageDTO>> getImagesByKeyword(@RequestParam("keyword") String keyword) {
        List<Image> images = imageRepository.findAll();

        List<ImageDTO> imageDTOs = images.stream()
                .filter(image -> image.getImageUrl().contains(keyword)) // Filtrowanie po zawartości URL
                .map(image -> new ImageDTO(image.getImageUrl()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(imageDTOs);
    }
}


