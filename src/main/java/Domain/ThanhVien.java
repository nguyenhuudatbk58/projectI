package Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "thanh_vien", uniqueConstraints = { @UniqueConstraint(columnNames = "ma_thanh_vien"),
		@UniqueConstraint(columnNames = "email") })
public class ThanhVien {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "ten", nullable = false)
	private String ten;

	@Column(name = "ma_thanh_vien", nullable = false)
	private String maThanhVien;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "dia_chi", nullable = false)
	private String diaChi;

	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_tham_gia", nullable = false)
	private Date ngay_tham_gia;

	public ThanhVien() {

	}

	public ThanhVien(String ten, String maThanhVien, String email, String diaChi, Date ngay_tham_gia) {
		super();
		this.ten = ten;
		this.maThanhVien = maThanhVien;
		this.email = email;
		this.diaChi = diaChi;
		this.ngay_tham_gia = ngay_tham_gia;
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

	public String getMaThanhVien() {
		return maThanhVien;
	}

	public void setMaThanhVien(String maThanhVien) {
		this.maThanhVien = maThanhVien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Date getNgay_tham_gia() {
		return ngay_tham_gia;
	}

	public void setNgay_tham_gia(Date ngay_tham_gia) {
		this.ngay_tham_gia = ngay_tham_gia;
	}

}
