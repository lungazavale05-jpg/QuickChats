package chatapp;

import java.util.Scanner;
import java.util.Random;

public class Messages {
    
    static Login log = new Login();
    private static int totalMessagesSent = 0;
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Messages app = new Messages();
        app.part();
    }

    
    private static int readInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            String line = scan.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }


    public static boolean checkMessageLength(String message) {
        return message.length() <= 250;
    }

    
    public static String generateMessageID() {
        Random ran = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(ran.nextInt(10));
        }
        return id.toString();
    }

    public static String generateMessageHash(String messageID, int messageNumber, String messageText) {
        String firstTwoID = messageID.substring(0, 2);
        String trimmed = messageText.trim();
        
        if (trimmed.isEmpty()) {
            return firstTwoID + ":" + messageNumber + ":";
        }
        
        String[] words = trimmed.split("\\s+");
        String combinedWords = (words[0] + words[words.length - 1]).toUpperCase();
        return firstTwoID + ":" + messageNumber + ":" + combinedWords;
    }

    public void part() {
        int option;
        do {
            System.out.println("\nWelcome to QuickChat");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");

            option = readInt("Choose an option: ");

            if (option == 1) {
                sendMessages();
            } else if (option == 2) {
                System.out.println("Coming soon");
            } else if (option == 3) {
                System.out.println("Thanks for using QuickChat");
            } else {
                System.out.println("Error!! Invalid input");
            }
        } while (option != 3);
    }

    public static void sendMessages() {
        int n = readInt("How many messages do you want to send: ");
        if (n <= 0) {
            System.out.println("Number of messages must be greater than 0.");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Message " + (i + 1) + " of " + n + " ---");

            String recNo;
            while (true) {
                System.out.println("Enter recipient cell number: ");
                recNo = scan.nextLine().trim();
                if (log.checkCellPhoneNumber(recNo)) {
                    break;
                } else {
                    System.out.println("Invalid recipient number format! Must start with +27 followed by 9 digits.");
                }
            }

            String messageText;
            while (true) {
                System.out.println("Enter message: ");
                messageText = scan.nextLine();
                
                if (!checkMessageLength(messageText)) {
                    System.out.println("Please enter a message of 250 characters or less.");
                } else if (messageText.trim().isEmpty()) {
                    System.out.println("Message cannot be empty.");
                } else {
                    break;
                }
            }

            System.out.println("\nChoose an option:");
            System.out.println("1) Send Message");
            System.out.println("2) Disregard Message");
            System.out.println("3) Store Message to send later");
            int choice = readInt("Enter choice (1-3): ");

            if (choice == 1) {
                totalMessagesSent++;
                String messageID = generateMessageID();
                String messageHash = generateMessageHash(messageID, totalMessagesSent, messageText);

                System.out.println("Message successfully sent");
                System.out.println("Message ID: " + messageID);
                System.out.println("Message Hash: " + messageHash);
                System.out.println("Recipient: " + recNo);
                System.out.println("Message: " + messageText);

            } else if (choice == 2) {
                System.out.println("Press 0 to delete the message: ");
                String confirm = scan.nextLine().trim();
                if (confirm.equals("0")) {
                    System.out.println("Message deleted.");
                } else {
                    System.out.println("Message not deleted.");
                }
            } else if (choice == 3) {
                System.out.println("Message successfully stored");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        System.out.println("\n====");
        System.out.println("Total messages processed/sent: " + totalMessagesSent);
        System.out.println("====");
    }
}
