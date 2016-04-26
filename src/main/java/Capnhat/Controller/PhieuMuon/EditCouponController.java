package Capnhat.Controller.PhieuMuon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Capnhat.view.PhieuMuon.AddCouponView;
import Capnhat.view.PhieuMuon.Coupon;
import Capnhat.view.PhieuMuon.EditCouponView;
import DAO.PhieuMuonDAO;
import DAO.SachDAO;
import DAO.ThanhVienDAO;
import Domain.PhieuMuon;
import Domain.SachMuon;

public class EditCouponController {

	private PhieuMuonDAO pmd;

	private String couponCode;

	private PhieuMuon coupon;

	private SachDAO sachDAO;

	private ThanhVienDAO tvd;

	private EditCouponView editCouponView;

	private JTable table;

	public EditCouponController(EditCouponView editCouponView, JTable table, String couponCode) {
		this.editCouponView = editCouponView;
		this.table = table;
		this.couponCode = couponCode;

		loadBookCodes();
		loadMemberCodes();
		loadLoanBook(couponCode);

		this.editCouponView.setAddButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String bookCode = EditCouponController.this.editCouponView.getBookCode();
				Date loanDate = EditCouponController.this.editCouponView.getLoanDate();
				Date payDate = EditCouponController.this.editCouponView.getPayDate();

				EditCouponController.this.editCouponView.addLoanBookInTable(bookCode, loanDate, payDate);

			}
		});
		this.editCouponView.setEditButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = EditCouponController.this.editCouponView.getSelectedRow();
				if (selectedRow != -1) {
					String selectedBookCode = EditCouponController.this.editCouponView.getBookCodeAtRow(selectedRow);
					Date loanDate = EditCouponController.this.editCouponView.getLoanDateAtRow(selectedRow);
					Date payDate = EditCouponController.this.editCouponView.getPayDateAtRow(selectedRow);
					new EditLoanBook2(selectedBookCode, loanDate, payDate, EditCouponController.this.editCouponView,
							selectedRow);
				} else {
					JOptionPane.showMessageDialog(null, "Chọn sách cần chỉnh sửa.");
				}
			}

		});

		this.editCouponView.setDeleteButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int selectedRow = EditCouponController.this.editCouponView.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "Chọn sách muốn xóa");

				} else {
					EditCouponController.this.editCouponView.deleteLoanBookInTable(selectedRow);
				}

			}

		});

		this.editCouponView.setAddCouponButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maPhieu = EditCouponController.this.editCouponView.getCouponCode();
				String memberCode = EditCouponController.this.editCouponView.getMemberCode();
				if (maPhieu == null) {
					JOptionPane.showMessageDialog(null, "Nhập mã phiếu mượn.");
					return;
				}

				PhieuMuonDAO pmd = null;
				if (maPhieu.equals(EditCouponController.this.couponCode) == false) {

					if (pmd.getByCouponCode(maPhieu) != null) {
						JOptionPane.showMessageDialog(null, "Mã phiếu đã tồn tại.Hãy chọn mã phiếu khác.");
						return;
					}
				}
				if (pmd.getByMemberCode(memberCode) != null) {
					JOptionPane.showMessageDialog(null,
							"Thành viên hiện tại đang mượn sách của thư viên, cần trả sách trước khi mượn.");
					return;
				}

				HashSet<SachMuon> sms = EditCouponController.this.editCouponView.getSachMuons();

				if (sms.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nhập sách mượn");
					return;
				}

				PhieuMuon pm = new PhieuMuon();

				pm.setMaPhieu(maPhieu);
				pm.setMaThanhVien(memberCode);
				pm.setSachMuon(sms);

				PhieuMuon oldCoupon = pmd.getByCouponCode(maPhieu);
				pm.setId(oldCoupon.getId());
				pmd.delete(maPhieu);
				pmd.save(pm);
				javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(null,
						new String[] { "STT ", "Mã phiếu mượn", "Mã thành viên" }) {
					public Class getColumnClass(int column) {
						return String.class;
					}

					public boolean isCellEditable(int row, int col) {
						return false;
					}
				};
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

				EditCouponController.this.table.setModel(tableModel);

				EditCouponController.this.editCouponView.setVisible(false);
				EditCouponController.this.editCouponView.dispose();

			}

		});
		this.editCouponView.setCancelButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCouponController.this.editCouponView.setVisible(false);
				EditCouponController.this.editCouponView.dispose();
			}

		});

		this.editCouponView.setMemberComboBoxListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String memberCode = EditCouponController.this.editCouponView.getMemberCode();
				ThanhVienDAO tvd = null;
				String memberName = tvd.getMemberNameByMemberCode(memberCode);
				EditCouponController.this.editCouponView.setMemberName(memberName);
			}
		});

	}

	public void loadMemberCodes() {
		ThanhVienDAO tvd = null;
		ArrayList<String> memberCodes = tvd.getMemberCodes();
		String[] mbc = new String[memberCodes.size()];
		int i = 0;
		for (String memberCode : memberCodes) {
			mbc[i] = memberCode;
			i++;
		}

		this.editCouponView.setMemberCodeComboBoxValue(mbc);
		String memberCode = EditCouponController.this.editCouponView.getMemberCode();
		String memberName = tvd.getMemberNameByMemberCode(memberCode);
		EditCouponController.this.editCouponView.setMemberName(memberName);
	}

	public void loadBookCodes() {
		SachDAO sachDAO = null;
		ArrayList<String> bookCodes = sachDAO.getBookCodes();

		String[] mbc = new String[bookCodes.size()];

		int i = 0;
		for (String bookCode : bookCodes) {
			mbc[i] = bookCode;
			i++;
		}

		this.editCouponView.setBookCodeComboBoxValue(mbc);
	}

	public void loadLoanBook(String selectedCouponCode) {

		JTable loanBookTable = this.editCouponView.getLoanBookTable();

		DefaultTableModel tableModel = (DefaultTableModel) loanBookTable.getModel();

		coupon = pmd.getByCouponCode(selectedCouponCode);

		this.editCouponView.setCouponCode(coupon.getMaPhieu());
		this.editCouponView.setMemberCode(coupon.getMaThanhVien());

		ThanhVienDAO tvd = null;
		String memberName = tvd.getMemberNameByMemberCode(coupon.getMaThanhVien());
		this.editCouponView.setMemberName(memberName);

		Set<SachMuon> sachMuons = (Set<SachMuon>) coupon.getSachMuon();

		Iterator iterator = sachMuons.iterator();

		Vector<Object> v = null;
		while (iterator.hasNext()) {
			v = new Vector<Object>();
			SachMuon sm = (SachMuon) iterator.next();
			v.add(sm.getMaSach());
			v.add(sm.getNgayMuon());
			v.add(sm.getNgayTra());
			tableModel.addRow(v);
		}

	}

	class EditLoanBook2 extends javax.swing.JFrame {
		private static final long serialVersionUID = 1L;

		private EditCouponView editCouponView;

		public EditLoanBook2(String selectedItem, Date loanDate, Date payDate, EditCouponView editCouponView,
				int selectedRow) {
			this.editCouponView = editCouponView;
			initComponents(selectedItem, loanDate, payDate, selectedRow);
		}

		private void initComponents(String selectedItem, Date loanDate, Date payDate, final int selectedRow) {

			titileLabel = new javax.swing.JLabel();
			bookCodeLabel = new javax.swing.JLabel();
			loanDateLabel = new javax.swing.JLabel();
			payDateLabel = new javax.swing.JLabel();
			bookCodeComboBox = new javax.swing.JComboBox<String>();
			loadBookCodes();
			bookCodeComboBox.setSelectedItem(selectedItem);
			final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				loanDateFormattedTF = new javax.swing.JFormattedTextField(new MaskFormatter("##-##-####"));
				payDateFormattedTF = new javax.swing.JFormattedTextField(new MaskFormatter("##-##-####"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			loanDateFormattedTF.setText(dateFormat.format(loanDate));
			payDateFormattedTF.setText(dateFormat.format(payDate));
			updateButton = new javax.swing.JButton();
			cancelButton = new javax.swing.JButton();

			setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

			titileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			titileLabel.setText("Chỉnh sửa thông tin sách");

			bookCodeLabel.setText("Mã sách:");

			loanDateLabel.setText("Ngày mượn:");

			payDateLabel.setText("Hạn trả:");

			updateButton.setText("Cập nhật");
			updateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Date loanDate = null;
					Date payDate = null;
					try {
						loanDate = dateFormat.parse(loanDateFormattedTF.getText());
						payDate = dateFormat.parse(payDateFormattedTF.getText());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					String bookCode = (String) bookCodeComboBox.getSelectedItem();
					editCouponView.setLoanBookInTableAtRow(bookCode, loanDate, payDate, selectedRow);
					EditLoanBook2.this.setVisible(false);
					EditLoanBook2.this.dispose();
				}

			});

			cancelButton.setText("Hủy    ");
			cancelButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					EditLoanBook2.this.setVisible(false);
					EditLoanBook2.this.dispose();

				}
			});

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

			getContentPane().setLayout(layout);
			layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addGroup(layout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(layout.createSequentialGroup().addGap(104, 104, 104).addComponent(updateButton)
									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
											cancelButton))
							.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
									.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(
											titileLabel,
											javax.swing.GroupLayout.PREFERRED_SIZE, 185,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addGroup(layout
											.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
											.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
													.createSequentialGroup()
													.addComponent(payDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
															95, javax.swing.GroupLayout.PREFERRED_SIZE)
													.addGap(18, 18, 18).addComponent(payDateFormattedTF))
											.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
													.createSequentialGroup()
													.addComponent(loanDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
															95, javax.swing.GroupLayout.PREFERRED_SIZE)
													.addGap(18, 18, 18).addComponent(loanDateFormattedTF))
											.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
													.createSequentialGroup()
													.addComponent(bookCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
															95, javax.swing.GroupLayout.PREFERRED_SIZE)
													.addGap(18, 18, 18).addComponent(bookCodeComboBox,
															javax.swing.GroupLayout.PREFERRED_SIZE, 145,
															javax.swing.GroupLayout.PREFERRED_SIZE))))))
							.addContainerGap(92, Short.MAX_VALUE)));
			layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
							.addComponent(titileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
									javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18)
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(bookCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addComponent(bookCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addGap(18, 18, 18)
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
									.addComponent(loanDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(
											loanDateFormattedTF, javax.swing.GroupLayout.DEFAULT_SIZE, 30,
											Short.MAX_VALUE)))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(payDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addComponent(payDateFormattedTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(updateButton).addComponent(cancelButton))
							.addGap(22, 22, 22)));

			setVisible(true);

			pack();
		}

		public void loadBookCodes() {
			SachDAO sachDAO = null;
			ArrayList<String> bookCodes = sachDAO.getBookCodes();

			String[] mbc = new String[bookCodes.size()];

			int i = 0;
			for (String bookCode : bookCodes) {
				mbc[i] = bookCode;
				i++;
			}

			this.bookCodeComboBox.setModel(new DefaultComboBoxModel<String>(mbc));
		}

		private javax.swing.JComboBox bookCodeComboBox;
		private javax.swing.JLabel bookCodeLabel;
		private javax.swing.JButton cancelButton;
		private javax.swing.JFormattedTextField loanDateFormattedTF;
		private javax.swing.JLabel loanDateLabel;
		private javax.swing.JFormattedTextField payDateFormattedTF;
		private javax.swing.JLabel payDateLabel;
		private javax.swing.JLabel titileLabel;
		private javax.swing.JButton updateButton;
	}
}
