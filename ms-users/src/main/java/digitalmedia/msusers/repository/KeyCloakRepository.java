package digitalmedia.msusers.repository;

import digitalmedia.msusers.models.User;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class KeyCloakRepository implements IUserRepository {

    @Autowired
    private Keycloak keycloak;
    @Value("${digitalmedia.keycloak.realm}")
    private String realm;

    @Override
    public User findById(String id) {
        UserResource userResource = keycloak
                .realm(realm)
                .users().get(id);
        UserRepresentation userRepresentation = userResource.toRepresentation();
        return fromRepresentation(userRepresentation);
    }

    private User fromRepresentation(UserRepresentation userRepresentation) {
        return new User(userRepresentation.getId(), userRepresentation.getUsername(), userRepresentation.getEmail(), userRepresentation.getFirstName(), new ArrayList<>());
    }
}
