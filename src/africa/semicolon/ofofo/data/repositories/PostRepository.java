package africa.semicolon.ofofo.data.repositories;

import africa.semicolon.ofofo.data.models.Post;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    Post findPostById(String id);
   void deletePostById(String id);

}
