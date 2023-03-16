package dao;
import model.students;
import connection.myConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class studentDao {

    public List<students> getAll() {
        List<students> studentsList = new ArrayList<>();
        // Bước 1: tạo kết nối
        // Bước 2: chuẩn bị câu lệnh
        // Bước 3: thực thi
        // Bước 4: đóng kết nối

        try {
            Connection conn = myConnection.getConnection();
            final String sql = "SELECT * FROM students";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                students s = new students();
                s.setMa(rs.getLong("ma"));
                s.setTen(rs.getString("ten"));
                s.setGioitinh(rs.getString("gioitinh"));
                s.setNgaysinh(rs.getString("ngaysinh"));
                s.setDiachi(rs.getString("diachi"));
                s.setSdt(rs.getString("sdt"));
                s.setEmail(rs.getString("email"));

                studentsList.add(s);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    public students getById(long ma) {
        final String sql = "SELECT * FROM `students` WHERE  `ma` = " + ma;
        students s = null;

        try {
            Connection conn = myConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                s = new students();
                s.setMa(rs.getLong("ma"));
                s.setTen(rs.getString("ten"));
                s.setGioitinh(rs.getString("gioitinh"));
                s.setNgaysinh(rs.getString("ngaysinh"));
                s.setDiachi(rs.getString("diachi"));
                s.setSdt(rs.getString("sdt"));
                s.setEmail(rs.getString("email"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public void insert(students s) {
        final String sql = String.format("INSERT INTO `students` (`ma`,`ten`,`gioitinh`,`ngaysinh`,`diachi`,`sdt`,`email`,`GPA`) VALUES ('%d','%s','%s','%s','%s','%s','%s','%f')",
                s.getMa(),
                s.getTen(),
                s.getGioitinh(),
                s.getNgaysinh(),
                s.getDiachi(),
                s.getSdt(),
                s.getEmail(),
                s.getGPA()
        );

        try {
            Connection conn = myConnection.getConnection();
            Statement stmt = conn.createStatement();

            int rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Thêm thất bại!");
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void update(students s, long ma) {
        students tmp = getById(ma);
        if (tmp == null) {
            System.out.println("Không tồn tại nhân viên có id = " + ma);
            return;
        }
        final String sql = String.format("UPDATE `students` SET `ten` = '%s', `gioitinh`= '%d' ,`ngaysinh`='%s',`diachi`='%s',`sdt`='%s',`email`='%s',`GPA`='%f' WHERE `ma`='%d' ",
                s.getTen(),
                s.getGioitinh(),
                s.getNgaysinh(),
                s.getDiachi(),
                s.getSdt(),
                s.getEmail(),
                s.getGPA(),
                ma
        );
    }
    public void delete(long ma) {
        try {
            Connection conn = myConnection.getConnection();
            final String sql =  String.format("DELETE FROM students WHERE ma = '%d'", ma);

            Statement stmt = conn.createStatement();

            long rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}
