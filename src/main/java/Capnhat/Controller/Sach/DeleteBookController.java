package Capnhat.Controller.Sach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;

import Capnhat.view.Sach.DeleteBookView;
import DAO.SachDAO;
import Domain.Sach;

public class DeleteBookController {

	private SachDAO sachDAO;

	private DeleteBookView deleteBookView;

	private JTable table;

	public DeleteBookController(DeleteBookView deleteBookView, final Sach book, JTable table) {
		this.deleteBookView = deleteBookView;

		this.table = table;
		displayBookInfo(book);

		this.deleteBookView.setDeleteButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				sachDAO.delete(book);

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
				DeleteBookController.this.table.setModel(tableModel);

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
				DeleteBookController.this.deleteBookView.setVisible(false);
				DeleteBookController.this.deleteBookView.dispose();

			}

		});

		this.deleteBookView.setCancelButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				DeleteBookController.this.deleteBookView.setVisible(false);
				DeleteBookController.this.deleteBookView.dispose();

			}

		});
	}

	private void displayBookInfo(Sach book) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd--MM--yyyy");

		this.deleteBookView.setTenSach(book.getTen());
		this.deleteBookView.setMaSach(book.getMaSach());
		this.deleteBookView.setTacGia(book.getTacGia());
		this.deleteBookView.setNhaXuaBan(book.getNhaXuatBan());
		this.deleteBookView.setChuDeSach(book.getChuDe());
		this.deleteBookView.setGiaSach(book.getGia());
		this.deleteBookView.setNgayNhap(dateFormat.format(book.getNgayThem()));
	}
}
