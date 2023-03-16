package model;

public class students {
    private long ma;
    private String ten;
    private String gioitinh;
    private String ngaysinh;
    private String diachi;
    private String sdt;
    private String email;
    private double GPA;

    public students() {
    }

    public students(long ma, String ten, String gioitinh, String ngaysinh, String diachi, String sdt, String email, double GPA) {
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.GPA = GPA;
    }

    public students(String ten, String gioitinh, String ngaysinh, String diachi, String sdt, String email, double GPA) {
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.GPA = GPA;
    }

    public long getMa() {
        return ma;
    }

    public void setMa(long ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "students[" +
                "ma=" + ma +
                ", ten='" + ten + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                ", ngaysinh='" + ngaysinh + '\'' +
                ", diachi='" + diachi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", email='" + email + '\'' +
                ", GPA=" + GPA +
                ']';
    }
}
