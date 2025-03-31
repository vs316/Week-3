package DSA.LinkedLists;

class EmployeeNode {
    int id;
    String name;
    String department;
    double salary;
    EmployeeNode next;

    public EmployeeNode(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.next = null;
    }
}

class EmployeeLinkedList {
    private EmployeeNode head;

    public void addEmployeeAtBeginning(int id, String name, String department, double salary) {
        EmployeeNode newNode = new EmployeeNode(id, name, department, salary);
        newNode.next = head;
        head = newNode;
    }

    public void addEmployeeAtEnd(int id, String name, String department, double salary) {
        EmployeeNode newNode = new EmployeeNode(id, name, department, salary);
        if (head == null) { //Check if the SLL is empty, if so, then head points to or becomes the newNode itself
            head = newNode;
        } else {
            EmployeeNode temp = head;
            while (temp.next != null) { //traverse till the end of the list when temp.next==null
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void addEmployeeAtPosition(int id, String name, String departmnent, double salary, int position) {
        if (position == 1) {
            addEmployeeAtBeginning(id, name, departmnent, salary);
            return;
        }
        EmployeeNode newNode = new EmployeeNode(id, name, departmnent, salary);
        EmployeeNode temp = head; //hold pointer to first position in the list
        for (int i = 1; i < position - 1; i++) {// 1-based indexing: start from i=1 as we have already a pointer pointing to the first node or the head, traversing till i<position-1 as we want to stop at the node just before the insertion point. because we need to adjust the pointers of this prev node to point to the new node.
            if (temp == null) throw new IndexOutOfBoundsException("Invalid position");
            temp = temp.next;
        }//once loop ends , the temp var points to the node just before the insertion position
        newNode.next = temp.next;// as we are adding the newNode in between the prev node and the next node , set the value of newNode.next=temp.next as temp currently points to the prev node.
        temp.next = newNode; // this links the prev node to the new node
    }

    public void deleteEmployeeById(int id) {
        if (head == null) {//empty list
            System.out.println("List is empty");
            return;
        }
        if (head.id == id) {//if the id points to the first element
            head = head.next;
            return;
        }
        EmployeeNode temp = head;
        while (temp.next != null && temp.next.id != id) {//when temp.next==null, we have reached the end of the list, so to prevent out of bounds exception. temp.next.id!=id ensures that we stop the traversal on finding the node whose id matches the required one we want to delete.the check is done on temp.next because we want locate the node just before the one we want to delete. We need to adjust the next pointer of the node before the one we are supposed to delete. To do that we must focus on the next node(temp.next) and not the current node(temp).
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Employee not found.");
        } else {
            temp.next = temp.next.next;//updates the pointer of the curr node(temp) to skip over the node to delete.
        }
    }

    public EmployeeNode searchEmployeeById(int id) {
        EmployeeNode temp = head;
        while (temp != null) {
            if (temp.id == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public EmployeeNode searchEmployeeByName(String name) {
        EmployeeNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void displayEmployees() {
        if (head == null) {
            System.out.println("No records to display");
            return;
        }
        EmployeeNode temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Department: " + temp.department + ", Salary: " + temp.salary);
            temp = temp.next;
        }

    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeLinkedList employeeList = new EmployeeLinkedList();

        // Add employees
        employeeList.addEmployeeAtBeginning(1, "Alice", "HR", 50000);
        employeeList.addEmployeeAtEnd(2, "Bob", "Engineering", 60000);
        employeeList.addEmployeeAtPosition(3, "Charlie", "Finance", 55000, 2);

        // Display all employees
        System.out.println("Employee Records:");
        employeeList.displayEmployees();

        // Search for an employee
        System.out.println("\nSearching for Employee with ID 2:");
        EmployeeNode searchResult = employeeList.searchEmployeeById(2);
        if (searchResult != null) {
            System.out.println("Found: ID: " + searchResult.id + ", Name: " + searchResult.name);
        } else {
            System.out.println("Employee not found");
        }

        // Delete an employee
        System.out.println("\nDeleting Employee with ID 1:");
        employeeList.deleteEmployeeById(1);
        employeeList.displayEmployees();
    }
}
