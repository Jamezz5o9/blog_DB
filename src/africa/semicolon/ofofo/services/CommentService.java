package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Comment;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;

import java.util.List;

public interface CommentService {
    void createComment(CreateCommentRequest commentRequest);
    List<Comment> viewAll();
    Comment viewComment(String id);
}
