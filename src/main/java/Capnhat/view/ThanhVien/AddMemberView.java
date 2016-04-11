package Capnhat.view.ThanhVien;

import java.awt.event.ActionListener;

public class AddMemberView extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	public AddMemberView() {
		initComponents();
	}

	private void initComponents() {

		introductionLabel = new javax.swing.JLabel();
		tenLabel = new javax.swing.JLabel();
		tenTextField = new javax.swing.JTextField("Ten");
		maThanhVienLabel = new javax.swing.JLabel();
		maThanhVienTextField = new javax.swing.JTextField("Ma Thanh Vien");
		emailLabel = new javax.swing.JLabel();
		emailTextField = new javax.swing.JTextField("email");
		diaChiTextField = new javax.swing.JTextField("dia chi");
		diaChiLabel = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		addButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		introductionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		introductionLabel.setText("Nhập thông tin thành viên");
		introductionLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		introductionLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		tenLabel.setText("Tên:");

		maThanhVienLabel.setText("Mã thành viên:");

		emailLabel.setText("Email:");

		diaChiLabel.setText("Địa chỉ:");

		jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		addButton.setText("Thêm");

		cancelButton.setText("Hủy ");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(180, 180, 180).addComponent(addButton)
						.addGap(18, 18, 18).addComponent(cancelButton).addContainerGap(227, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cancelButton).addComponent(addButton))
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
										.addComponent(emailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 357,
												Short.MAX_VALUE)
										.addComponent(tenTextField).addComponent(maThanhVienTextField)
										.addComponent(diaChiTextField)))
				.addComponent(introductionLabel, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
						.addComponent(introductionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(23, 23, 23)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(tenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(tenLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(maThanhVienLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(maThanhVienTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(diaChiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(diaChiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

		setVisible(true);
		pack();
	}

	public void setAddButtonListener(ActionListener addButtonActionListener) {
		addButton.addActionListener(addButtonActionListener);
	}

	public void setCancelButtonListener(ActionListener cancelButtonActionListener) {
		cancelButton.addActionListener(cancelButtonActionListener);
	}

	public String getTen() {
		return tenTextField.getText();
	}

	public String getMaThanhVien() {
		return maThanhVienTextField.getText();
	}

	public String getEmail() {
		return emailTextField.getText();
	}

	public String getDiaChi() {
		return diaChiTextField.getText();
	}

	public void clearAllField() {
		this.tenTextField.setText(null);
		this.maThanhVienTextField.setText(null);
		this.emailTextField.setText(null);
		this.diaChiTextField.setText(null);
	}

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AddMemberView().setVisible(true);
			}
		});
	}

	private javax.swing.JButton addButton;
	private javax.swing.JButton cancelButton;
	private javax.swing.JLabel introductionLabel;
	private javax.swing.JLabel tenLabel;
	private javax.swing.JLabel maThanhVienLabel;
	private javax.swing.JLabel emailLabel;
	private javax.swing.JLabel diaChiLabel;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField tenTextField;
	private javax.swing.JTextField maThanhVienTextField;
	private javax.swing.JTextField emailTextField;
	private javax.swing.JTextField diaChiTextField;
}
