package TuDienTiengAnh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dictionary dict = new Dictionary(); // Khởi tạo từ điển mới
        DictionaryManagement dictManager = new DictionaryManagement(dict); // Quản lý từ điển
        DictionaryCommandLine dictCmd = new DictionaryCommandLine(dictManager); // Giao diện dòng lệnh cho từ điển
        dictCmd.dictionaryAdvanced();
        Scanner scanner = new Scanner(System.in); // Scanner để đọc input từ bàn phím
        boolean exit = false; // Biến để kiểm soát việc thoát khỏi vòng lặp

        while (!exit) {
            System.out.println("\nWelcome to My Application!");
            System.out.println("[0] Exit");
            System.out.println("[1] Add");
            System.out.println("[2] Remove");
            System.out.println("[3] Update");
            System.out.println("[4] Display");
            System.out.println("[5] Lookup");
            System.out.println("[6] Search");
            System.out.println("[7] Import form file");
            System.out.println("[8] Export to file");
            System.out.print("Your action: ");

            int choice = scanner.nextInt(); // Đọc lựa chọn của người dùng
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 0:
                    exit = true; // Nếu chọn 0, sẽ thoát khỏi vòng lặp
                    break;
                case 1:
                    dictCmd.dictionaryAdvanced();
                    break;
                case 2:
                    dictCmd.dictionaryAdvanced();
                    break;
                case 3:
                    dictCmd.dictionaryAdvanced();
                    break;
                case 4:
                    dictCmd.dictionaryAdvanced();
                    break;
                case 5:
                    dictCmd.dictionaryAdvanced();
                    break;
                case 6:
                    dictCmd.dictionaryAdvanced();
                    break;
                case 7:
                    dictCmd.dictionaryAdvanced();
                    break;
                case 8:
                    dictCmd.dictionaryAdvanced();
                    break;
                default:
                    System.out.println("Action not supported"); // Nếu nhập không đúng
                    break;
            }
        }
        scanner.close(); // Đóng scanner sau khi thoát khỏi vòng lặp
    }
}
