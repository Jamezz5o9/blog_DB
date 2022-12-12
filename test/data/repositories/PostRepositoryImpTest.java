package data.repositories;

import data.models.Post;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryImpTest {
    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
        postRepository = new PostRepositoryImp();
    }

    @Test
    void saveNewPost_countShould_beOneTest(){
        Post post = new Post();
        post.setTitle("Mathematics");
        post.setBody("Polynomial concepts and advanced computing");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
        Post post2 = new Post();
        postRepository.save(post2);
        assertEquals(2L, postRepository.count());
    }
    @Test
    void savedPostCanBeUpdatedAndCountIsStillOne(){
        Post post = new Post();
        post.setTitle("Mathematics");
        post.setBody("Polynomial concepts and advanced computing");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
        Post updatedPost = new Post();
        updatedPost.setId(1);
        updatedPost.setTitle("English");
        updatedPost.setBody("Mastering the fundamentals of vowel sound");
        postRepository.save(updatedPost);
        assertEquals(1L, postRepository.count());
        assertEquals(post, postRepository.findById(post.getId()));
        assertEquals("English", post.getTitle());
        assertEquals("Mastering the fundamentals of vowel sound", post.getBody());
    }
}