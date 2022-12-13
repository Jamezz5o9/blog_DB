package africa.semicolon.ofofo.data.repositories;

import africa.semicolon.ofofo.data.models.Post;

import java.util.List;

public interface PostRepository {
    Post save(Post post);
    Post findById(int id);
    void delete(int id);
    void delete(Post post);
    List<Post> findAll();
    long count();
}
