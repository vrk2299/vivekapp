package com.vivek.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        service.addTask("Task1");

        assertEquals(1, service.getTasks().size());
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        service.addTask("Task1");

        service.deleteTask(0);

        assertEquals(0, service.getTasks().size());
    }

    @Test
    public void testMarkDone() {
        TaskService service = new TaskService();
        service.addTask("Task1");

        service.markDone(0);

        assertTrue(service.getTasks().get(0).done);
    }
}
