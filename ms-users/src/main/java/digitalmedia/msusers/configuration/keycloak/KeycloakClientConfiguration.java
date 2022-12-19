package digitalmedia.msusers.configuration.keycloak;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "keycloak")
public class KeycloakClientConfiguration {
    @Value("${dm.keycloak.realm}")
    private String realm;
    @Value("${dm.keycloak.serverurl}")
    private String serverurl;
    @Value("${dm.keycloak.clientid}")
    private String clientid;
    @Value("${dmkeycloak.clientsecret}")
    private String clientsecret;

    @Bean
    public Keycloak buildClient() {
        return KeycloakBuilder.builder()
                .serverUrl(serverurl)
                .realm(realm)
                .clientId(clientid)
                .clientSecret(clientsecret)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
    }
}
