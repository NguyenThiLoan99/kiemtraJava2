import dao.studentDao;
import model.students;
import java.util.List;
import java.util.Scanner;

public class main {
    private static studentDao studentDao = new studentDao();

    private static void mainMenu(){
        System.out.println("-------QUẢN LÝ SINH VIÊN");
        System.out.println("1.Danh sách sinh viên theo bảng ");
        System.out.println("2.Nhap mot sinh vien mới ");
        System.out.println("3.Xóa 1 sinh viên theo mã ");
        System.out.println("4. Cập nhật thông tin sinh viên ");
        System.out.println("5. Tìm 1 sinh viên theo họ tên hoặc mã(gần đúng) ");
        System.out.println("6.Sắp xếp sinh viên theo điểm số GPA tăng dần ");
        System.out.println("7. In ra tất cả các sinh viên nữ ở HÀ Nội có GPA trên 2.5");
        System.out.println("8. Sắp xếp sinh viên theo họ tên, sắp xếp theo bảng chữ cái abc");
    }

    private static void option1(){
            List<students> studentList = studentDao.getAll();
            System.out.printf("%-20s %-20s %-20s %-20s", "MÃ sinh viên", "Họ tên", "Giới tính", "Địa chỉ");
            System.out.println();
            for (int i = 0; i < studentList.size(); i++) {
                students s = studentList.get(i);
                System.out.printf("%-20d %-20s %-20s %-20s\n", (i+1), s.getTen(), s.getGioitinh(),s.getDiachi());
            };
        }

    private static void option2(Scanner in){
        students s = new students();
        System.out.print("\t nhập id sinh viên: ");
        s.setMa((long) Integer.parseInt(in.nextLine()));
        System.out.print("\tNhap ten:");
        s.setTen(in.nextLine());
        System.out.print("\t nhập giới tính: ");
        s.setGioitinh(in.nextLine());
        System.out.print("\tNhap ngay sinh:");
        s.setNgaysinh(in.nextLine());
        System.out.print("\tNhap dia chi:");
        s.setDiachi(in.nextLine());
        System.out.print("\tNhap sdt :");
        s.setSdt(in.nextLine());
        System.out.print("\tNhap email:");
        s.setEmail(in.nextLine());
        System.out.print("\tNhap điểm GPA:");
        s.setGPA(in.nextDouble());

        studentDao.insert(s);
        System.out.println("thêm thành công");

    }

    private static void option3(Scanner in) {
        students s = new students();
        System.out.print("Nhập id muốn xóa:");
        long ma= in.nextLong();
        studentDao.delete(ma);
    }
    private static void option4 (Scanner in){
        students s = new students();
        System.out.print("Nhập id sinh vien cần cập nhật : ");
        long ma = (long) Integer.parseInt(in.nextLine());
        students tmp = studentDao.getById(ma);
        if(tmp == null){
            System.out.println("không cO sinh vien nay");
            return;
        }
        System.out.print("\tNhap ten:");
        s.setTen(in.nextLine());
        System.out.print("\t nhập giới tính: ");
        s.setGioitinh(in.nextLine());
        System.out.print("\tNhap ngay sinh:");
        s.setNgaysinh(in.nextLine());
        System.out.print("\tNhap dia chi:");
        s.setDiachi(in.nextLine());
        System.out.print("\tNhap sdt :");
        s.setSdt(in.nextLine());
        System.out.print("\tNhap email:");
        s.setEmail(in.nextLine());
        System.out.print("\tNhap điểm GPA:");
        s.setGPA(in.nextDouble());
        studentDao.update(s, ma);
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int option = -1;

        do {
            mainMenu();
            System.out.print("Nhập lựa chọn: ");
            try {
                option = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập sai định dạng!");
                continue;
            }
            if (option < 1 || option > 8) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }
                switch (option) {
                    case 1:
                        option1();
                        break;
                    case 2:
                        option2(in);
                        break;
                    case 3:
                        option3(in);
                        break;
                    case 4:
                        option4(in);
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                }

            }

            while (option != 0) ;
            in.close();

    }
}
