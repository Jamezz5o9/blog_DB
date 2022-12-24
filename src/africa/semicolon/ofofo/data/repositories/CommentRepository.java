package africa.semicolon.ofofo.data.repositories;

import africa.semicolon.ofofo.data.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    Comment findCommentById(String id);
}
