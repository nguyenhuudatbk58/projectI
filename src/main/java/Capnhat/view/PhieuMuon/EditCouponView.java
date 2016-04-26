package Capnhat.view.PhieuMuon;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import Domain.SachMuon;

public class EditCouponView extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditCouponView() {
		initComponents();
	}

	private void initComponents() {

		memberCodelabel = new javax.swing.JLabel();
		couponCodeLable = new javax.swing.JLabel();
		couponCodeTF = new javax.swing.JTextField();
		jScrollPane3 = new javax.swing.JScrollPane();
		loanBookTable = new javax.swing.JTable() {

			public Class getColumnClass(int column) {
				if (column == 0) {
					return String.class;
				} else {
					return Date.class;
				}
			}

		};
		addCouponButton = new javax.swing.JButton();
		jSeparator1 = new javax.swing.JSeparator();
		cancelButton = new javax.swing.JButton();
		memberCodeComboBox = new javax.swing.JComboBox<String>();
		AutoCompleteDecorator.decorate(memberCodeComboBox);
		memberNameLabel = new javax.swing.JLabel();
		jToolBar1 = new javax.swing.JToolBar();
		bookCodeLabel = new javax.swing.JLabel();
		bookCodeComboBox = new javax.swing.JComboBox<String>();
		AutoCompleteDecorator.decorate(bookCodeComboBox);
		loanDateLabel = new javax.swing.JLabel();
		try {
			loanDateFormattedTF = new javax.swing.JFormattedTextField(new MaskFormatter("##-##-####"));
			repaymentFormattedTF = new javax.swing.JFormattedTextField(new MaskFormatter("##-##-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaymentLabel = new javax.swing.JLabel();
		addBookButton = new javax.swing.JButton();
		editBookButton = new javax.swing.JButton();
		deleteBookButton = new javax.swing.JButton();
		memberNameTextField = new javax.swing.JTextField();
		prepayMoneyTitle = new javax.swing.JLabel();
		prepayMoney = new javax.swing.JLabel();
		errorLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		memberCodelabel.setText("Mã thành viên");

		couponCodeLable.setText("Mã phiếu mượn");

		loanBookTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		loanBookTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Mã sách", "Ngày mượn", "Ngày trả" }));
		jScrollPane3.setViewportView(loanBookTable);

		addCouponButton.setText("Cập nhật");

		jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		cancelButton.setText("Hủy");

		memberCodeComboBox.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] {}));
		memberCodeComboBox.setPreferredSize(new java.awt.Dimension(56, 30));

		memberNameLabel.setText("Tên thành viên:");
		memberNameLabel.setMaximumSize(new java.awt.Dimension(34, 30));

		jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		jToolBar1.setFloatable(false);
		jToolBar1.setRollover(true);

		bookCodeLabel.setText("Mã sách");
		bookCodeLabel.setMaximumSize(new java.awt.Dimension(50, 16));
		jToolBar1.add(bookCodeLabel);

		bookCodeComboBox.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] {}));
		bookCodeComboBox.setMaximumSize(new java.awt.Dimension(140, 30));
		jToolBar1.add(bookCodeComboBox);

		loanDateLabel.setText("Ngày mượn");
		loanDateLabel.setMaximumSize(new java.awt.Dimension(70, 30));
		jToolBar1.add(loanDateLabel);

		loanDateFormattedTF.setMaximumSize(new java.awt.Dimension(100, 28));
		jToolBar1.add(loanDateFormattedTF);

		repaymentLabel.setText("Hạn trả");
		repaymentLabel.setMaximumSize(new java.awt.Dimension(70, 29));
		repaymentLabel.setPreferredSize(new java.awt.Dimension(60, 14));
		repaymentLabel.setVerifyInputWhenFocusTarget(false);
		jToolBar1.add(repaymentLabel);
		repaymentLabel.getAccessibleContext().setAccessibleName("Hạn trả");

		repaymentFormattedTF.setMaximumSize(new java.awt.Dimension(90, 28));
		jToolBar1.add(repaymentFormattedTF);

		addBookButton.setText("Thêm");
		addBookButton.setBorder(null);
		addBookButton.setFocusable(false);
		addBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		addBookButton.setMaximumSize(new java.awt.Dimension(33, 28));
		addBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(addBookButton);

		editBookButton.setText("Sửa");
		editBookButton.setBorder(null);
		editBookButton.setFocusable(false);
		editBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		editBookButton.setMaximumSize(new java.awt.Dimension(25, 28));
		editBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(editBookButton);

		deleteBookButton.setText("Xóa");
		deleteBookButton.setBorder(null);
		deleteBookButton.setFocusable(false);
		deleteBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		deleteBookButton.setMaximumSize(new java.awt.Dimension(25, 28));
		deleteBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(deleteBookButton);

		

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(305, 305, 305).addComponent(addCouponButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(cancelButton)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(
						layout.createSequentialGroup().addContainerGap().addComponent(jSeparator1))
				.addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
				.addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addGap(45, 45, 45)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(couponCodeLable, javax.swing.GroupLayout.DEFAULT_SIZE,
												102, Short.MAX_VALUE)
										.addComponent(memberCodelabel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(prepayMoneyTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 83,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(24, 24, 24)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(couponCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 198,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(memberCodeComboBox, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 198,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(prepayMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(40, 40, 40)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(memberNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28,
												Short.MAX_VALUE)
										.addComponent(memberNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 253,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(37, 37, 37)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(couponCodeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(couponCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE,
										34, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(11, 11, 11)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(memberNameTextField)
								.addComponent(memberCodelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addGap(6, 6, 6)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(memberCodeComboBox, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(memberNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
														30, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(prepayMoneyTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(prepayMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
						.addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(cancelButton).addComponent(addCouponButton))));

		setVisible(true);
		pack();
	}//

	public HashSet<SachMuon> getSachMuons() {
		HashSet<SachMuon> sms = new HashSet<SachMuon>();

		int nRow = this.loanBookTable.getRowCount();

		SachMuon sm = null;
		for (int i = 0; i < nRow; i++) {
			sm = new SachMuon();
			sm.setMaSach((String) loanBookTable.getValueAt(i, 0));
			sm.setNgayMuon((Date) loanBookTable.getValueAt(i, 1));
			sm.setNgayTra((Date) loanBookTable.getValueAt(i, 2));
			sms.add(sm);
		}

		return sms;
	}

	public void removeBookCode(String bookCode) {
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) this.bookCodeComboBox.getModel();
		model.removeElement(bookCode);
	}

	public void addBookCode(String bookCode) {
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) this.bookCodeComboBox.getModel();
		model.addElement(bookCode);
	}

	public JComboBox getBookCodeComboBox() {
		return this.bookCodeComboBox;
	}

	public String getCouponCode() {
		return this.couponCodeTF.getText();
	}

	public void setCouponCode(String couponCode) {
		this.couponCodeTF.setText(couponCode);
	}

	public String getMemberCode() {
		return (String) this.memberCodeComboBox.getSelectedItem();
	}

	public void setMemberCode(String memberCode) {
		this.memberCodeComboBox.setSelectedItem(memberCode);
	}

	public int getSelectedRow() {
		if (loanBookTable.getSelectedRow() == -1) {
			return -1;
		}
		lastSelectedRow = loanBookTable.getSelectedRow();
		return lastSelectedRow;
	}

	public int getLastSelectedRow() {
		return lastSelectedRow;
	}

	public void setMemberName(String memberName) {
		this.memberNameTextField.setText(memberName);
	}

	public void setBookCode(String bookCode) {
		this.bookCodeComboBox.setSelectedItem(bookCode);
	}

	public void setPayDate(Date payDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		this.repaymentFormattedTF.setText(dateFormat.format(payDate));
	}

	public void setLoanDate(Date loanDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		this.loanDateFormattedTF.setText(dateFormat.format(loanDate));
	}

	public String getBookCodeAtRow(int row) {
		String bookCode = (String) this.loanBookTable.getValueAt(row, 0);
		return bookCode;
	}

	public Date getPayDateAtRow(int row) {
		Date payDate = (Date) this.loanBookTable.getValueAt(row, 2);
		return payDate;

	}

	public Date getLoanDateAtRow(int row) {
		Date loanDate = (Date) this.loanBookTable.getValueAt(row, 1);
		return loanDate;

	}

	public String getBookCode() {
		return (String) this.bookCodeComboBox.getSelectedItem();
	}

	public Date getPayDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date payDate = null;
		try {
			payDate = dateFormat.parse(repaymentFormattedTF.getText());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return payDate;
	}

	public Date getLoanDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date loanDate = null;
		try {
			loanDate = dateFormat.parse(loanDateFormattedTF.getText());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return loanDate;
	}

	public void addLoanBookInTable(String bookCode, Date loanDate, Date payDate) {
		DefaultTableModel tableModel = (DefaultTableModel) loanBookTable.getModel();

		Vector<Object> v = new Vector<Object>();

		v.add(bookCode);
		v.add(loanDate);
		v.add(payDate);

		tableModel.addRow(v);
	}

	public void resetTable() {
		loanBookTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Mã sách", "Ngày mượn", "Ngày trả" }));
	}

	public void setLoanBookInTableAtRow(String bookCode, Date loanDate, Date payDate, int row) {
		DefaultTableModel tableModel = (DefaultTableModel) loanBookTable.getModel();

		tableModel.setValueAt(bookCode, row, 0);
		tableModel.setValueAt(loanDate, row, 1);
		tableModel.setValueAt(payDate, row, 2);

	}

	public void deleteLoanBookInTable(int selectedRow) {
		DefaultTableModel tableModel = (DefaultTableModel) loanBookTable.getModel();

		tableModel.removeRow(selectedRow);
	}

	public SachMuon getValueAtRow(int selectedRow) {
		DefaultTableModel tableModel = (DefaultTableModel) loanBookTable.getModel();
		SachMuon loanBook = new SachMuon();
		loanBook.setMaSach((String) tableModel.getValueAt(selectedRow, 0));
		loanBook.setNgayMuon((Date) tableModel.getValueAt(selectedRow, 1));
		loanBook.setNgayTra((Date) tableModel.getValueAt(selectedRow, 2));
		return loanBook;
	}

	public void setMemberCodeComboBoxValue(String[] value) {
		this.memberCodeComboBox.setModel(new DefaultComboBoxModel<String>(value));
	}

	public void setBookCodeComboBoxValue(String[] value) {
		this.bookCodeComboBox.setModel(new DefaultComboBoxModel<String>(value));
	}

	public void setAddButtonListener(ActionListener listener) {
		this.addBookButton.addActionListener(listener);
	}

	public void setEditButtonListener(ActionListener listener) {
		this.editBookButton.addActionListener(listener);
	}

	public void setDeleteButtonListener(ActionListener listener) {
		this.deleteBookButton.addActionListener(listener);
	}

	public void setAddCouponButtonListener(ActionListener listener) {
		this.addCouponButton.addActionListener(listener);
	}

	public void setCancelButtonListener(ActionListener listener) {
		this.cancelButton.addActionListener(listener);
	}

	public void setMemberComboBoxListener(ActionListener listener) {
		this.memberCodeComboBox.addActionListener(listener);
	}

	public void setCouponTFDocumentListener(DocumentListener listener) {
		this.couponCodeTF.getDocument().addDocumentListener(listener);
	}

	public void setError(String error) {
		this.errorLabel.setText(error);
	}

	public JTable getLoanBookTable() {
		return this.loanBookTable;
	}

	public static void main(String[] args) {
		new AddCouponView();
	}

	private javax.swing.JLabel prepayMoneyTitle;
	private javax.swing.JLabel errorLabel;
	private javax.swing.JLabel prepayMoney;
	private int lastSelectedRow;
	private javax.swing.JButton addBookButton;
	private javax.swing.JButton addCouponButton;
	private javax.swing.JComboBox<String> bookCodeComboBox;
	private javax.swing.JLabel bookCodeLabel;
	private javax.swing.JLabel couponCodeLable;
	private javax.swing.JTextField couponCodeTF;
	private javax.swing.JButton deleteBookButton;
	private javax.swing.JButton editBookButton;
	private javax.swing.JButton cancelButton;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JToolBar jToolBar1;
	private javax.swing.JTable loanBookTable;
	private javax.swing.JFormattedTextField loanDateFormattedTF;
	private javax.swing.JLabel loanDateLabel;
	private javax.swing.JComboBox<String> memberCodeComboBox;
	private javax.swing.JLabel memberCodelabel;
	private javax.swing.JLabel memberNameLabel;
	private javax.swing.JTextField memberNameTextField;
	private javax.swing.JFormattedTextField repaymentFormattedTF;
	private javax.swing.JLabel repaymentLabel;
}
