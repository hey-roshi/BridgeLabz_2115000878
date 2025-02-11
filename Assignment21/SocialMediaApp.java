import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds; // List of Friend IDs
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }

    public void addFriend(int friendId) {
        if (!friendIds.contains(friendId)) {
            friendIds.add(friendId);
        }
    }

    public void removeFriend(int friendId) {
        friendIds.remove(Integer.valueOf(friendId));
    }
}

class SocialMedia {
    private User head;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
            return;
        }
        User temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newUser;
    }

    public User searchUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriendship(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);
        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
        }
    }

    public void removeFriendship(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);
        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
        }
    }

    public void displayFriends(int userId) {
        User user = searchUser(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friendIds);
        } else {
            System.out.println("User not found.");
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        HashSet<Integer> mutualFriends = new HashSet<>(user1.friendIds);
        mutualFriends.retainAll(user2.friendIds);

        System.out.println("Mutual Friends between " + user1.name + " and " + user2.name + ": " + mutualFriends);
    }

    public void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 23);
        sm.addUser(3, "Charlie", 27);
        sm.addUser(4, "David", 22);

        sm.addFriendship(1, 2);
        sm.addFriendship(1, 3);
        sm.addFriendship(2, 3);
        sm.addFriendship(3, 4);

        System.out.println("All Users:");
        sm.displayAllUsers();

        System.out.println("\nDisplaying Friends:");
        sm.displayFriends(1);
        sm.displayFriends(2);
        sm.displayFriends(3);

        System.out.println("\nFinding Mutual Friends:");
        sm.findMutualFriends(1, 3);
        sm.findMutualFriends(2, 4);

        System.out.println("\nRemoving Friendship (Alice & Bob)...");
        sm.removeFriendship(1, 2);
        sm.displayFriends(1);
        sm.displayFriends(2);
    }
}
