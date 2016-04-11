package Capnhat.view.ThanhVien;

import java.awt.event.ActionListener;

public class DeleteMemberView extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	public DeleteMemberView() {
		initComponents();
	}

	private void initComponents() {

		introductionLabel = new javax.swing.JLabel();
		tenLabel = new javax.swing.JLabel();
		tenLabel2 = new javax.swing.JLabel();
		maThanhVienLabel = new javax.swing.JLabel();
		maThanhVienLabel2 = new javax.swing.JLabel();
		emailLabel = new javax.swing.JLabel();
		emailLabel2 = new javax.swing.JLabel();
		diaChiLabel2 = new javax.swing.JLabel();
		diaChiLabel = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		deleteButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		introductionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		introductionLabel.setText("Bạn có chắc chắn muốn xóa không?");
		introductionLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		introductionLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		tenLabel.setText("Tên:");

		maThanhVienLabel.setText("Mã thành viên:");

		emailLabel.setText("Email:");

		diaChiLabel.setText("Địa chỉ:");

		jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		deleteButton.setText("Chỉnh sửa");

		cancelButton.setText("Hủy ");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(180, 180, 180).addComponent(deleteButton)
						.addGap(18, 18, 18).addComponent(cancelButton).addContainerGap(227, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cancelButton).addComponent(deleteButton))
						.addContainerGap(22, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(63, 63, 63)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(maThanhVienLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(tenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(emailLabel).addComponent(diaChiLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE, 69,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(emailLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 357,
												Short.MAX_VALUE)
										.addComponent(tenLabel2).addComponent(maThanhVienLabel2)
										.addComponent(diaChiLabel2)))
				.addComponent(introductionLabel, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
						.addComponent(introductionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(23, 23, 23)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(tenLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(tenLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(maThanhVienLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(maThanhVienLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(emailLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(diaChiLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(diaChiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

		setVisible(true);
		pack();
	}

	public void setDeleteButtonListener(ActionListener addButtonActionListener) {
		deleteButton.addActionListener(addButtonActionListener);
	}

	public void setCancelButtonListener(ActionListener cancelButtonActionListener) {
		cancelButton.addActionListener(cancelButtonActionListener);
	}

	public void setTen(String ten) {
		tenLabel2.setText(ten);
	}

	public void setMaThanhVien(String maThanhVien) {
		maThanhVienLabel2.setText(maThanhVien);
	}

	public void setEmail(String email) {
		emailLabel2.setText(email);
	}

	public void setDiaChi(String diaChi) {
		diaChiLabel2.setText(diaChi);
	}

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AddMemberView().setVisible(true);
			}
		});
	}

	private javax.swing.JButton deleteButton;
	private javax.swing.JButton cancelButton;
	private javax.swing.JLabel introductionLabel;
	private javax.swing.JLabel tenLabel;
	private javax.swing.JLabel maThanhVienLabel;
	private javax.swing.JLabel emailLabel;
	private javax.swing.JLabel diaChiLabel;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel tenLabel2;
	private javax.swing.JLabel maThanhVienLabel2;
	private javax.swing.JLabel emailLabel2;
	private javax.swing.JLabel diaChiLabel2;
}

