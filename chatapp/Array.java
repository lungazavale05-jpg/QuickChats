package chatapp;

import java.util.ArrayList;

public class Array {

    // Global ArrayLists to store messages based on their status
    public static ArrayList<String> sentMessages = new ArrayList<>();
    public static ArrayList<String> disregardedMessages = new ArrayList<>();
    public static ArrayList<String> storedMessages = new ArrayList<>();
    public static ArrayList<String> messageHashes = new ArrayList<>();
    public static ArrayList<String> messageIDs = new ArrayList<>();

    // Method to add a sent message and its details
    public static void addSentMessage(String message, String id, String hash) {
        sentMessages.add(message);
        messageIDs.add(id);
        messageHashes.add(hash);
    }

    // Method to add a stored message
    public static void addStoredMessage(String message, String id, String hash) {
        storedMessages.add(message);
        messageIDs.add(id);
        messageHashes.add(hash);
    }

    // Method to handle disregarding a message (removes from sent, adds to disregarded)
    public static void disregardMessage(int index) {
        if (index >= 0 && index < sentMessages.size()) {
            String removedMsg = sentMessages.remove(index);
            disregardedMessages.add(removedMsg);
            System.out.println("Message disregarded successfully.");
        } else {
            System.out.println("Invalid message index.");
        }
    }

    // Method to display all stored messages
    public static void displayStoredMessages() {
        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages.");
            return;
        }
        for (int i = 0; i < storedMessages.size(); i++) {
            System.out.println(storedMessages.get(i));
        }
    }

    // Method to find and print the longest stored message
    public static void longestStoredMessage() {
        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages to compare.");
            return;
        }

        String longestMessage = "";
        for (String msg : storedMessages) {
            if (msg.length() > longestMessage.length()) {
                longestMessage = msg;
            }
        }
        System.out.println("Longest stored message: " + longestMessage);
    }

    // Method to search for a message by ID
    public static void searchByID(String id) {
        int index = messageIDs.indexOf(id);
        if (index != -1) {
            System.out.println("Message found: " + sentMessages.get(index));
        } else {
            System.out.println("Message ID not found.");
        }
    }
    
    // Method to display all message hashes
    public static void displayHashes() {
        for (String hash : messageHashes) {
            System.out.println(hash);
        }
    }
}
