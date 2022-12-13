package africa.semicolon.ofofo.data.repositories;

import africa.semicolon.ofofo.data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImpTest {
    CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImp();
    }

    @Test
    void saveComment_countShouldBeOne(){
        Comment comment = new Comment();
        comment.setCommentName("Politics");
        comment.setComment("I don't love how africans play politics nowadays");
        commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());
    }
    
    @Test
    void findTheId_ofSavedComment(){
        Comment comment = new Comment();
        comment.setCommentName("Politics");
        comment.setComment("I don't love how africans play politics nowadays");
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());
        assertEquals(comment, commentRepository.findById(savedComment.getId()));


        Comment secondComment = new Comment();
        secondComment.setCommentName("Poverty");
        secondComment.setComment("The rate of poverty in Nigeria is really bothering");
        Comment secondSaved = commentRepository.save(secondComment);
        assertEquals(2L, commentRepository.count());
        assertEquals(secondComment, commentRepository.findById(secondSaved.getId()));

    }

    @Test
    void deleteCommentById_countIsZero(){
        Comment comment = new Comment();
        comment.setCommentName("Politics");
        comment.setComment("I don't love how africans play politics nowadays");
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());
        assertEquals(comment, commentRepository.findById(savedComment.getId()));

        Comment secondComment = new Comment();
        secondComment.setCommentName("Poverty");
        secondComment.setComment("The rate of poverty in Nigeria is really bothering");
        Comment secondSaved = commentRepository.save(secondComment);
        assertEquals(2L, commentRepository.count());
        assertEquals(secondComment, commentRepository.findById(secondSaved.getId()));

        commentRepository.delete(savedComment.getId());
        commentRepository.delete(secondSaved.getId());

        assertEquals(0L, commentRepository.count());
    }

    @Test
    void deleteCommentsByComment_countReducedAfterDeletion(){
        Comment comment = new Comment();
        comment.setCommentName("Politics");
        comment.setComment("I don't love how africans play politics nowadays");
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());


        Comment secondComment = new Comment();
        secondComment.setCommentName("Poverty");
        secondComment.setComment("The rate of poverty in Nigeria is really bothering");
        Comment secondSaved = commentRepository.save(secondComment);
        assertEquals(2L, commentRepository.count());

        Comment thirdComment = new Comment();
        thirdComment.setCommentName("Education");
        thirdComment.setComment("The poor quality of education in Nigeria is highly alarming");
        Comment thirdSaved = commentRepository.save(thirdComment);
        assertEquals(3L, commentRepository.count());

        commentRepository.delete(comment);
        assertEquals(2L, commentRepository.count());
        assertEquals(secondComment, commentRepository.findById(secondSaved.getId()));





    }
}