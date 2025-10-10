package Config;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.net.URI;

@ExtendWith(MockitoExtension.class)
public class TestConfig {
    protected static DynamoDbClient createTestDynamoDbClient() {
        return DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000"))
                .build();
    }
}
