package pl.connectapp.uwaperow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.connectapp.uwaperow.controller.dto.PostDto;
import pl.connectapp.uwaperow.model.Post;
import pl.connectapp.uwaperow.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

import static pl.connectapp.uwaperow.controller.PostDtoMapper.mapToPostDtos;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestParam(required = false) int page){
        int pageNumber = page >= 0 ? page : 0;
        return PostDtoMapper.mapToPostDtos(postService.getPosts(pageNumber));
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostsWithComments(@RequestParam(required = false) int page){
        int pageNumber = page >= 0 ? page : 0;
        return postService.getPostsWithComments(pageNumber);
    }


    @GetMapping("/posts/{id}")
    public Post getSinglePosts(@PathVariable long id){
        return postService.getSinglePost(id);
    }

}
