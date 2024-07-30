public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }
        //Add a Task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        newNode.setNext(head);
        head = newNode;
    }
        //Search a Task
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.getTask().getTaskId() == taskId) {
                return current.getTask();
            }
            current = current.getNext();
        }
        return null;
    }
        // Traverse all Task
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.getTask());
            current = current.getNext();
        }
    }
        //Delete a Task
    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false;
        }

        if (head.getTask().getTaskId() == taskId) {
            head = head.getNext();
            return true;
        }

        Node current = head;
        while (current.getNext() != null && current.getNext().getTask().getTaskId() != taskId) {
            current = current.getNext();
        }

        if (current.getNext() == null) {
            return false;
        }

        current.setNext(current.getNext().getNext());
        return true;
    }

}