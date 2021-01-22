package edu.prahlad.business;

import edu.prahlad.data.api.TodoService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoToInjectMockTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule(); //we can handle multiple runners

    //Plumbing the infra is reduced using mockito
    @Mock
    TodoService todoServiceMock;

    //Autowiring handling - Checks for the constructor initialization and adds them automatically
    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock(){
        List<String> todos = Arrays.asList(
                "Learn Spring MVC",
                "Learn Spring",
                "Learn to Dance");

        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(2, filteredTodos.size());
    }


    @Test
    public void testRetrieveTodosRelatedToSpring_withEmptyList(){
        List<String> todos = Arrays.asList();
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(0, filteredTodos.size());
    }


    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD(){

        //Given
        List<String> todos = Arrays.asList(
                "Learn Spring MVC",
                "Learn Spring",
                "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        //When
        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        //Then
        assertThat(filteredTodos.size(), is(2));
    }



    @Test
    public void testRetrieveTodosDeleteToSpring_usingBDD(){

        //Given
        List<String> todos = Arrays.asList(
                "Learn Spring MVC",
                "Learn Spring",
                "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        //When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        //Then
        verify(todoServiceMock).deleteTodo("Learn to Dance"); //any no of times - default impl
        verify(todoServiceMock, atLeastOnce())
                .deleteTodo("Learn to Dance");
        verify(todoServiceMock, atLeast(1))
                .deleteTodo("Learn to Dance");
        verify(todoServiceMock, times(1))
                .deleteTodo("Learn to Dance");

        verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
        verify(todoServiceMock, never()).deleteTodo("Learn Spring");


        //Then - alternate way to verify
        then(todoServiceMock).should().deleteTodo("Learn to Dance");
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring");

    }



    @Test
    public void testRetrieveTodosDeleteToSpring_argumentCapture(){

        //Declare Argument Captor
        //Define Argument captor on specific method call
        //Capture the argument

        //Declare Argument Captor
        ArgumentCaptor<String> stringArgumentCaptor =
                ArgumentCaptor.forClass(String.class);

        //Given
        List<String> todos = Arrays.asList(
                "Learn Spring MVC",
                "Learn Spring",
                "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        //When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        //Then
        //Define Argument captor on specific method call
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());

        //Capture the argument
        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));

    }


    @Test
    public void testRetrieveTodosDeleteToSpring_argumentCaptureMultipleTimes(){

        //Declare Argument Captor
        //Define Argument captor on specific method call
        //Capture the argument

        //Given
        List<String> todos = Arrays.asList(
                "Learn TO Rock and Roll",
                "Learn Spring",
                "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        //When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        //Then
        //Define Argument captor on specific method call
        then(todoServiceMock).should(times(2))
                .deleteTodo(stringArgumentCaptor.capture());

        //Capture the argument
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));

    }


}