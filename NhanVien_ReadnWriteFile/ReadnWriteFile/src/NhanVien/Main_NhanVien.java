package NhanVien;
import java.util.*;
import java.io.*;
public class Main_NhanVien 
{
	public static void Menu()
	{
		System.out.print("=========== MENU ==========\n");
		System.out.print("1. Them nhan vien\n");
		System.out.print("2. Tim nhan vien co ma so\n");
		System.out.print("3. Xuat danh sach nhan vien\n");
		System.out.print("0. Thoat\n");
		System.out.print("===========================\n");
	}
	public static void main(String[] args) 
	{	
		Scanner sc = new Scanner(System.in);
		ArrayList<NhanVien> NV = new ArrayList<>();
		String temp, n = "";
		int i = 0;
		try 
		{
			FileReader fr = new FileReader("nhanvien.txt");
			BufferedReader br = new BufferedReader(fr);
			while(br.ready())
			{
				//System.out.println(br.readLine());
				int countspace = 0;
				temp = br.readLine();		
				NhanVien nv = new NhanVien();
				for(i = 0; i < temp.length(); i++)
				{
					if(temp.charAt(i) != ' ')
					{
						n = n + temp.charAt(i);
					}
					else
					{
						countspace++;
						if(countspace == 1)
							nv.setMaSo(n);
						if(countspace == 2)
							nv.setHoTen(n);
						if(countspace == 3)
						{
							int j = Integer.parseInt(n);
							nv.setAge(j);
						}
						n = "";
					}					
				}				
				if(i == temp.length())
				{
					float k = Float.parseFloat(n);
					nv.setLuong(k);
					n = "";
				}
				NV.add(nv);
			}
			FileWriter fw = new FileWriter("nhanvien.txt",true);
			Menu();
			int choose = 1;
			while(choose != 0)
			{
				System.out.print("\nNhap lua chon: ");
				choose = sc.nextInt();
				while(choose > 3 || choose < 0)
				{
					System.out.print("\nNhap lai lua chon: ");
					choose = sc.nextInt();
				}
				switch(choose)
				{
				case 1:
					System.out.print("*** Them nhan vien\n");
					System.out.print("So nhan vien them vao: ");
					int n1;
					n1 = sc.nextInt();
					for (int t1 = 0; t1 < n1; t1++)
					{
						NhanVien nv = new NhanVien();
						nv.NhapNV();
						NV.add(nv);
						fw.write(nv.toString());
					}
					break;
				case 2:
					System.out.print("\n*** Tim Nhan Vien");
					System.out.print("\nNhap ID can tim: ");
					String ID;
					ID = sc.next();
					for(int t = 0; t < NV.size(); t++)
					{
						if( NV.get(t).getMaSo().equals(ID))
							System.out.print("\n" + NV.get(t).toString());
					}
					break;
				case 3:
					System.out.print("\n*** Danh Sach Nhan Vien");
					for(int vt = 0; vt < NV.size(); vt++)
					{
						System.out.print(NV.get(vt).toString());
					}
					break;
				default: choose = 0; break;
				}				
			}			
			fr.close();
			br.close();
			fw.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
