package Capnhat.view.Sach;

import java.awt.event.ActionListener;

public class DeleteBookView extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeleteBookView() {
		initComponents();
	}

	private void initComponents() {

		instructionLabel = new javax.swing.JLabel();
		TenLabel = new javax.swing.JLabel();
		TenLabel2 = new javax.swing.JLabel();
		MaSachLabel = new javax.swing.JLabel();
		MaSachLabel2 = new javax.swing.JLabel();
		NhaXuatBanLabel = new javax.swing.JLabel();
		NhaXuatBanLabel2 = new javax.swing.JLabel();
		TacGiaLabel2 = new javax.swing.JLabel();
		ChuDeLabel2 = new javax.swing.JLabel();
		GiaLabel2 = new javax.swing.JLabel();
		TacGiaLabel = new javax.swing.JLabel();
		ChuDeLabel = new javax.swing.JLabel();
		GiaLabel = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		deleteButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();

		NgayNhapLabel2 = new javax.swing.JLabel();

		ngayNhapLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		instructionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		instructionLabel.setText("Bạn có chắc chắn muốn xóa không?");
		instructionLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		instructionLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		TenLabel.setText("Tên:");
		MaSachLabel.setText("Mã sách:");
		NhaXuatBanLabel.setText("Nhà xuất bản:");
		TacGiaLabel.setText("Tác giả:");
		ChuDeLabel.setText("Chủ đề:");
		GiaLabel.setText("Giá:");

		jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		deleteButton.setText("Xóa");
		cancelButton.setText("Hủy ");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(180, 180, 180).addComponent(deleteButton)
						.addGap(18, 18, 18).addComponent(cancelButton)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cancelButton).addComponent(deleteButton))
						.addContainerGap(22, Short.MAX_VALUE)));

		ngayNhapLabel.setText("Ngày nhập");

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
										.addComponent(NhaXuatBanLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 357,
												Short.MAX_VALUE)
										.addComponent(TenLabel2).addComponent(MaSachLabel2).addComponent(TacGiaLabel2)
										.addComponent(ChuDeLabel2)))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(ngayNhapLabel, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
												.addComponent(GiaLabel, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38,
												Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(NgayNhapLabel2,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 357,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(GiaLabel2, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 357,
														javax.swing.GroupLayout.PREFERRED_SIZE))))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
						.addComponent(instructionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(23, 23, 23)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(TenLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(TenLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(MaSachLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(MaSachLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(NhaXuatBanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(NhaXuatBanLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(TacGiaLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(TacGiaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(ChuDeLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(ChuDeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(GiaLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(GiaLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(NgayNhapLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(ngayNhapLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(33, 33, 33).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		new DeleteBookView();
	}

	public void setDeleteButtonListener(ActionListener editButtonActionListener) {
		deleteButton.addActionListener(editButtonActionListener);
	}

	public void setCancelButtonListener(ActionListener cancelButtonActionListener) {
		cancelButton.addActionListener(cancelButtonActionListener);
	}

	public void setTenSach(String tenSach) {
		this.TenLabel2.setText(tenSach);
	}

	public void setMaSach(String maSach) {
		this.MaSachLabel2.setText(maSach);
	}

	public void setTacGia(String tacGia) {
		this.TacGiaLabel2.setText(tacGia);
	}

	public void setNhaXuaBan(String nxb) {
		this.NhaXuatBanLabel2.setText(nxb);
	}

	public void setChuDeSach(String chuDe) {
		this.ChuDeLabel2.setText(chuDe);
	}

	public void setGiaSach(int gia) {
		this.GiaLabel2.setText("" + gia);
	}

	public void setNgayNhap(String ngayNhap) {
		this.NgayNhapLabel2.setText(ngayNhap);

	}

	private javax.swing.JButton deleteButton;
	private javax.swing.JButton cancelButton;
	private javax.swing.JLabel instructionLabel;
	private javax.swing.JLabel TenLabel;
	private javax.swing.JLabel MaSachLabel;
	private javax.swing.JLabel NhaXuatBanLabel;
	private javax.swing.JLabel TacGiaLabel;
	private javax.swing.JLabel ChuDeLabel;
	private javax.swing.JLabel GiaLabel;
	private javax.swing.JLabel ngayNhapLabel;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel TenLabel2;
	private javax.swing.JLabel MaSachLabel2;
	private javax.swing.JLabel NhaXuatBanLabel2;
	private javax.swing.JLabel TacGiaLabel2;
	private javax.swing.JLabel ChuDeLabel2;
	private javax.swing.JLabel GiaLabel2;
	private javax.swing.JLabel NgayNhapLabel2;
	// End of variables declaration
}
