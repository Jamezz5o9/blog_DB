package africa.semicolon.ofofo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Document
public class Post {
    @Id
    private String id;
    private String body;
    private LocalDateTime date = LocalDateTime.now();
    private String title;
    @DBRef
    private List<Comment> comments = new ArrayList<>();
}
