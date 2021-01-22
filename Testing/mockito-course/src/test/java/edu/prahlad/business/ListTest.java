package edu.prahlad.business;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void letsMockListSizeMethod(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);

        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
    }


    @Test
    public void letsMockListSize_ReturnMultipleValues(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);

        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }


    @Test
    public void letsMockListGet(){
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("rao");

        assertEquals("rao", listMock.get(0));
        assertEquals(null, listMock.get(1));
        //Nice Mock - returns null
    }

    @Test
    public void letsMockListGetArgumentMatcher(){
        List listMock = mock(List.class);
        //Argument Matcher
        when(listMock.get(anyInt())).thenReturn("rao");

        assertEquals("rao", listMock.get(0));
        assertEquals("rao", listMock.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void letsMockList_throwAnException(){
        List listMock = mock(List.class);
        //Argument Matcher
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something is wrong"));

       listMock.get(0);
    }

    @Test(expected = RuntimeException.class)
    public void letsMockList_mixingUp(){
        List listMock = mock(List.class);
        //Argument Matcher
        when(listMock.subList(anyInt(),5)).thenThrow(new RuntimeException("Something is wrong"));
        //subList condition - has no effect or doesn't work
        listMock.get(9);

    }

    @Test
    public void letsMockListGet_usingBDD(){
        //Given
        List<String> listMock = mock(List.class);
        given(listMock.get(anyInt())).willReturn("rao");

        //when
        String firstElement = listMock.get(0);

        //Then
        assertThat(firstElement, is("rao"));
    }

}
