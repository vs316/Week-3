package DSA.LinkedLists;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

class FriendNode{
    String userId;
    String name;
    int age;
    List<String> listOfFriendIds;
    FriendNode next;

    public FriendNode(String userId, String name,int age, List<String> listOfFriendIds){
        this.userId=userId;
        this.name=name;
        this.age=age;
        this.listOfFriendIds=listOfFriendIds;
        this.next=null;
    }
}

// Manages the list of users and their friend connections.
class FriendsLinkedList {
    private FriendNode head;

    // Adds a new user at the end of the linked list.
    public void addUserAtEnd(String userId, String name, int age) {
        // Instantiate a new user. Initialize friend list as an empty LinkedList.
        FriendNode newNode = new FriendNode(userId, name, age, new LinkedList<>());
        if (head == null) {
            head = newNode;
        } else {
            FriendNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Searches for a user by User ID.
    public FriendNode searchUserByUserId(String userId) {
        FriendNode temp = head;
        while (temp != null) {
            if (temp.userId.equals(userId)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Searches for a user by Name (case-insensitive).
    public FriendNode searchUserByName(String name) {
        FriendNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Displays all users in the system.
    public void displayAllUsers() {
        FriendNode temp = head;
        while (temp != null) {
            System.out.println("UserID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age +
                    ", Friends: " + temp.listOfFriendIds);
            temp = temp.next;
        }
    }

    // Adds a friend connection between two users (both users get each other as friends).
    public void addFriendConnection(String userId1, String userId2) {
        FriendNode user1 = searchUserByUserId(userId1);
        FriendNode user2 = searchUserByUserId(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found. Cannot add friend connection.");
            return;
        }
        // Add friend IDs if not already present.
        if (!user1.listOfFriendIds.contains(userId2)) {
            user1.listOfFriendIds.add(userId2);
        }
        if (!user2.listOfFriendIds.contains(userId1)) {
            user2.listOfFriendIds.add(userId1);
        }
        System.out.println("Friend connection added between " + userId1 + " and " + userId2);
    }

    // Removes the friend connection between two users.
    public void removeFriendConnection(String userId1, String userId2) {
        FriendNode user1 = searchUserByUserId(userId1);
        FriendNode user2 = searchUserByUserId(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found. Cannot remove friend connection.");
            return;
        }
        if (user1.listOfFriendIds.contains(userId2)) {
            user1.listOfFriendIds.remove(userId2);
        }
        if (user2.listOfFriendIds.contains(userId1)) {
            user2.listOfFriendIds.remove(userId1);
        }
        System.out.println("Friend connection removed between " + userId1 + " and " + userId2);
    }

    // Finds mutual friends between two users.
    // Returns a list of friend IDs that exist in both users' friend lists.
    public List<String> findMutualFriends(String userId1, String userId2) {
        FriendNode user1 = searchUserByUserId(userId1);
        FriendNode user2 = searchUserByUserId(userId2);
        List<String> mutualFriends = new ArrayList<>();

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found. Cannot find mutual friends.");
            return mutualFriends;
        }

        // Loop through user1's friend list and add to mutualFriends if found in user2's friend list.
        for (String friendId : user1.listOfFriendIds) {
            if (user2.listOfFriendIds.contains(friendId)) {
                mutualFriends.add(friendId);
            }
        }
        return mutualFriends;
    }

    // Displays all friends (friend IDs) of the given user.
    public void displayFriends(String userId) {
        FriendNode user = searchUserByUserId(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of " + user.name + " (" + user.userId + "):");
        for (String friendId : user.listOfFriendIds) {
            System.out.println(friendId);
        }
    }

    // Returns the number of friends the specified user has.
    public int countFriends(String userId) {
        FriendNode user = searchUserByUserId(userId);
        if (user == null) {
            System.out.println("User not found.");
            return 0;
        }
        return user.listOfFriendIds.size();
    }
}

public class SocialMediaFriendListManagement {
    public static void main(String[] args) {
        FriendsLinkedList socialNetwork = new FriendsLinkedList();

        // Create users in the social network.
        socialNetwork.addUserAtEnd("U001", "Alice", 25);
        socialNetwork.addUserAtEnd("U002", "Bob", 30);
        socialNetwork.addUserAtEnd("U003", "Charlie", 28);
        socialNetwork.addUserAtEnd("U004", "Diana", 22);

        // Display all users.
        System.out.println("All Users:");
        socialNetwork.displayAllUsers();
        System.out.println();

        // Add friend connections between users (bidirectional).
        socialNetwork.addFriendConnection("U001", "U002");
        socialNetwork.addFriendConnection("U001", "U003");
        socialNetwork.addFriendConnection("U002", "U004");
        socialNetwork.addFriendConnection("U003", "U004");

        // Display friends for each user.
        System.out.println();
        socialNetwork.displayFriends("U001");
        socialNetwork.displayFriends("U002");
        socialNetwork.displayFriends("U003");
        socialNetwork.displayFriends("U004");

        // Count friends.
        System.out.println();
        System.out.println("Number of friends for U001: " + socialNetwork.countFriends("U001"));
        System.out.println("Number of friends for U002: " + socialNetwork.countFriends("U002"));

        // Find and display mutual friends between two users.
        List<String> mutual = socialNetwork.findMutualFriends("U001", "U004");
        System.out.println();
        System.out.println("Mutual friends between U001 and U004: " + mutual);

        // Remove a friend connection.
        socialNetwork.removeFriendConnection("U001", "U002");
        System.out.println();
        socialNetwork.displayFriends("U001");
        socialNetwork.displayFriends("U002");

        // Search for a user by name.
        System.out.println();
        FriendNode foundUser = socialNetwork.searchUserByName("Charlie");
        if (foundUser != null) {
            System.out.println("Found user by name: " + foundUser.name + " with ID: " + foundUser.userId);
        } else {
            System.out.println("User not found by name.");
        }
    }
}

