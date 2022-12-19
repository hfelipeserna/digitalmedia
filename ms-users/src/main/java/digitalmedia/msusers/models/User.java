package digitalmedia.msusers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String username;
    private String email;
    private String firstName;
    private List<Bill> bills;
}
