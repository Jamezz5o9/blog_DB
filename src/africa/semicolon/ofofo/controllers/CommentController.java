package africa.semicolon.ofofo.controllers;

import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import africa.semicolon.ofofo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import africa.semicolon.ofofo.data.models.Comment;
import java.util.List;


@RestController
public class CommentController {

        @Autowired
        private CommentService commentService;
        @PostMapping("/comment")
        public String addComment(@RequestBody CreateCommentRequest commentRequest){
            commentService.createComment(commentRequest);
            return "Comment added successfully";
        }

        @GetMapping("/comment/{commentId}")
        public Comment viewComment(@PathVariable String commentId){
            return commentService.viewComment(commentId);
        }

        @GetMapping("/comment")
        public List<Comment> viewAllComment(){
            return commentService.viewAll();
        }

}
