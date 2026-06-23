package Module_4.Mockito.src.test.java.com.example;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Module_4.Mockito.src.main.java.com.example.ExternalApi;

import static org.mockito.Mockito.verify;

public class MyServiceVerifyTest {

    @Test
    public void testVerifyInteraction() {

        // Create Mock Object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Create Service
        MyService service = new MyService(mockApi);

        // Call Method
        service.fetchData();

        // Verify Interaction
        verify(mockApi).getData();
    }
}