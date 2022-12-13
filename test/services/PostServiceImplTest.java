package services;

import data.models.Post;
import dtos.requests.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceImplTest {
    PostService postService;
    CreatePostRequest createPostRequest;
    @BeforeEach
    void setUp(){
        postService = new PostServiceImpl();
        createPostRequest = new CreatePostRequest();
    }
    @Test
    void createPost() {
        createPostRequest.setTitle("Sleep");
        createPostRequest.setBody("I Love sleeping");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAllPost().size());
    }

    @Test
    void updatePost() {

    }

    @Test
    void deletePost() {
    }

    @Test
    void viewPost() {
        createPostRequest.setTitle("Sleep");
        createPostRequest.setBody("I Love sleeping");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAllPost().size());

        Post post = postService.viewPost(1);
        assertEquals("Sleep",post.getTitle());
        assertEquals("I Love sleeping", post.getBody());
        assertNotNull(post.getDate());
    }

    @Test
    void viewAllPost() {
    }
}