package data.repositories;

import data.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImp implements CommentRepository{

    private final List<Comment> commendDb = new ArrayList<>();
    private int count;
    @Override
    public Comment save(Comment comment) {
        if(comment.getId() != 0) update(comment);
        else{
            comment.setId(++count);
            commendDb.add(comment);
        }

        return comment;
    }

    private void update(Comment comment) {
        Comment savedComment = findById(comment.getId());
        savedComment.setCommentName(comment.getCommentName());
        savedComment.setComment(comment.getComment());
    }

    @Override
    public Comment findById(int id) {
        return commendDb.stream().filter(comments -> comments.getId() == id).findFirst().get();
    }

    @Override
    public void delete(int id) {
        commendDb.removeIf(comments -> comments.getId() == id);
    }

    @Override
    public void delete(Comment comment) {
       commendDb.remove(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commendDb;
    }

    @Override
    public long count() {
        return commendDb.size();
    }
}
