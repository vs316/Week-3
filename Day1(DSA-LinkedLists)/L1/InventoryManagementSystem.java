package DSA.LinkedLists;

import java.util.Objects;

class InventoryNode {
    String itemName;
    String itemId;
    int quantity;
    Double price;
    InventoryNode next;

    public InventoryNode(String itemName, String itemId, int quantity, Double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    private InventoryNode head;

    public void addItemAtBeginning(String itemName, String itemId, int quantity, Double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    public void addItemAtEnd(String itemName, String itemId, int quantity, Double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
        } else {
            InventoryNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

    }

    public void addItemAtSpecificPosition(String itemName, String itemId, int quantity, Double price, int position) {
        if (position == 1) {
            addItemAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        InventoryNode temp = head;
        for (int i = 1; i < position - 1; i++) {
            if (temp == null) throw new IndexOutOfBoundsException("Invalid position.");
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeItemBasedOnId(String itemId) {
        InventoryNode temp = head;
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.itemId.equals(itemId)) {
            head = head.next;
            return;
        }
        while (temp.next != null && !temp.next.itemId.equals(itemId)) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item with id: " + itemId + " not found in the inventory.");
        } else {
            temp.next = temp.next.next;
        }
    }

    public InventoryNode searchItemByItemId(String itemId) {
        InventoryNode temp = head;
        while (temp != null) {
            if (temp.itemId.equals(itemId)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public InventoryNode getHead() {
        return head;
    }

    public void setHead(InventoryNode head) {
        this.head = head;
    }

    public InventoryNode searchItemByItemName(String itemName) {
        InventoryNode temp = head;
        while (temp != null) {
            if (Objects.equals(temp.itemName, itemName)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void updateQuantityOfItemBasedOnId(String itemId, int quantity) {
        InventoryNode itemDetails = searchItemByItemId(itemId);
        itemDetails.quantity = quantity;
    }

    public void CalcAndDisplayTotalInventoryValue() {
        InventoryNode temp = head;
        Double totalInventoryVal = 0.0;
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        while (temp != null) {
            System.out.println("Item Id: "+temp.itemId+", Item Name: "+temp.itemName+", Quantity: "+temp.quantity+", Price: "+temp.price);
            totalInventoryVal += (temp.price * temp.quantity);
            temp = temp.next;
        }
        System.out.println("Total inventory value: " + totalInventoryVal);
    }

    public void sortInventoryByName(boolean ascending) {
        head = mergeSort(head, ascending, true);
    }

    public void sortInventoryByPrice(boolean ascending) {
        head = mergeSort(head, ascending, false);
    }

    private InventoryNode mergeSort(InventoryNode head, boolean ascending, boolean byName) {
        //Base case: If list is empty or has one element, it is already sorted
        if (head == null || head.next == null) {
            return head;
        }
        //Split the list into two halves
        InventoryNode middle = getMiddle(head);
        InventoryNode nextOfMiddle = middle.next;
        middle.next = null; //Break the list into two halves

        //Recursively sort both halves
        InventoryNode left = mergeSort(head, ascending, byName);
        InventoryNode right = mergeSort(nextOfMiddle, ascending, byName);

        //Merge the sorted halves
        return merge(left, right, ascending, byName);
    }

    private InventoryNode getMiddle(InventoryNode head) {
        if (head == null) return head;

        InventoryNode slow = head;
        InventoryNode fast = head.next;

        //Use two-pointer technique to find the middle of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private InventoryNode merge(InventoryNode left, InventoryNode right, boolean ascending, boolean byName) {
        InventoryNode result;

        //Base cases: if one of the lists is empty, return the other list
        if (left == null) return right;
        if (right == null) return left;

        //Sorting condition: Compare by name or by price
        boolean condition;
        if (byName) {
            condition = ascending == (left.itemName.compareToIgnoreCase(right.itemName) <= 0);
        } else {
            condition = ascending == (left.price <= right.price);
        }

        //Merge based on the condition
        if (condition) {
            result = left;
            result.next = merge(left.next, right, ascending, byName);
        } else {
            result = right;
            result.next = merge(left, right.next, ascending, byName);
        }
        return result;
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();

        // Add items
        inventory.addItemAtEnd("Apple", "A101", 50, 1.2);
        inventory.addItemAtEnd("Banana", "B202", 30, 0.8);
        inventory.addItemAtEnd("Orange", "O303", 20, 1.5);

        System.out.println("Original Inventory:");
        inventory.CalcAndDisplayTotalInventoryValue();

        // Sort by Item Name (ascending)
        inventory.sortInventoryByName(true);
        System.out.println("\nInventory Sorted by Name (Ascending):");
        inventory.CalcAndDisplayTotalInventoryValue();

        // Sort by Price (descending)
        inventory.sortInventoryByPrice(false);
        System.out.println("\nInventory Sorted by Price (Descending):");
        inventory.CalcAndDisplayTotalInventoryValue();
    }
}

