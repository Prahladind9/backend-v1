package edu.prahlad.mockito;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {
//Avoid Spy in projects .. only used in legacy system
    //as functionality is broken .. leads to confusion

    @Test
    public void test(){
        List arrayListMock = mock(ArrayList.class);

        assertEquals(0, arrayListMock.size());

        stub(arrayListMock.size()).toReturn(5);
        arrayListMock.add("Dummy"); //doesn't effect as we are using mock
        assertEquals(5, arrayListMock.size());

    }

    @Test
    public void testSpy(){
        List arrayListSpy = spy(ArrayList.class); //real arrayList
        assertEquals(0, arrayListSpy.size());
        arrayListSpy.add("Dummy");

        assertEquals(1, arrayListSpy.size());

        //Overriding the size method
        stub(arrayListSpy.size()).toReturn(5);
        assertEquals(5, arrayListSpy.size());


        verify(arrayListSpy).add("Dummy");
        verify(arrayListSpy, never()).clear();
    }

}
