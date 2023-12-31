package bai2;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class Exam_Advance_2 {
    public static String string = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập câu");
            System.out.println("2. Đảo ngược câu");
            System.out.println("3. Thoát");
            System.out.println();
            System.out.println("Nhập vào lựa chọn của bạn:");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("Nhập vào chuỗi của bạn:");
                    string = sc.nextLine();
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Chuỗi trước khi đảo ngược là:");
                    System.out.println(string);
                    String[] splitStr = string.split(" ");
                    Stack<String> stack = new Stack<>();
                    StringBuilder reverse = new StringBuilder();

                    for (String string : splitStr) {
                        stack.push(string);
                    }

                    System.out.println("Chuỗi sau khi đảo ngược là:");
                    int size = stack.size();
                    for (int i = 0; i < size; i++) {
                        reverse.append(stack.pop()).append(" ");
                    }
                    System.out.println(reverse.toString().trim());
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Bạn đã thoát khỏi chương trình!");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Không có lựa chọn " + choice + ", vui lòng chọn lại!");
                    break;
            }
        }
    }
}
