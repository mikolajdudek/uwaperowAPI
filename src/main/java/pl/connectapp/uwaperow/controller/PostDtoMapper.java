package pl.connectapp.uwaperow.controller;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.mapstruct.Mapper;
import pl.connectapp.uwaperow.controller.dto.PostDto;
import pl.connectapp.uwaperow.model.Post;

import java.net.http.HttpClient;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
@Builder

public class PostDtoMapper {

    private PostDtoMapper() {
    }

    public static List<PostDto> mapToPostDtos(List<Post> posts) {
        return posts.stream()
                .map(post -> mapToPostDto(post))
                .collect(Collectors.toList());
    }

    private static PostDto mapToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .created(post.getCreated())
                .build();
    }
}