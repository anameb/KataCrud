package co.com.sofka.crud.controllers;

import co.com.sofka.crud.repositories.TodoRepository;
import co.com.sofka.crud.services.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration

public class TodoControllerTest {
    @MockBean
    TodoRepository todoRepository;

    @Autowired
    TodoService todoService;

    @Test
    public void listTodoTest(){
        when(todoRepository.findAll()).thenReturn(new ArrayList<>());
        assertThat(todoService.list()).isEmpty();
        verify(todoRepository).findAll();
    }
}
