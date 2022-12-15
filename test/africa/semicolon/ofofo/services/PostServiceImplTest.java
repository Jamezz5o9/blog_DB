package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import africa.semicolon.ofofo.data.models.Comment;

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

        Post post = postService.viewPost("1");
        assertEquals("Sleep",post.getTitle());
        assertEquals("I Love sleeping", post.getBody());
        assertNotNull(post.getDate());
    }

    @Test
    void viewAllPost() {
    }

    @Test
    public void addCommentTest(){


        createPostRequest.setBody("I didn't enjoy yesterday mactch");
        createPostRequest.setTitle("Football match");
        postService.createPost(createPostRequest);
        Comment comment = new Comment();
        comment.setComment("I don't like your post");
        postService.addComment("1", comment);

        Post savedPost = postService.viewPost("1");
        assertEquals(1, savedPost.getComments().size());
        assertEquals("I don't like your post", savedPost.getComments().get(0).getComment());
    }
}