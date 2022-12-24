package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Comment;
import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.data.repositories.PostRepository;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements  PostService{
   @Autowired
   PostRepository postRepository;
    @Override
    public void createPost(CreatePostRequest createPostRequest) {
       Post post = new Post();
       post.setTitle(createPostRequest.getTitle());
       post.setBody(createPostRequest.getBody());
       postRepository.save(post);
    }

    @Override
    public void updatePost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        if(!Objects.equals(post.getId(), "")) {
            Post savedPost = postRepository.findPostById(post.getId());
            savedPost.setBody(post.getBody());
            savedPost.setTitle(post.getTitle());
        }

    }

    @Override
    public void deletePost(String id) {
        postRepository.deletePostById(id);
    }

    @Override
    public Post viewPost(String id) {
        return postRepository.findPostById(id);
    }

    @Override
    public List<Post> viewAllPost() {
        return postRepository.findAll();
    }

    @Override
    public void addComment(String postId, Comment comment) {
       Post postSaved =  postRepository.findPostById(postId);
       postSaved.getComments().add(comment);
       postRepository.save(postSaved);
    }
}
