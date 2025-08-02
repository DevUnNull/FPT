package model;

import java.util.Date;

public class KhachHang {
    private int id;
    private String hoVaTen;
    private Date ngaySinh;
    private String diaChi;

    // Constructor mặc định
    public KhachHang() {
    }

    // Constructor đầy đủ tham số
    public KhachHang(int id, String hoVaTen, Date ngaySinh, String diaChi) {
        this.id = id;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}