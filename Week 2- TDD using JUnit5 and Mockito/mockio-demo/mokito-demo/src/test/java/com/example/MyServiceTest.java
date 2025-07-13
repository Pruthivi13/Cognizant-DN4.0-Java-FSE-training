package com.example;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData(); // ✅ Verifies method call
    }

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        when(mockApi.fetchDataById(anyInt())).thenReturn("Data for ID");

        MyService service = new MyService(mockApi);
        String result = service.getDataById(42);

        assertEquals("Data for ID", result);

        verify(mockApi).fetchDataById(eq(42));
    }

    @Test
    public void testVoidMethodLogging() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        Logger mockLogger = Mockito.mock(Logger.class);

        doNothing().when(mockLogger).log(anyString());

        MyService service = new MyService(mockApi, mockLogger);

        service.processAndLog("Test Input");

        verify(mockLogger).log(eq("Processing input: Test Input"));
    }

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        when(mockApi.getData())
                .thenReturn("First Call")
                .thenReturn("Second Call");

        MyService service = new MyService(mockApi);

        String result = service.getTwoCallsCombined();

        assertEquals("First Call & Second Call", result);
    }

    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        when(mockApi.getData()).thenReturn("Ordered Data");

        MyService service = new MyService(mockApi);

        String result = service.getDataWithConnection();
        assertEquals("Ordered Data", result);

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).connect();
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).disconnect();
    }
    @Test
public void testVoidMethodThrowsException() {
    ExternalApi mockApi = Mockito.mock(ExternalApi.class);
    Logger mockLogger = Mockito.mock(Logger.class);

    doThrow(new RuntimeException("Logging failed"))
            .when(mockLogger).log(anyString());

    MyService service = new MyService(mockApi, mockLogger);

    assertThrows(RuntimeException.class, () -> {
        service.logOrThrow("This will fail");
    });

    verify(mockLogger).log(eq("This will fail"));
}


}
