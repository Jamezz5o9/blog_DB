package africa.semicolon.ofofo.dtos.requests;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class CreatePostRequest {
    private String title;
    private String body;

}
