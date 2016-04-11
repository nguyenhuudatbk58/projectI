package Capnhat.Controller.ThanhVien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;

import Capnhat.Controller.CapnhatController;
import Capnhat.view.ThanhVien.EditMemberView;
import DAO.ThanhVienDAO;
import Domain.ThanhVien;

public class EditMemberController {
	private ThanhVienDAO thanhVienDAO;

	private EditMemberView editMemberView;

	private JTable table;

	public EditMemberController(EditMemberView editMemberView, final ThanhVien thanhVien, JTable table) {
		this.editMemberView = editMemberView;
		this.table = table;
		displayMemberInfo(thanhVien);

		this.editMemberView.setEditButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thanhVien.setTen(EditMemberController.this.editMemberView.getTen());
				thanhVien.setMaThanhVien(EditMemberController.this.editMemberView.getMaThanhVien());
				thanhVien.setEmail(EditMemberController.this.editMemberView.getEmail());
				thanhVien.setDiaChi(EditMemberController.this.editMemberView.getDiaChi());

				thanhVienDAO.updateById(thanhVien);

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
				EditMemberController.this.table.setModel(tableModel);
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
				EditMemberController.this.editMemberView.setVisible(false);
				EditMemberController.this.editMemberView.dispose();
			}

		});

		this.editMemberView.setCancelButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditMemberController.this.editMemberView.setVisible(false);
				EditMemberController.this.editMemberView.dispose();
			}

		});

	}

	private void displayMemberInfo(ThanhVien thanhVien) {
		this.editMemberView.setTen(thanhVien.getTen());
		this.editMemberView.setMaThanhVien(thanhVien.getMaThanhVien());
		this.editMemberView.setEmail(thanhVien.getEmail());
		this.editMemberView.setDiaChi(thanhVien.getDiaChi());
	}
}
