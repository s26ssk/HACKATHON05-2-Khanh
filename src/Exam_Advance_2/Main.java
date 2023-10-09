package Exam_Advance_2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> wordStack = new Stack<>();

        int choice;
        String inputText = "";

        do {
            System.out.println("**************** JAVA-HACKATHON-05-ADVANCE-1-MENU ****************");
            System.out.println("1. Nhập câu");
            System.out.println("2. Đảo ngược câu");
            System.out.println("3. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập câu: ");
                    inputText = scanner.nextLine();
                    break;
                case 2:
                    if (!inputText.isEmpty()) {
                        String[] words = inputText.split(" ");
                        for (String word : words) {
                            wordStack.push(word);
                        }

                        System.out.print("Câu sau khi đảo ngược: ");
                        while (!wordStack.isEmpty()) {
                            System.out.print(wordStack.pop() + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Chưa nhập câu.");
                    }
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 3);
    }
}
