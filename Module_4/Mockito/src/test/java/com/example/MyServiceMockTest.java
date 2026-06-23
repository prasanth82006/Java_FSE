package Module_4.Mockito.src.test.java.com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MyServiceMockTest {

    @Test
    public void testExternalApi() {

        // Create Mock Object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub Method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Inject Mock into Service
        MyService service = new MyService(mockApi);

        // Call Service Method
        String result = service.fetchData();

        // Verify Result
        assertEquals("Mock Data", result);
    }
}