package data.repositories;

import data.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImp implements PostRepository {

    private final List<Post> postDB = new ArrayList<>();
    private int count;

    @Override
    public Post save(Post post) {
        if(post.getId() != 0) update(post);
        else{
            post.setId(++count);
            postDB.add(post);
        }
        return post;
    }

    private void update(Post post){
        Post savedPost = findById(post.getId());
        savedPost.setBody(post.getBody());
        savedPost.setTitle(post.getTitle());
    }

    @Override
    public Post findById(int id) {
        return  postDB.stream().filter(post -> post.getId() == id).findFirst().get();
    }

    @Override
    public void delete(int id) {
       Post deletePost = postDB.stream().filter(post -> post.getId() == id).findFirst().get();
       postDB.remove(deletePost);
    }

    @Override
    public void delete(Post post) {
        postDB.remove(post);
    }

    @Override
    public List<Post> findAll() {
        return postDB;
    }

    @Override
    public long count() {
        return postDB.size();
    }
}
