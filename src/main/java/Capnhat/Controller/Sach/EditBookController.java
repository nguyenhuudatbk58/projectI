package Capnhat.Controller.Sach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;

import Capnhat.view.Sach.EditBookView;
import DAO.SachDAO;
import Domain.Sach;

public class EditBookController {
	private SachDAO sachDAO;

	private EditBookView editBookView;

	private JTable table;

	public EditBookController(EditBookView editBookView, final Sach book, JTable table) {

		this.editBookView = editBookView;

		this.table = table;

		displayBookInfo(book);
		
		this.editBookView.setEditButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd--MM--yyyy");

				book.setTen(EditBookController.this.editBookView.getTenSach());
				book.setMaSach(EditBookController.this.editBookView.getMaSach());
				book.setTacGia(EditBookController.this.editBookView.getTacGia());
				book.setChuDe(EditBookController.this.editBookView.getChuDe());
				book.setGia(EditBookController.this.editBookView.getGia());
				book.setNhaXuatBan(EditBookController.this.editBookView.getNhaXuatBan());
				try {
					book.setNgayThem(dateFormat.parse(EditBookController.this.editBookView.getNgayNhap()));
				} catch (ParseException e) {
					e.printStackTrace();
				}

				sachDAO.updateById(book);

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
				EditBookController.this.table.setModel(tableModel);

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

				EditBookController.this.editBookView.setVisible(false);
				EditBookController.this.editBookView.dispose();

			}

		});

		this.editBookView.setCancelButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				EditBookController.this.editBookView.setVisible(false);
				EditBookController.this.editBookView.dispose();
			}

		});

	}

	private void displayBookInfo(Sach book) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd--MM--yyyy");

		this.editBookView.setTenSach(book.getTen());
		this.editBookView.setMaSach(book.getMaSach());
		this.editBookView.setTacGia(book.getTacGia());
		this.editBookView.setNhaXuaBan(book.getNhaXuatBan());
		this.editBookView.setChuDeSach(book.getChuDe());
		this.editBookView.setGiaSach(book.getGia());
		this.editBookView.setNgayNhap(dateFormat.format(book.getNgayThem()));
	}

}
