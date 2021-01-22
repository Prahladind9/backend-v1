package edu.prahlad.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@PowerMockIgnore("jdk.internal.reflect.*")
@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
public class MockingConstructorTest {

    //Bad Programming to use PowerMock

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Mock
    ArrayList mockList;

    @Test
    public void testBadNames() throws Exception {
        List<Integer> stats = Arrays.asList(1,2,3);

        when(mockList.size()).thenReturn(10);

        PowerMockito.whenNew(ArrayList.class)
                .withAnyArguments()
                .thenReturn(mockList);

        int size = systemUnderTest.methodUsingAnArrayListConstructor();
        assertEquals(10, size);

    }
}
