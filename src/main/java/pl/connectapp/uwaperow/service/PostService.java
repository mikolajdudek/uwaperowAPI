package pl.connectapp.uwaperow.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.connectapp.uwaperow.model.Comment;
import pl.connectapp.uwaperow.model.Post;
import pl.connectapp.uwaperow.repository.CommentRepository;
import pl.connectapp.uwaperow.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    public static final int PageSIZE = 20;
    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    //postronnicowane posty
    public List<Post> getPosts(int page, Sort.Direction sort){
        return postRepository.findAllPost(
                PageRequest.of(page, PageSIZE,
                        Sort.by(sort, "id")));
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id).orElseThrow();
    }

    public List<Post> getPostsWithComments(int page, Sort.Direction sort) {
        List<Post> allPost = postRepository.findAllPost(PageRequest.of(page, PageSIZE, Sort.by(sort, "id")));
        List<Long> ids = allPost.stream()
                .map(Post::getId).collect(Collectors.toList());
        List<Comment> comments = commentRepository.findAllByPostIdIn(ids);
        allPost.forEach(post -> post.setComment(exctractComments(comments,post.getId())));
    return allPost;
    }

    private List<Comment> exctractComments(List<Comment> comments, Long id) {
    return comments.stream()
            .filter(comment -> comment.getPostId() == id).collect(Collectors.toList());
    }
}
