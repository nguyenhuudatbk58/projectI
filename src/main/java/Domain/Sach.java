package Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "sach", uniqueConstraints = { @UniqueConstraint(columnNames = "ma_sach") })
public class Sach {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "ten", nullable = false)
	private String ten;

	@Column(name = "ma_sach", nullable = false)
	private String maSach;

	@Column(name = "tac_gia", nullable = false)
	private String tacGia;

	@Column(name = "nha_xuat_ban", nullable = false)
	private String nhaXuatBan;

	@Column(name = "gia", nullable = false)
	private String gia;

	@Column(name = "chu_de", nullable = false)
	private String chuDe;

	@Column(name = "ngay_nhap", nullable = false)
	private Date ngayThem;

	public Sach(String ten, String maSach, String tacGia, String nhaXuatBan, String gia, String chuDe, Date ngayThem) {
		super();
		this.ten = ten;
		this.maSach = maSach;
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.gia = gia;
		this.chuDe = chuDe;
		this.ngayThem = ngayThem;
	}

	public Sach() {

	}

	public Date getNgayThem() {
		return ngayThem;
	}

	public void setNgayThem(Date ngayThem) {
		this.ngayThem = ngayThem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String getChuDe() {
		return chuDe;
	}

	public void setChuDe(String chuDe) {
		this.chuDe = chuDe;
	}

}
