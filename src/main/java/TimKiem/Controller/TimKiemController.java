package TimKiem.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO.PhieuMuonDAO;
import DAO.SachDAO;
import DAO.ThanhVienDAO;
import Domain.PhieuMuon;
import Domain.Sach;
import Domain.ThanhVien;
import TimKiem.View.TimKiemView;

public class TimKiemController {

	private TimKiemView timKiemView;

	private TableRowSorter<TableModel> sorter;

	public TimKiemController(TimKiemView timKiemView) {
		super();
		this.timKiemView = timKiemView;

		this.timKiemView.setSubjectComboBoxListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String subject = TimKiemController.this.timKiemView.getSelectedSubject();
				if (subject.equals("Sách")) {
					JTable bookTable = TimKiemController.this.timKiemView.getMyTable();
					javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(null,
							new String[] { "STT ", "Tên sách", "Mã sách", "Tác giả", "Nhà xuất bản", "Giá ", "Chủ đề",
									"Ngày nhập" }) {
						public Class getColumnClass(int column) {
							if (column == 0) {
								return Integer.class;
							} else if (column == 7) {
								return Date.class;
							} else {
								return String.class;
							}
						}

						public boolean isCellEditable(int row, int col) {
							return false;
						}
					};
					bookTable.setModel(tableModel);
					TableColumn column;
					for (int i = 0; i < bookTable.getColumnCount(); i++) {
						column = bookTable.getColumnModel().getColumn(i);
						if (i == 0) {
							column.setMinWidth(5);
							column.setPreferredWidth(5);
						} else if (i == 1)
							column.setPreferredWidth(150);
						else if (i == 2)
							column.setPreferredWidth(50);
						else if (i == 3)
							column.setPreferredWidth(150);
						else if (i == 4)
							column.setPreferredWidth(150);
						else if (i == 5)
							column.setPreferredWidth(50);
						else if (i == 6)
							column.setPreferredWidth(100);
						else if (i == 7) {
							column.setPreferredWidth(50);
						}
					}
					SachDAO sachDAO = null;
					ArrayList<Sach> books = sachDAO.getAll();

					Vector<Object> v;
					for (int i = 0; i < books.size(); i++) {
						Sach sach = books.get(i);
						v = new Vector<Object>();
						v.add(i + 1);
						v.add(sach.getTen());
						v.add(sach.getMaSach());
						v.add(sach.getTacGia());
						v.add(sach.getNhaXuatBan());
						v.add(sach.getGia());
						v.add(sach.getChuDe());
						v.add(sach.getNgayThem());
						tableModel.addRow(v);
					}
					TimKiemController.this.timKiemView.setSubjectSearchModel(
							new String[] { "Tên sách", "Mã sách", "Nhà xuất bản", "Chủ đề", "Ngày nhập" });
				} else if (subject.equals("Thành viên")) {
					JTable memberTable = TimKiemController.this.timKiemView.getMyTable();
					final javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(null,
							new String[] { "STT ", "Tên thành viên", "Mã thành viên", "Email", "Địa chỉ",
									"Ngày tham gia" }) {
						public Class getColumnClass(int column) {
							if (column == 0) {
								return Integer.class;
							}
							if (column == 5) {
								return Date.class;
							} else {
								return String.class;
							}
						}

						public boolean isCellEditable(int row, int col) {
							return false;
						}
					};
					memberTable.setModel(tableModel);
					TableColumn column;
					for (int i = 0; i < memberTable.getColumnCount(); i++) {
						column = memberTable.getColumnModel().getColumn(i);
						if (i == 0) {
							column.setMinWidth(5);
							column.setPreferredWidth(5);
						} else if (i == 1)
							column.setPreferredWidth(150);
						else if (i == 2)
							column.setPreferredWidth(100);
						else if (i == 3)
							column.setPreferredWidth(150);
						else if (i == 4)
							column.setPreferredWidth(150);
						else if (i == 5)
							column.setPreferredWidth(150);

					}
					System.out.println("in thanh vien ");
					ThanhVienDAO thanhVienDAO = null;
					ArrayList<ThanhVien> members = thanhVienDAO.getAll();

					Vector<Object> v;
					for (int i = 0; i < members.size(); i++) {
						ThanhVien member = members.get(i);
						v = new Vector<Object>();
						v.add(i + 1);
						v.add(member.getTen());
						v.add(member.getMaThanhVien());
						v.add(member.getEmail());
						v.add(member.getDiaChi());
						v.add(member.getNgay_tham_gia());
						tableModel.addRow(v);
					}
					TimKiemController.this.timKiemView.setSubjectSearchModel(
							new String[] { "Tên thành viên", "Mã thành viên", "Email", "Ngày tham gia" });

				} else if (subject.equals("Phiếu mượn")) {

					JTable couponTable = TimKiemController.this.timKiemView.getMyTable();
					javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(null,
							new String[] { "STT ", "Mã phiếu mượn", "Mã thành viên" }) {
						public Class getColumnClass(int column) {
							return String.class;
						}

						public boolean isCellEditable(int row, int col) {
							return false;
						}
					};
					couponTable.setModel(tableModel);
					PhieuMuonDAO phieuMuonDAO = null;
					ArrayList<PhieuMuon> coupons = phieuMuonDAO.getAll();

					Vector<Object> v;
					for (int i = 0; i < coupons.size(); i++) {
						PhieuMuon coupon = coupons.get(i);
						v = new Vector<Object>();
						v.add(i + 1);
						v.add(coupon.getMaPhieu());
						v.add(coupon.getMaThanhVien());
						tableModel.addRow(v);
					}
					TimKiemController.this.timKiemView
							.setSubjectSearchModel(new String[] { "Mã phiếu mượn", "Mã thành viên" });

				}
			}

		});

		this.timKiemView.setSearchButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedSubject = TimKiemController.this.timKiemView.getSelectedSubject();
				String subjectSearch = TimKiemController.this.timKiemView.getSubjectSearch();
				String keySearch = TimKiemController.this.timKiemView.getKeySearch();

				JTable myTable = TimKiemController.this.timKiemView.getMyTable();
				sorter = new TableRowSorter<TableModel>(myTable.getModel());
				myTable.setRowSorter(sorter);

				if (selectedSubject.equals("Sách")) {
					new TimKiemSachController(sorter, keySearch, subjectSearch);

				} else if (selectedSubject.equals("Thành viên")) {
					new TimKiemThanhVienController(sorter, keySearch, subjectSearch);
				} else if (selectedSubject.equals("Phiếu mượn")) {
					new TimKiemPhieuMuonController(sorter, keySearch, subjectSearch);
				}

			}

		});
		this.timKiemView.setRefreshButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable myTable = TimKiemController.this.timKiemView.getMyTable();
				sorter = new TableRowSorter<TableModel>(myTable.getModel());
				myTable.setRowSorter(sorter);
				sorter.setRowFilter(null);
				TimKiemController.this.timKiemView.setKeySearch(null);

			}

		});
	}

}
