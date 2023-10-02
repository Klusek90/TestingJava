package com.example.testinunit;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List<String> mock = mock(List.class);
    @Test
    public void test(){
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void returnDifferentValues(){
        when(mock.size()).thenReturn(10).thenReturn(5);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void returnWithParameters(){
        when(mock.get(0)).thenReturn("test");
        when(mock.get(2)).thenReturn("test2");
        assertEquals("test",mock.get(0));
        assertEquals("test2",mock.get(1));
    }

    @Test
    public void verificationBasic()
    {
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());

    }

    @Test
    public void multipleArgumntCapture()
    {
        mock.add("Something1");
        mock.add("Something2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(mock, times(2)).add(captor.capture()); //by default checing if its called once

        List<String> allValues = captor.getAllValues();

        assertEquals("Something1", allValues.get(0));
        assertEquals("Something2", allValues.get(1));

    }
}
