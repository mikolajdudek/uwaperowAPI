package pl.connectapp.uwaperow.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.connectapp.uwaperow.model.Image;
import pl.connectapp.uwaperow.repository.ImageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public void addImage(String imageUrl) {
        Image imageEntity = new Image();
        imageEntity.setImageUrl(imageUrl);
        imageRepository.save(imageEntity);
    }

}

