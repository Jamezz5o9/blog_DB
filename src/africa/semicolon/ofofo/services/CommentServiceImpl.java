package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Comment;
import africa.semicolon.ofofo.data.repositories.CommentRepository;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentRepository commentRepo;
    @Override
    public void createComment(CreateCommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setComment(commentRequest.getComment());
        comment.setCommentName(commentRequest.getCommentName());
        Comment savedComment = commentRepo.save(comment);
        postService.addComment(commentRequest.getPostId(), savedComment);
    }

    @Override
    public List<Comment> viewAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment viewComment(String id) {
        return commentRepo.findCommentById(id);
    }

}
