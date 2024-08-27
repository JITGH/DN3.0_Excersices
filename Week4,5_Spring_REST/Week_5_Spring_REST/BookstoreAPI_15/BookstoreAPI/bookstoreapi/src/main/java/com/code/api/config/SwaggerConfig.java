import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi bookstoreApi() {
        return GroupedOpenApi.builder()
            .group("bookstore-api")
            .pathsToMatch("/api/books/**")
            .build();
    }
}
