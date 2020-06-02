package NhanVien;

import java.util.*;

public class NhanVien {
	private String MaSo;
	private String HoTen;
	private int Age;
	private double Luong;
	public void setAge(int a)
	{
		this.Age = a;
	}
	public int getAge() 
	{
		return this.Age;
	}
	public void setMaSo(String maSo)
	{
		this.MaSo = maSo;
	}
	public String getMaSo()
	{
		return this.MaSo;
	}
	
	public void setHoTen(String HoTen)
	{
		this.HoTen = HoTen;
	}
	public String getHoTen()
	{
		return this.HoTen;
	}
	public void setLuong(double Luong)
	{
		this.Luong = Luong;
	}
	public double getLuong()
	{
		return this.Luong;
	}
	public double getThuNhap()
	{
		return this.Luong * 12;
	}
	public NhanVien()
	{
    }
	public NhanVien(String MaSo, String HoTen, double Luong, int age)
	{
		this.MaSo = MaSo;
		this.HoTen = HoTen;
		this.Age = age;
		this.Luong = Luong;
	}
	public void NhapNV()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap ma so: ");
		this.MaSo = sc.next();
		System.out.print("\nNhap ho ten: ");
		this.HoTen = sc.next();
		System.out.print("\nNhap tuoi: ");
		this.Age = sc.nextInt();
		System.out.print("\nNhap luong: ");
		this.Luong = sc.nextDouble();
	}
	@Override
	public  String toString()
	{
        return "\n" + getMaSo() + " " + getHoTen() + " " + getAge() + " " + getLuong();
    }

}
