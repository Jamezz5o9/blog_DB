package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.repositories.CommentRepository;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceImplTest {
    CommentService commentService;
    PostService postService;
    @BeforeEach
    void setUp() {
        commentService = new CommentServiceImpl();
        postService = new PostServiceImpl();
    }

    @Test
    void createCommentTest(){
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("title");
        createPostRequest.setBody("body");
        postService.createPost(createPostRequest);


        CreateCommentRequest commentRequest = new CreateCommentRequest();
        commentRequest.setCommentName("fola");
        commentRequest.setComment("Tall boy");
        commentRequest.setPostId("1");
        commentService.createComment(commentRequest);

        assertEquals(1, commentService.viewAll().size());
    }
}