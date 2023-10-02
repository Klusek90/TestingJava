package com.example.testinunit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuissnesTest {

    @InjectMocks
    Buissnes buissnes;
    @Mock
    SomeDataService mockSomeDataService = mock(SomeDataService.class);

    @Test
    public  void calculateSumUsingService(){
        when(mockSomeDataService.retriveAllData()).thenReturn(new int[] {1,2,3});
        assertEquals(6, buissnes.calculatedSum());
    }

    @Test
    public  void calculateSumUsingService2(){
        when(mockSomeDataService.retriveAllData()).thenReturn(new int[] { });
        assertEquals(0, buissnes.calculatedSum());
    }

    @Test
    public  void calculateSumUsingService3(){
        when(mockSomeDataService.retriveAllData()).thenReturn(new int[] {1,2});
        assertNotEquals(4, buissnes.calculatedSum());
    }
}
