package Capnhat.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Capnhat.Controller.PhieuMuon.AddCouponController;
import Capnhat.Controller.Sach.AddBookController;
import Capnhat.Controller.Sach.DeleteBookController;
import Capnhat.Controller.Sach.EditBookController;
import Capnhat.Controller.ThanhVien.AddMemberController;
import Capnhat.Controller.ThanhVien.DeleteMemberController;
import Capnhat.Controller.ThanhVien.EditMemberController;
import Capnhat.view.CapnhatView;
import Capnhat.view.PhieuMuon.AddCouponView;
import Capnhat.view.PhieuMuon.DeleteCouponView;
import Capnhat.view.Sach.AddBookView;
import Capnhat.view.Sach.DeleteBookView;
import Capnhat.view.Sach.EditBookView;
import Capnhat.view.ThanhVien.AddMemberView;
import Capnhat.view.ThanhVien.DeleteMemberView;
import Capnhat.view.ThanhVien.EditMemberView;
import DAO.PhieuMuonDAO;
import DAO.SachDAO;
import DAO.ThanhVienDAO;
import Domain.PhieuMuon;
import Domain.Sach;
import Domain.SachMuon;
import Domain.ThanhVien;

public class CapnhatController {

	private CapnhatView capnhatView;

	public CapnhatController(CapnhatView capnhatView) {
		this.capnhatView = capnhatView;

		this.capnhatView.setSelectionSubjectComboBox(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String subject = CapnhatController.this.capnhatView.getSelectedSubject();
				if (subject.equals("Sách")) {
					JTable bookTable = CapnhatController.this.capnhatView.getMyTable();
					javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(null,
							new String[] { "STT ", "Tên sách", "Mã sách", "Tác giả", "Nhà xuất bản", "Giá ", "Chủ đề",
									"Ngày nhập" }) {
						public Class getColumnClass(int column) {
							if (column == 0 || column == 5) {
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
				} else if (subject.equals("Thành viên")) {
					JTable memberTable = CapnhatController.this.capnhatView.getMyTable();
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

				} else if (subject.equals("Phiếu mượn")) {

					JTable couponTable = CapnhatController.this.capnhatView.getMyTable();
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

				}
			}

		});

		this.capnhatView.setAddButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String selectedSubject = CapnhatController.this.capnhatView.getSelectedSubject();
				if (selectedSubject.equals("Sách")) {
					new AddBookController(new AddBookView(), CapnhatController.this.capnhatView.getMyTable());
				} else if (selectedSubject.equals("Thành viên")) {
					new AddMemberController(new AddMemberView(), CapnhatController.this.capnhatView.getMyTable());
				} else if (selectedSubject.equals("Phiếu mượn")) {
					new AddCouponController(new AddCouponView(), CapnhatController.this.capnhatView.getMyTable());

				}
			}

		});

		this.capnhatView.setUpdateButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedSubject = CapnhatController.this.capnhatView.getSelectedSubject();
				if (selectedSubject.equals("Sách")) {

					JTable bookTable = CapnhatController.this.capnhatView.getMyTable();
					int selectedRow = bookTable.getSelectedRow();
					if (selectedRow == -1)
						JOptionPane.showMessageDialog(null, "Chọn sách cần chỉnh sửa.");
					else {

						SimpleDateFormat dateFormat = new SimpleDateFormat("dd--MM--yyyy");

						Sach book = new Sach();
						String bookCode = (String) bookTable.getValueAt(selectedRow, 2);
						book.setTen((String) bookTable.getValueAt(selectedRow, 1));
						book.setMaSach((String) bookTable.getValueAt(selectedRow, 2));
						book.setTacGia((String) bookTable.getValueAt(selectedRow, 3));
						book.setNhaXuatBan((String) bookTable.getValueAt(selectedRow, 4));
						book.setGia((Integer) bookTable.getValueAt(selectedRow, 5));
						book.setChuDe((String) bookTable.getValueAt(selectedRow, 6));
						book.setNgayThem((Date) bookTable.getValueAt(selectedRow, 7));
						book.setId(SachDAO.getIdByBookCode(bookCode));

						new EditBookController(new EditBookView(), book,
								CapnhatController.this.capnhatView.getMyTable());
					}
				} else if (selectedSubject.equals("Thành viên")) {
					JTable memberTable = CapnhatController.this.capnhatView.getMyTable();
					int selectedRow = memberTable.getSelectedRow();
					if (selectedRow == -1)
						JOptionPane.showMessageDialog(null, "Chọn thành viên cần chỉnh sửa.");
					else {

						ThanhVien member = new ThanhVien();
						String memberCode = (String) memberTable.getValueAt(selectedRow, 2);
						member.setTen((String) memberTable.getValueAt(selectedRow, 1));
						member.setMaThanhVien((String) memberTable.getValueAt(selectedRow, 2));
						member.setEmail((String) memberTable.getValueAt(selectedRow, 3));
						member.setDiaChi((String) memberTable.getValueAt(selectedRow, 4));
						member.setNgay_tham_gia((Date) memberTable.getValueAt(selectedRow, 5));
						member.setId(ThanhVienDAO.getIdByMemberCode(memberCode));
						new EditMemberController(new EditMemberView(), member,
								CapnhatController.this.capnhatView.getMyTable());
					}

				} else if (selectedSubject.equals("Phiếu mượn")) {

				}

			}

		});

		this.capnhatView.setDeleteButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedSubject = CapnhatController.this.capnhatView.getSelectedSubject();
				if (selectedSubject.equals("Sách")) {
					JTable bookTable = CapnhatController.this.capnhatView.getMyTable();
					int selectedRow = bookTable.getSelectedRow();
					if (selectedRow == -1)
						JOptionPane.showMessageDialog(null, "Chọn sách cần xóa.");
					else {
						Sach book = new Sach();
						String bookCode = (String) bookTable.getValueAt(selectedRow, 2);
						book.setTen((String) bookTable.getValueAt(selectedRow, 1));
						book.setMaSach((String) bookTable.getValueAt(selectedRow, 2));
						book.setTacGia((String) bookTable.getValueAt(selectedRow, 3));
						book.setNhaXuatBan((String) bookTable.getValueAt(selectedRow, 4));
						book.setGia((Integer) bookTable.getValueAt(selectedRow, 5));
						book.setChuDe((String) bookTable.getValueAt(selectedRow, 6));
						book.setNgayThem((Date) bookTable.getValueAt(selectedRow, 7));
						book.setId(SachDAO.getIdByBookCode(bookCode));
						new DeleteBookController(new DeleteBookView(), book,
								CapnhatController.this.capnhatView.getMyTable());
					}

				} else if (selectedSubject.equals("Thành viên")) {
					JTable memberTable = CapnhatController.this.capnhatView.getMyTable();
					int selectedRow = memberTable.getSelectedRow();
					if (selectedRow == -1)
						JOptionPane.showMessageDialog(null, "Chọn thành viên cần xóa.");
					else {
						ThanhVien member = new ThanhVien();
						String memberCode = (String) memberTable.getValueAt(selectedRow, 2);
						member.setTen((String) memberTable.getValueAt(selectedRow, 1));
						member.setMaThanhVien((String) memberTable.getValueAt(selectedRow, 2));
						member.setEmail((String) memberTable.getValueAt(selectedRow, 3));
						member.setDiaChi((String) memberTable.getValueAt(selectedRow, 4));
						member.setNgay_tham_gia((Date) memberTable.getValueAt(selectedRow, 5));
						member.setId(ThanhVienDAO.getIdByMemberCode(memberCode));
						new DeleteMemberController(new DeleteMemberView(), member,
								CapnhatController.this.capnhatView.getMyTable());
					}

				} else if (selectedSubject.equals("Phiếu mượn")) {
					JTable couponTable = CapnhatController.this.capnhatView.getMyTable();
					int selectedRow = couponTable.getSelectedRow();
					if (selectedRow == -1)
						JOptionPane.showMessageDialog(null, "Chọn phiếu mượn cần xóa.");
					else {
						String couponCode = (String) couponTable.getValueAt(selectedRow, 1);
						String memberCode = (String) couponTable.getValueAt(selectedRow, 2);
						PhieuMuonDAO pmd = null;
						SachDAO sachDAO = null;
						PhieuMuon pm = pmd.getByCouponCode(couponCode);
						Set<SachMuon> sms = pm.getSachMuon();

						Iterator iterator = sms.iterator();
						DefaultTableModel model = new DefaultTableModel(null,
								new String[] { "Tên sách", "Mã sách", "Giá", "Ngày mượn", "Ngày trả" });
						int gia = 0;
						Vector<Object> v1 = null;
						String bookCode = null;
						int prepayMoney = 0;
						while (iterator.hasNext()) {
							v1 = new Vector<Object>();
							SachMuon sm = (SachMuon) iterator.next();
							bookCode = sm.getMaSach();
							v1.add(sachDAO.getNameByBookCode(bookCode));
							v1.add(bookCode);
							gia = sachDAO.getCostByBookCode(sm.getMaSach());
							v1.add(gia);
							v1.add(sm.getNgayMuon());
							v1.add(sm.getNgayTra());
							prepayMoney += gia;
							model.addRow(v1);
						}

						ThanhVienDAO tvd = null;
						String memberName = tvd.getMemberNameByMemberCode(memberCode);
						prepayMoney = (prepayMoney / 10) * 7;
						new DeleteCouponView(couponCode, memberName, memberCode, prepayMoney, model,
								CapnhatController.this);
					}

				}

			}

		});
	}

	public void loadCoupon() {
		JTable couponTable = CapnhatController.this.capnhatView.getMyTable();
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
	}
}
