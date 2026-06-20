package Module_2.Data_Structures;

class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    @Override
    public String toString() {
        return "Task[" + taskId + "] " + taskName + " (" + status + ")";
    }
}

public class TaskManagement {

    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
        }
    }

    private Node head;

    public void add(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public Task search(String taskId) {
        Node temp = head;

        while (temp != null) {
            if (temp.task.getTaskId().equals(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }

        return null;
    }

    public void traverse() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    public boolean delete(String taskId) {
        if (head == null) {
            return false;
        }

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return true;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.task.getTaskId().equals(taskId)) {
                prev.next = curr.next;
                return true;
            }

            prev = curr;
            curr = curr.next;
        }

        return false;
    }

    public static void main(String[] args) {
        TaskManagement tm = new TaskManagement();

        tm.add(new Task("T1", "Setup Database", "Completed"));
        tm.add(new Task("T2", "Develop API", "In Progress"));
        tm.add(new Task("T3", "Write Unit Tests", "Pending"));

        System.out.println("Current Task List");
        tm.traverse();

        System.out.println("\nSearching for T2:");
        System.out.println(tm.search("T2"));

        System.out.println("\nDeleting Task T1...");
        tm.delete("T1");

        tm.traverse();
    }
}