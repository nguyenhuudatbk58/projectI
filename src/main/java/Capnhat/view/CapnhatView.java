package Capnhat.view;

import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class CapnhatView extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CapnhatView() {
		initComponents();
	}

	public static javax.swing.JComboBox<String> getComboBox() {
		return selectionSubject_ComboBox;
	}

	private void initComponents() {

		ImageIcon addBtnIcon;
		Image image;
		image = this.getToolkit().getImage("lib/add.png");
		addBtnIcon = new ImageIcon(image);
		addButton = new javax.swing.JButton("Thêm", addBtnIcon);

		selectionSubject_ComboBox = new javax.swing.JComboBox<String>();
		selectionSubject_ComboBox.setModel(
				new javax.swing.DefaultComboBoxModel<String>(new String[] { "Sách", "Thành viên", "Phiếu mượn" }));

		myTable = new javax.swing.JTable();
		myTable.setModel(new javax.swing.table.DefaultTableModel(null, new String[] { "STT ", "Câu hỏi", "Đáp án A",
				"Đáp án B", "Đáp án C", "Đáp án D", "Đáp án đúng", "Loại" }));
		setSizeColumn();
		jScrollPane2 = new javax.swing.JScrollPane();
		jScrollPane2.setViewportView(myTable);

		ImageIcon updateBtnIcon;
		image = this.getToolkit().getImage("lib/updateic.png");
		updateBtnIcon = new ImageIcon(image);
		updateButton = new javax.swing.JButton("Sửa", updateBtnIcon);

		ImageIcon deleteBtnIcon;
		image = this.getToolkit().getImage("lib/delete.png");
		deleteBtnIcon = new ImageIcon(image);
		deleteButton = new javax.swing.JButton("Xóa", deleteBtnIcon);

		selectionSubject_Label = new javax.swing.JLabel();
		selectionSubject_Label.setText("Chọn chủ đề:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(selectionSubject_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(selectionSubject_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(43, 43, 43).addComponent(addButton).addGap(18, 18, 18).addComponent(updateButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(deleteButton).addContainerGap(367, Short.MAX_VALUE))
				.addComponent(jScrollPane2));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(31, 31, 31)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(selectionSubject_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(selectionSubject_Label).addComponent(addButton).addComponent(updateButton)
								.addComponent(deleteButton))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 501,
								javax.swing.GroupLayout.PREFERRED_SIZE)));
	}

	private void setSizeColumn() {
		TableColumn column;
		for (int i = 0; i < myTable.getColumnCount(); i++) {
			System.out.println(myTable.getColumnCount());
			column = myTable.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setMinWidth(5);
				column.setPreferredWidth(5);
			} else if (i == 1)
				column.setPreferredWidth(200);
			else if (i == 2)
				column.setPreferredWidth(150);
			else if (i == 3)
				column.setPreferredWidth(150);
			else if (i == 4)
				column.setPreferredWidth(150);
			else if (i == 5)
				column.setPreferredWidth(150);
			else if (i == 6)
				column.setPreferredWidth(25);
			else if (i == 7) {
				column.setMinWidth(5);
				column.setPreferredWidth(10);
			}
		}

	}

	public void setAddButtonListener(ActionListener listener) {
		this.addButton.addActionListener(listener);
	}

	public void setUpdateButtonListener(ActionListener listener) {
		this.updateButton.addActionListener(listener);
	}

	public void setDeleteButtonListener(ActionListener listener) {
		this.deleteButton.addActionListener(listener);
	}

	public void setSelectionSubjectComboBox(ActionListener listener) {
		this.selectionSubject_ComboBox.addActionListener(listener);
	}

	public String getSelectedSubject() {
		return (String) this.selectionSubject_ComboBox.getSelectedItem();
	}

	public JTable getMyTable() {
		return this.myTable;
	}

	private javax.swing.JButton addButton;
	private javax.swing.JButton updateButton;
	private javax.swing.JButton deleteButton;
	private static javax.swing.JComboBox<String> selectionSubject_ComboBox;
	private javax.swing.JLabel selectionSubject_Label;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable myTable;
}
