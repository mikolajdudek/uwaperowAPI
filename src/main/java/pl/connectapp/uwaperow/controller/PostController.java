package pl.connectapp.uwaperow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
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
    public List<PostDto> getPosts(@RequestParam(required = false) Integer page, Sort.Direction sort){
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return PostDtoMapper.mapToPostDtos(postService.getPosts(pageNumber, sortDirection));
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostsWithComments(@RequestParam(required = false) Integer page,  Sort.Direction sort){
        int pageNumber = page != null &&  page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return postService.getPostsWithComments(pageNumber, sortDirection);
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePosts(@PathVariable long id){
        return postService.getSinglePost(id);
    }


    //------------------------------------
    //POST

    @PostMapping("/posts")
    public Post addPosts(@RequestBody Post post){
        return postService.addPost(post);
    }

    //------------------------------------
    //update
    @PutMapping("/posts")
    public Post editPosts(@RequestBody Post post){
        return postService.editPost(post);
    }

    //------------------------------------
    //delete
    @DeleteMapping("/posts/{id}")
    public void deletePosts(@PathVariable long id){
        postService.deletePost(id);
    }
}
