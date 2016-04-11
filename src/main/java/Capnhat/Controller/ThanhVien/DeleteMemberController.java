package Capnhat.Controller.ThanhVien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;

import Capnhat.view.ThanhVien.DeleteMemberView;
import DAO.ThanhVienDAO;
import Domain.ThanhVien;

public class DeleteMemberController {
	private ThanhVienDAO thanhVienDAO;

	private DeleteMemberView deleteMemberView;

	private JTable table;

	public DeleteMemberController(DeleteMemberView deleteMemberView, final ThanhVien thanhVien, JTable table) {

		this.deleteMemberView = deleteMemberView;
		this.table = table;
		displayMemberInfo(thanhVien);

		this.deleteMemberView.setDeleteButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				thanhVienDAO.delete(thanhVien);

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
				DeleteMemberController.this.table.setModel(tableModel);
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

				DeleteMemberController.this.deleteMemberView.setVisible(false);
				DeleteMemberController.this.deleteMemberView.dispose();

			}

		});
		this.deleteMemberView.setCancelButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteMemberController.this.deleteMemberView.setVisible(false);
				DeleteMemberController.this.deleteMemberView.dispose();
			}

		});

	}

	private void displayMemberInfo(ThanhVien thanhVien) {
		this.deleteMemberView.setTen(thanhVien.getTen());
		this.deleteMemberView.setMaThanhVien(thanhVien.getMaThanhVien());
		this.deleteMemberView.setEmail(thanhVien.getEmail());
		this.deleteMemberView.setDiaChi(thanhVien.getDiaChi());
	}

}
