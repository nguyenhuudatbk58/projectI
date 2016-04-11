package Capnhat.view.Sach;

import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class EditBookView extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditBookView() {
		initComponents();
	}

	private void initComponents() {

		instructionLabel = new javax.swing.JLabel();
		TenLabel = new javax.swing.JLabel();
		TenTextField = new javax.swing.JTextField();
		MaSachLabel = new javax.swing.JLabel();
		MaSachTextField = new javax.swing.JTextField();
		NhaXuatBanLabel = new javax.swing.JLabel();
		NhaXuatBanTextField = new javax.swing.JTextField();
		TacGiaTextField = new javax.swing.JTextField();
		ChuDeTextField = new javax.swing.JTextField();
		GiaTextField = new javax.swing.JFormattedTextField();
		TacGiaLabel = new javax.swing.JLabel();
		ChuDeLabel = new javax.swing.JLabel();
		GiaLabel = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		editButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();

		try {
			NgayNhapTextField = new javax.swing.JFormattedTextField(new MaskFormatter("##--##--####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		jLabel8 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		instructionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		instructionLabel.setText("Nhập thông tin sách");
		instructionLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		instructionLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		TenLabel.setText("Tên:");
		MaSachLabel.setText("Mã sách:");
		NhaXuatBanLabel.setText("Nhà xuất bản:");
		TacGiaLabel.setText("Tác giả:");
		ChuDeLabel.setText("Chủ đề:");
		GiaLabel.setText("Giá:");

		jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		editButton.setText("Chỉnh sửa");
		cancelButton.setText("Hủy ");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(180, 180, 180).addComponent(editButton)
						.addGap(18, 18, 18).addComponent(cancelButton)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cancelButton).addComponent(editButton))
						.addContainerGap(22, Short.MAX_VALUE)));

		jLabel8.setText("Ngày nhập");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(instructionLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(63, 63, 63)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(MaSachLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(TenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(NhaXuatBanLabel)
										.addComponent(TacGiaLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
												69, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(ChuDeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(NhaXuatBanTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 357,
												Short.MAX_VALUE)
										.addComponent(TenTextField).addComponent(MaSachTextField)
										.addComponent(TacGiaTextField).addComponent(ChuDeTextField)))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
												.addComponent(GiaLabel, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38,
												Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(NgayNhapTextField,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 357,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(GiaTextField, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 357,
														javax.swing.GroupLayout.PREFERRED_SIZE))))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
						.addComponent(instructionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(23, 23, 23)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(TenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(TenLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(MaSachLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(MaSachTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(NhaXuatBanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(NhaXuatBanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(TacGiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(TacGiaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(ChuDeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(ChuDeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(GiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(GiaLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(NgayNhapTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(33, 33, 33).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

		setVisible(true);
		pack();
	}

	public void setEditButtonListener(ActionListener editButtonActionListener) {
		editButton.addActionListener(editButtonActionListener);
	}

	public void setCancelButtonListener(ActionListener cancelButtonActionListener) {
		cancelButton.addActionListener(cancelButtonActionListener);
	}

	public void setTenSach(String tenSach) {
		this.TenTextField.setText(tenSach);
	}

	public void setMaSach(String maSach) {
		this.MaSachTextField.setText(maSach);
	}

	public void setTacGia(String tacGia) {
		this.TacGiaTextField.setText(tacGia);
	}

	public void setNhaXuaBan(String nxb) {
		this.NhaXuatBanTextField.setText(nxb);
	}

	public void setChuDeSach(String chuDe) {
		this.ChuDeTextField.setText(chuDe);
	}

	public void setGiaSach(String gia) {
		this.GiaTextField.setText(gia);
	}

	public void setNgayNhap(String ngayNhap) {
		this.NgayNhapTextField.setText(ngayNhap);

	}

	public String getTenSach() {
		return this.TenTextField.getText();
	}

	public String getMaSach() {
		return this.MaSachTextField.getText();

	}

	public String getNhaXuatBan() {
		return this.NhaXuatBanTextField.getText();
	}

	public String getTacGia() {
		return this.TacGiaTextField.getText();
	}

	public String getChuDe() {
		return this.ChuDeTextField.getText();
	}

	public String getGia() {
		return this.GiaTextField.getText();
	}

	public String getNgayNhap() {
		return this.NgayNhapTextField.getText();
	}

	public static void main(String[] args) {
		new EditBookView().setVisible(true);
	}

	private javax.swing.JButton editButton;
	private javax.swing.JButton cancelButton;
	private javax.swing.JLabel instructionLabel;
	private javax.swing.JLabel TenLabel;
	private javax.swing.JLabel MaSachLabel;
	private javax.swing.JLabel NhaXuatBanLabel;
	private javax.swing.JLabel TacGiaLabel;
	private javax.swing.JLabel ChuDeLabel;
	private javax.swing.JLabel GiaLabel;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField TenTextField;
	private javax.swing.JTextField MaSachTextField;
	private javax.swing.JTextField NhaXuatBanTextField;
	private javax.swing.JTextField TacGiaTextField;
	private javax.swing.JTextField ChuDeTextField;
	private javax.swing.JFormattedTextField GiaTextField;
	private javax.swing.JFormattedTextField NgayNhapTextField;
	// End of variables declaration
}
