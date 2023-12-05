package Chatbox;
import java.util.Scanner;

public class Run {
    private static int messageCount;

    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        MyStack<String> stack = new MyStack<>();
        Scanner scanner = new Scanner(System.in);


        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter a message" + i + ": ");
            String message = scanner.nextLine();

            if (message.length() > 250) {
                System.out.println("The message exceeds the 250 character limit:");
                i--;
                continue;
            }
            queue.offer(message);
        }

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        scanner.close();

        System.out.println("\nMessages from the stack:");
        if (stack.size() > 0) {
            while (!stack.isEmpty()) {
                System.out.println("Message: " + stack.pop());
            }
        }
    }
}