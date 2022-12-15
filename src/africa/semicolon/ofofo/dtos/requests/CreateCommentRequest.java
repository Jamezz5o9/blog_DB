package africa.semicolon.ofofo.dtos.requests;

import lombok.*;

@Data
public class CreateCommentRequest {
    private String postId;
    private String commentName;
    private String comment;
}
