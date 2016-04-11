package TimKiem.View;

import java.awt.event.ActionListener;

import javax.swing.JTable;

public class TimKiemView extends javax.swing.JPanel {

	/**
	 * Creates new form SearchView
	 */
	public TimKiemView() {
		initComponents();
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		myTable = new javax.swing.JTable();
		searchButton = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		subjectComboBox = new javax.swing.JComboBox();
		keySearchFormattedTF = new javax.swing.JFormattedTextField();
		jLabel2 = new javax.swing.JLabel();
		subjectSearch_ComboBox = new javax.swing.JComboBox();
		refreshButton = new javax.swing.JButton("Refresh");

		jScrollPane1.setViewportView(myTable);

		searchButton.setText("Search");

		jLabel1.setText("Chọn chủ đề:");

		subjectComboBox
				.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sách", "Thành viên", "Phiếu mượn" }));

		jLabel2.setText("Tìm kiếm theo:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1)
				.addGroup(layout.createSequentialGroup().addGap(4, 4, 4)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 128,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(46, 46, 46)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(searchButton))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(keySearchFormattedTF, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34,
												Short.MAX_VALUE)
										.addComponent(refreshButton))
								.addGroup(layout.createSequentialGroup()
										.addComponent(subjectSearch_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
												141, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(33, 33, 33)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(subjectSearch_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(searchButton)
								.addComponent(keySearchFormattedTF, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(refreshButton))
						.addGap(18, 18, 18)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)));
	}// </editor-fold>

	public void setRefreshButtonListener(ActionListener listener) {
		this.refreshButton.addActionListener(listener);
	}

	public void setSearchButtonListener(ActionListener listener) {
		this.searchButton.addActionListener(listener);
	}

	public void setSubjectComboBoxListener(ActionListener listener) {
		this.subjectComboBox.addActionListener(listener);
	}

	public String getSelectedSubject() {
		return (String) this.subjectComboBox.getSelectedItem();
	}

	public JTable getMyTable() {
		return this.myTable;
	}

	public String getKeySearch() {
		return this.keySearchFormattedTF.getText();
	}

	public String getSubjectSearch() {
		return (String) this.subjectSearch_ComboBox.getSelectedItem();
	}

	public void setSubjectSearchModel(String[] subjectSearchs) {
		this.subjectSearch_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(subjectSearchs));
	}

	public void setKeySearch(String keySearch) {
		this.keySearchFormattedTF.setText(keySearch);
	}

	private javax.swing.JButton searchButton;
	private javax.swing.JButton refreshButton;
	private javax.swing.JComboBox subjectComboBox;
	private javax.swing.JComboBox subjectSearch_ComboBox;
	private javax.swing.JFormattedTextField keySearchFormattedTF;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable myTable;
	// End of variables declaration
}
