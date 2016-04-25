package Capnhat.view.PhieuMuon;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Capnhat.Controller.PhieuMuon.PrintCoupon;

public class Coupon {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coupon window = new Coupon(null, null, null, 0, null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Coupon(String couponCode, String memberName, String memberCode, int prepayMoney,
			DefaultTableModel tableModel) {
		initialize(couponCode, memberName, memberCode, prepayMoney, tableModel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String couponCode, final String memberName, final String memberCode,
			final int prepayMoney, final DefaultTableModel tableModel) {
		frame = new JFrame();
		frame.setBounds(100, 100, 691, 466);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel couponCodeTitle = new JLabel("Mã phiếu: \r\n");
		couponCodeTitle.setBounds(55, 28, 84, 26);
		frame.getContentPane().add(couponCodeTitle);

		JLabel label = new JLabel(couponCode);
		label.setBounds(140, 28, 103, 26);
		frame.getContentPane().add(label);

		JLabel memberTitle = new JLabel("Tên độc giả:");
		memberTitle.setBounds(55, 52, 94, 26);
		frame.getContentPane().add(memberTitle);

		JLabel lblNguynHut = new JLabel(memberName);
		lblNguynHut.setBounds(140, 53, 129, 25);
		frame.getContentPane().add(lblNguynHut);

		JLabel lblMcGi = new JLabel("Mã độc giả:\r\n");
		lblMcGi.setBounds(55, 78, 84, 26);
		frame.getContentPane().add(lblMcGi);

		JLabel label_1 = new JLabel(memberCode);
		label_1.setBounds(140, 79, 94, 25);
		frame.getContentPane().add(label_1);

		JLabel lblTinCc = new JLabel("Tiền cọc(70%):");
		lblTinCc.setBounds(55, 101, 84, 26);
		frame.getContentPane().add(lblTinCc);

		JLabel lblng = new JLabel(prepayMoney + " (Đồng)");
		lblng.setBounds(140, 101, 103, 26);
		frame.getContentPane().add(lblng);

		JLabel lblDanhSchSch = new JLabel("Danh sách sách mượn");
		lblDanhSchSch.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchSch.setBounds(227, 138, 190, 26);
		frame.getContentPane().add(lblDanhSchSch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 175, 675, 208);
		frame.getContentPane().add(scrollPane);

		table = new JTable() {
			public Class getColumnClass(int column) {
				if (column == 3 || column == 4) {
					return Date.class;
				} else {
					return String.class;
				}
			}

			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);

		JButton btnIn = new JButton("  In  ");
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				(new PrintCoupon()).print(tableModel, couponCode, memberName, memberCode, prepayMoney);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnIn.setBounds(227, 394, 89, 23);
		frame.getContentPane().add(btnIn);

		JButton btnHy = new JButton("   Hủy");
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnHy.setBounds(346, 394, 89, 23);
		frame.getContentPane().add(btnHy);

		frame.setVisible(true);
	}
}
