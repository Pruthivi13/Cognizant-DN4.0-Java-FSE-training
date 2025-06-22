public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Task t1 = new Task(1, "Design UI", "Pending");
        Task t2 = new Task(2, "Implement Backend", "In Progress");
        Task t3 = new Task(3, "Write Tests", "Pending");

        manager.addTask(t1);
        manager.addTask(t2);
        manager.addTask(t3);

        manager.displayTasks();

        Task found = manager.searchTask(2);
        System.out.println("\nSearch Result: " + (found != null ? found : "Not Found"));

        manager.deleteTask(1);
        manager.displayTasks();
    }
}
