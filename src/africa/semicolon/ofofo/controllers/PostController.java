package africa.semicolon.ofofo.controllers;

import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import africa.semicolon.ofofo.services.PostService;
import africa.semicolon.ofofo.services.PostServiceImpl;
import africa.semicolon.ofofo.data.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/post")
    public String createPost(@RequestBody CreatePostRequest createPostRequest){
        postService.createPost(createPostRequest);
        return "Successful";
    }
    @GetMapping("/post/{postId}")
    public Post viewPost(@PathVariable String postId){
        return postService.viewPost(postId);
    }

    @GetMapping("/post")
    public List<Post> viewAllPost(){
        return postService.viewAllPost();
    }
}
