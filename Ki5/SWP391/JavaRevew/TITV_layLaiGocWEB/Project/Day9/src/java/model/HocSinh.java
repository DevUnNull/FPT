package model;


public class HocSinh {
    private String ten;
    private int tuoi;
    private String lop;

    public HocSinh(String ten, int tuoi, String lop) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.lop = lop;
    }

    public String getTen() { return ten; }
    public int getTuoi() { return tuoi; }
    public String getLop() { return lop; }
}