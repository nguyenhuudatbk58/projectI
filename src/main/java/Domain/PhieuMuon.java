package Domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "phieu_muon", uniqueConstraints = { @UniqueConstraint(columnNames = "ma_phieu"),
		@UniqueConstraint(columnNames = "ma_thanh_vien") })
public class PhieuMuon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "ma_phieu", nullable = false)
	private String maPhieu;

	@Column(name = "ma_thanh_vien", nullable = false)
	private String maThanhVien; // nguoi muon sach

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "phieuMuon", fetch = FetchType.LAZY)
	private Set<SachMuon> sachMuon = new HashSet<SachMuon>();

	public PhieuMuon() {

	}

	public PhieuMuon(String maPhieu, String maThanhVien, Set<SachMuon> sachMuon) {
		super();
		this.id = id;
		this.maPhieu = maPhieu;
		this.maThanhVien = maThanhVien;
		this.sachMuon = sachMuon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}

	public String getMaThanhVien() {
		return maThanhVien;
	}

	public void setMaThanhVien(String maThanhVien) {
		this.maThanhVien = maThanhVien;
	}

	public Set<SachMuon> getSachMuon() {
		return sachMuon;
	}

	public void setSachMuon(SachMuon sachMuon) {
		this.sachMuon.add(sachMuon);
		sachMuon.setPhieuMuon(this);
	}

	public void setSachMuon(Set<SachMuon> sachMuon) {
		this.sachMuon = sachMuon;
		Iterator iterator = (Iterator) sachMuon.iterator();

		while (iterator.hasNext()) {
			SachMuon sm = (SachMuon) iterator.next();
			sm.setPhieuMuon(this);
		}
	}

}
