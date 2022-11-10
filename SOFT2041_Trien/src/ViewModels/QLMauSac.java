/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLMauSac {

    private UUID id;
    private String ma;
    private String ten;

    public QLMauSac() {
    }

    public QLMauSac(UUID id) {
        this.id = id;
    }

    public QLMauSac(UUID id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public QLMauSac(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public QLMauSac(UUID id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "MauSac{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{id, ma, ten};
    }
}
