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

    @Test
    void deleteItem_countReducedAfterDeletion(){
        Post post = new Post();
        post.setTitle("Mathematics");
        post.setBody("Polynomial concepts and advanced computing");
        Post firstPost = postRepository.save(post);
        assertEquals(post, postRepository.findById(firstPost.getId()));

        Post secondPost = new Post();
        secondPost.setTitle("Yoruba");
        secondPost.setBody("Ami ohun ati ayooka oroo");
        Post second = postRepository.save(secondPost);
        assertEquals(secondPost, postRepository.findById(second.getId()));


        Post thirdPost = new Post();
        thirdPost.setTitle("football update");
        thirdPost.setBody("Morocco to win world cup");
        Post third = postRepository.save(thirdPost);
        assertEquals(thirdPost, postRepository.findById(third.getId()));


        Post fourthPost = new Post();
        fourthPost.setTitle("Presidential election");
        fourthPost.setBody("Peter Obi is going to be Nigeria next president argue with your keyboard");
        Post fourth = postRepository.save(fourthPost);
        assertEquals(fourthPost, postRepository.findById(fourth.getId()));


        assertEquals(4L, postRepository.count());
        postRepository.delete(post.getId());
        assertEquals(3L, postRepository.count());
        assertEquals(fourthPost, postRepository.findById(4));

    }

    @Test
    void deleteByPost_countIsZeroTest(){
        Post thirdPost = new Post();
        thirdPost.setTitle("football update");
        thirdPost.setBody("Morocco to win world cup");
        Post third = postRepository.save(thirdPost);
        assertEquals(thirdPost, postRepository.findById(third.getId()));


        Post fourthPost = new Post();
        fourthPost.setTitle("Presidential election");
        fourthPost.setBody("Peter Obi is going to be Nigeria next president argue with your keyboard");
        Post fourth = postRepository.save(fourthPost);
        assertEquals(fourthPost, postRepository.findById(fourth.getId()));

        postRepository.delete(thirdPost);
        assertEquals(1L, postRepository.count());
        postRepository.delete(fourthPost);
        assertEquals(0L, postRepository.count());
    }

    @Test
    void findEachPostById(){
        Post firstPost = new Post();
        firstPost.setTitle("football update");
        firstPost.setBody("Morocco to win world cup");
        Post first = postRepository.save(firstPost);
        assertEquals(firstPost, postRepository.findById(first.getId()));


        Post secondPost = new Post();
        secondPost.setTitle("Presidential election");
        secondPost.setBody("Peter Obi is going to be Nigeria next president argue with your keyboard");
        Post second = postRepository.save(secondPost);
        assertEquals(secondPost, postRepository.findById(second.getId()));

    }
}