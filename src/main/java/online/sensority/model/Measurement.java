package online.sensority.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "{#mongoConfihuration.getCollectionName()}")
public class Measurement {

    private String id;

    @NonNull
    private String title;
}

