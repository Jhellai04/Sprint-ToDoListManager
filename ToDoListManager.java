import java.util.ArrayList;

class Task {
    String description;
    boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return description + " - " + (completed ? "Completed" : "Pending");
    }
}

class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
    }

    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markCompleted();
        } else {
            System.out.println("Invalid task index");
        }
    }

    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Task " + (i + 1) + ": " + tasks.get(i));
        }
    }
}

class User {
    String name;
    TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public void addTask(String description) {
        taskList.addTask(description);
    }

    public void markTaskCompleted(int index) {
        taskList.markTaskCompleted(index);
    }

    public void printTasks() {
        System.out.println("Tasks for user " + name + ":");
        taskList.printTasks();
    }
}

class TodoListManager {
    public static void main(String[] args) {
        User[] users = new User[5];
        users[0] = new User("Jhailla");
        users[1] = new User("Jhaille");
        users[2] = new User("Jhann");
        users[3] = new User("Jhanna");
        users[4] = new User("Jelliebeth");

        users[0].addTask("Complete Data Structure assignment");
        users[0].addTask("Study for Midterm sprint");
        users[1].addTask("Prepare project presentation");
        users[1].addTask("Fix bugs in the code");
        users[2].addTask("Update the sprint project");
        users[2].addTask("Write project documentation");
        users[3].addTask("Design a new data structure");
        users[3].addTask("Create marketing materials");
        users[4].addTask("Organize team schedule");
        users[4].addTask("Create final presentation");


        users[2].markTaskCompleted(0); // Marking the first task as completed for Jhann
        users[0].markTaskCompleted(0); // Marking the first task as completed for Jhailla

        //Printing task for each user
        for (User user : users) {
            user.printTasks();
        }
    }
}