package Capnhat.Controller.ThanhVien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;

import Capnhat.view.ThanhVien.AddMemberView;
import DAO.ThanhVienDAO;
import Domain.ThanhVien;

public class AddMemberController {
	private JTable table;
	private ThanhVienDAO thanhVienDAO;

	private AddMemberView addMemberView;

	public AddMemberController(AddMemberView addMemberView, JTable table) {
		this.addMemberView = addMemberView;
		this.table = table;

		this.addMemberView.setAddButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ThanhVien thanhVien = new ThanhVien();

				thanhVien.setTen(AddMemberController.this.addMemberView.getTen());
				thanhVien.setMaThanhVien(AddMemberController.this.addMemberView.getMaThanhVien());
				thanhVien.setEmail(AddMemberController.this.addMemberView.getEmail());
				thanhVien.setDiaChi(AddMemberController.this.addMemberView.getDiaChi());
				thanhVien.setNgay_tham_gia(new Date());

				thanhVienDAO.save(thanhVien);

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
				AddMemberController.this.table.setModel(tableModel);

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

				AddMemberController.this.addMemberView.clearAllField();

			}
		});

	}
}
