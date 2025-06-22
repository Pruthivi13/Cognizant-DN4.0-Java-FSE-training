public class TaskManager {
    private TaskNode head;

    // Add task at the end
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Added: " + task);
    }

    // Search by taskId
    public Task searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Delete task by ID
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            System.out.println("Deleted task with ID: " + taskId);
            return;
        }

        TaskNode prev = head;
        TaskNode current = head.next;

        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                prev.next = current.next;
                System.out.println("Deleted task with ID: " + taskId);
                return;
            }
            prev = current;
            current = current.next;
        }

        System.out.println("Task not found.");
    }

    // Traverse and print
    public void displayTasks() {
        System.out.println("\nTask List:");
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
}
