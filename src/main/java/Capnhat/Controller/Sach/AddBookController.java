package Capnhat.Controller.Sach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Capnhat.view.Sach.AddBookView;
import DAO.SachDAO;
import Domain.Sach;

public class AddBookController {

	private JTable table;

	private SachDAO sachDAO;
	private AddBookView addBookView;

	public AddBookController(AddBookView addBookView, JTable table) {
		this.addBookView = addBookView;

		this.table = table;

		this.addBookView.setAddButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd--MM--yyyy");
				Sach sach = new Sach();
				sach.setTen(AddBookController.this.addBookView.getTenSach());
				sach.setMaSach(AddBookController.this.addBookView.getMaSach());
				sach.setTacGia(AddBookController.this.addBookView.getTacGia());
				sach.setChuDe(AddBookController.this.addBookView.getChuDe());
				sach.setGia(AddBookController.this.addBookView.getGia());
				sach.setNhaXuatBan(AddBookController.this.addBookView.getNhaXuatBan());
				try {
					sach.setNgayThem(dateFormat.parse(AddBookController.this.addBookView.getNgayNhap()));
				} catch (ParseException e1) {

					System.out.println("Exception when parse String to Date in AddBookController ");
					e1.printStackTrace();
				}

				sachDAO.save(sach);

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
				AddBookController.this.table.setModel(tableModel);

				ArrayList<Sach> books = sachDAO.getAll();

				Vector<Object> v;
				for (int i = 0; i < books.size(); i++) {
					Sach book = books.get(i);
					v = new Vector<Object>();
					v.add(i + 1);
					v.add(book.getTen());
					v.add(book.getMaSach());
					v.add(book.getTacGia());
					v.add(book.getNhaXuatBan());
					v.add(book.getGia());
					v.add(book.getChuDe());
					v.add(book.getNgayThem());
					tableModel.addRow(v);
				}

				AddBookController.this.addBookView.clearAllField();

			}
		});

		this.addBookView.setCancelButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookController.this.addBookView.setVisible(false);
				AddBookController.this.addBookView.dispose();
			}

		});
	}
}
