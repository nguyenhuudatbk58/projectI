package Domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sach_muon")
public class SachMuon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ma_phieu_id", referencedColumnName = "id")
	private PhieuMuon phieuMuon;

	@Column(name = "ma_sach", nullable = false)
	private String maSach;

	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_muon", nullable = false)
	private Date ngayMuon;

	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_tra", nullable = false)
	private Date ngayTra;

	public SachMuon() {

	}

	public SachMuon(PhieuMuon phieuMuon, String maSach, Date ngayMuon, Date ngayTra) {
		super();
		this.phieuMuon = phieuMuon;
		this.maSach = maSach;
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PhieuMuon getPhieuMuon() {
		return phieuMuon;
	}

	public void setPhieuMuon(PhieuMuon phieuMuon) {
		this.phieuMuon = phieuMuon;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public Date getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

}
