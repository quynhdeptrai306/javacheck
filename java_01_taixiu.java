package taixiu;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class java_01_taixiu {
	public static void main(String[] args) {
		double naptien=0;
		double taiKhoanNguoiChoi = 0;
		Scanner sc=new Scanner(System.in);
		Locale lca= new Locale("vi", "VN");
		NumberFormat numf= NumberFormat.getCurrencyInstance(lca);
		int lc=0;
		do {
			System.out.println("------MỜI BẠN LỰA CHỌN------");
			System.out.println("1. Nạp tiền: ");
			System.out.println("2. Tiếp tục chơi");
			System.out.println("0. Thoát trò chơi");
			lc=sc.nextInt();
			if(lc==1) {
				System.out.println("Nhập lệnh nạp tiền: ");
				naptien=sc.nextDouble();
				taiKhoanNguoiChoi+=naptien;
			}
			if(lc==2) {
				System.out.println("Bắt đầu đặt cược.");
				System.out.println("Số tiền hiện có "+numf.format(taiKhoanNguoiChoi)+" ,bạn muốn đặt cược bao nhiêu ?");
				// dat cuoc
				double soTienDatCuoc=0;
				do {
					System.out.println("Nhập số tiền đặt cược: ");
					soTienDatCuoc=sc.nextDouble();
					if(soTienDatCuoc>taiKhoanNguoiChoi)
						System.out.println("số dư không đủ để đặt cược");
				} while (soTienDatCuoc<=0 || soTienDatCuoc>taiKhoanNguoiChoi);
				// lua chon tai xiu
				int luaChonTX=0;
				do {
					System.out.println("1.Tài - 2.Xỉu: Mời bạn lựa chọn: ");
					luaChonTX=sc.nextInt();
				} while (luaChonTX!=2 && luaChonTX!=1);
				// xuc xac
				Random xucxac=new Random();
				int giatri1=xucxac.nextInt(5)+1;
				int giatri2=xucxac.nextInt(5)+1;
				int giatri3=xucxac.nextInt(5)+1;
				int tong=giatri1+giatri2+giatri3;
				System.out.println("Kết quả tung xúc xắc la :"+giatri1+"-"+giatri2+"-"+giatri3);
				
				// ket qua
				if(tong==3&&tong==18) {
					System.out.println("Tổng là: "+tong+" bạn đã thua.");
					taiKhoanNguoiChoi=taiKhoanNguoiChoi-soTienDatCuoc;
					System.out.println("Số tiền hiện có: "+numf.format(taiKhoanNguoiChoi));
				}
				else if (tong>3&&tong<11) {
					System.out.println("Tổng là: "+tong+". Kết quả: Xỉu");
					if(luaChonTX==2) {
						System.out.println("Chúc mừng bạn đã thắng");
						taiKhoanNguoiChoi=taiKhoanNguoiChoi+soTienDatCuoc*0.95;
						System.out.println("Số tiền hiện có: "+numf.format(taiKhoanNguoiChoi));
					}
					else {
						System.out.println("Chúc mừng bạn đã thua");
						taiKhoanNguoiChoi=taiKhoanNguoiChoi-soTienDatCuoc;
						System.out.println("Số tiền hiện có: "+numf.format(taiKhoanNguoiChoi));
					}
				}
				else{
					System.out.println("Tổng là: "+tong+" kết quả: Tài");
					if(luaChonTX==1) {
						System.out.println("Chúc mừng bạn đã thắng");
						taiKhoanNguoiChoi=taiKhoanNguoiChoi+soTienDatCuoc*0.95;
						System.out.println("Số tiền hiện có: "+numf.format(taiKhoanNguoiChoi));
					}
					else {
						System.out.println("Chúc mừng bạn đã thua");
						taiKhoanNguoiChoi=taiKhoanNguoiChoi-soTienDatCuoc;
						System.out.println("Số tiền hiện có: "+numf.format(taiKhoanNguoiChoi));
					}
				}
			}
			
		}while(lc!=0);
	}
}
