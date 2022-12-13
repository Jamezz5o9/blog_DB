package services;

import data.models.Post;
import dtos.requests.CreatePostRequest;

import java.util.List;

public interface PostService {
    void createPost(CreatePostRequest createPostRequest);
    void updatePost(CreatePostRequest createPostRequest);
    void deletePost(int id);
    Post viewPost(int id);
    List<Post> viewAllPost();
}
