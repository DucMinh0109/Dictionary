package TuDienTiengAnh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dictionary dict = new Dictionary(); // Khởi tạo từ điển mới
        DictionaryManagement dictManager = new DictionaryManagement(dict); // Quản lý từ điển
        DictionaryCommandLine dictCmd = new DictionaryCommandLine(dictManager); // Giao diện dòng lệnh cho từ điển

        Scanner scanner = new Scanner(System.in); // Scanner để đọc input từ bàn phím
        boolean exit = false; // Biến để kiểm soát việc thoát khỏi vòng lặp

        while (!exit) {
            System.out.println("\nChào mừng bạn đến với Ứng dụng Từ điển!");
            System.out.println("[0] Thoát");
            System.out.println("[1] Thêm Từ");
            System.out.println("[2] Xóa từ");
            System.out.println("[3] Sửa từ");
            System.out.println("[4] Hiển thị danh sách các từ");
            System.out.println("[5] Tra cứu");
            System.out.println("[6] Tìm kiếm");
            System.out.println("[7] Nhập danh sách từ vựng từ tệp");
            System.out.println("[8] Xuất dữ liệu danh sách từ vựng ra tệp");
            System.out.print("Hãy chọn hành động: ");

            int choice = scanner.nextInt(); // Đọc lựa chọn của người dùng
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 0:
                    exit = true; // Nếu chọn 0, sẽ thoát khỏi vòng lặp
                    break;
                case 1:
                    dictCmd.dictionaryBasic(1);
                    break;
                case 4:
                	dictCmd.dictionaryBasic(4); // Gọi phương thức thêm từ mới và hiển thị tất cả từ
                    break;
                default:
                    System.out.println("Hành động không được hỗ trợ"); // Nếu nhập không đúng
                    break;
            }
        }
        scanner.close(); // Đóng scanner sau khi thoát khỏi vòng lặp
    }
}
