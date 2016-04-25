package ThongKe.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import DAO.PhieuMuonDAO;
import DAO.SachDAO;
import DAO.SachMuonDAO;
import DAO.ThanhVienDAO;
import Domain.Sach;

public class ThongKe extends JPanel {
	private JFrame frame;
	private JCheckBox totalBook;
	private JCheckBox totalRemainBook;
	private JCheckBox totalLoanedBook;
	private JCheckBox totalInputedBook;
	private JCheckBox totalValueBook;
	private JCheckBox totalValueInputedBook;
	private JFormattedTextField fromTimeTF;
	private JFormattedTextField toTimeTF;
	private JButton stratButton;
	private JButton finishButton;

	private SachDAO sd;
	private ThanhVienDAO tvd;
	private PhieuMuonDAO pmd;
	private SachMuonDAO smd;
	private JCheckBox totalRegisteredMember;
	private JCheckBox totalMember;

	/**
	 * Create the panel.
	 */
	public ThongKe() {
		setLayout(null);
		JLabel lblThngK = new JLabel("Thống kê");
		lblThngK.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngK.setBounds(154, 23, 148, 14);
		add(lblThngK);

		totalBook = new JCheckBox("Thống kê số lượng sách");
		totalBook.setBounds(47, 57, 268, 23);
		add(totalBook);

		totalRemainBook = new JCheckBox("Thống kê số lượng sách còn lại trong thư viên");
		totalRemainBook.setBounds(47, 83, 299, 23);
		add(totalRemainBook);

		totalLoanedBook = new JCheckBox("Thống kê số lượng sách đang được mượn");
		totalLoanedBook.setBounds(47, 113, 255, 23);
		add(totalLoanedBook);

		totalInputedBook = new JCheckBox("Thống kê số lượng sách nhập vào");
		totalInputedBook.setBounds(47, 139, 241, 23);
		add(totalInputedBook);

		totalValueBook = new JCheckBox("Tổng giá trị sách đang có trong thư viện");
		totalValueBook.setBounds(47, 165, 255, 23);
		add(totalValueBook);

		totalValueInputedBook = new JCheckBox("Tổng giá trị sách được nhập");
		totalValueInputedBook.setBounds(47, 195, 268, 23);
		add(totalValueInputedBook);

		JLabel lblThiGian = new JLabel("Thời gian:");
		lblThiGian.setBounds(26, 299, 81, 23);
		add(lblThiGian);

		try {
			fromTimeTF = new JFormattedTextField(new MaskFormatter("**/**/****"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		fromTimeTF.setText("../../....");
		fromTimeTF.setBounds(117, 300, 86, 20);
		add(fromTimeTF);

		JLabel label = new JLabel("----->");
		label.setBounds(213, 303, 39, 14);
		add(label);

		try {
			toTimeTF = new JFormattedTextField(new MaskFormatter("**/**/****"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		toTimeTF.setText("../../....");
		toTimeTF.setBounds(268, 300, 98, 20);
		add(toTimeTF);

		stratButton = new JButton("Bắt đầu");
		stratButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> results = new ArrayList<String>();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date toDate = null;
				try {
					toDate = dateFormat.parse(toTimeTF.getText());
				} catch (ParseException e1) {
					toDate = null;
				}
				Date fromDate = null;

				try {
					fromDate = dateFormat.parse(fromTimeTF.getText());
				} catch (ParseException e1) {
					fromDate = null;
				}
				String thoiGian = null;
				if (fromDate != null && toDate != null) {
					thoiGian = "Từ ngày: " + dateFormat.format(fromDate) + " Đến ngày: " + dateFormat.format(toDate);
				} else if (fromDate != null) {
					thoiGian = "Từ ngày: " + dateFormat.format(fromDate);
				} else if (toDate != null) {
					thoiGian = " Đến ngày: " + dateFormat.format(toDate);
				}
				results.add(thoiGian);
				String tongSach = null;
				String sachChuaMuon = null;
				String sachDaMuon = null;
				String sachNhapVao = null;
				String tienSachNhapVao = null;
				String tongTienSach = null;
				String tongThanhVien = null;
				String tongNguoiDK = null;
				if (totalBook.isSelected()) {
					tongSach = "Tổng lượng sách trong thư viện là: " + SachDAO.findTotal(null, null, toDate, null);
					results.add(tongSach);
				}
				if (totalRemainBook.isSelected()) {
					sachChuaMuon = "Tổng lượng sách còn lại trong thư viện là: "
							+ (SachDAO.findTotal(null, null, toDate, null) - smd.findToTal(fromDate, toDate));
					results.add(sachChuaMuon);
				}
				if (totalLoanedBook.isSelected()) {
					sachDaMuon = "Tổng lượng sách đã mượn của thư viện là: " + smd.findToTal(fromDate, toDate);
					results.add(sachDaMuon);
				}
				if (totalInputedBook.isSelected()) {
					sachNhapVao = "Tổng lượng sách nhập vào là: " + sd.findTotal(null, null, toDate, fromDate);
					results.add(sachNhapVao);

				}
				if (totalValueInputedBook.isSelected()) {
					ArrayList<Sach> books = SachDAO.findInputedBook(fromDate, toDate);
					int value = 0;
					for (Sach book : books) {
						value += book.getGia();
					}
					tienSachNhapVao = "Tổng tiền sách nhập vào là: " + value + " (Đồng)";
					results.add(tienSachNhapVao);
				}
				if (totalValueBook.isSelected()) {
					ArrayList<Sach> books = SachDAO.findInputedBook(null, toDate);
					int value = 0;
					for (Sach book : books) {
						value += book.getGia();
					}
					tongTienSach = "Tổng giá trị sách có trong thư viện là: " + value + " (Đồng)";
					results.add(tongTienSach);

				}
				if (totalRegisteredMember.isSelected()) {
					tongNguoiDK = "Số lượng người đăng kí là: " + tvd.findTotal(fromDate, toDate);
					results.add(tongNguoiDK);
				}
				if (totalMember.isSelected()) {
					tongThanhVien = "Tổng số lượng thành viên của thư viên: " + tvd.findTotal(null, toDate);
					results.add(tongThanhVien);
				}
				new KetQuaThongKe(results);
			}

		});
		stratButton.setBounds(213, 363, 89, 23);
		add(stratButton);

		totalRegisteredMember = new JCheckBox("Thống kê số lượng người đăng kí thành viên");
		totalRegisteredMember.setBounds(47, 221, 308, 23);
		add(totalRegisteredMember);

		totalMember = new JCheckBox("Thống kê tổng số lượng thành viên");
		totalMember.setBounds(47, 247, 241, 23);
		add(totalMember);

	}

}
