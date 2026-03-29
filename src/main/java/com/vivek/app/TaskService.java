package com.vivek.app;

import java.util.*;

public class TaskService {

    static class Task {
        String name;
        boolean done;

        Task(String name) {
            this.name = name;
            this.done = false;
        }
    }

    private List<Task> tasks = new ArrayList<>();

    public void addTask(String name) {
        if (name != null && !name.isEmpty()) {
            tasks.add(new Task(name));
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void markDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).done = true;
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
