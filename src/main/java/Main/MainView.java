package Main;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import Capnhat.Controller.CapnhatController;
import Capnhat.view.CapnhatView;
import DAO.SachDAO;
import ThongKe.view.ThongKe;
import TimKiem.Controller.TimKiemController;
import TimKiem.View.TimKiemView;

public class MainView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainView() {

		setSize(1200, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane();
		CapnhatView capnhatView = new CapnhatView();
		new CapnhatController(capnhatView);
		tabbedPane.addTab("Cập nhật", capnhatView);

		TimKiemView timKiemView = new TimKiemView();
		new TimKiemController(timKiemView);
		tabbedPane.addTab("Tìm kiếm", timKiemView);
		tabbedPane.addTab("Thống kê", new ThongKe());
		add(tabbedPane);
		SachDAO sachDAO = new SachDAO();
		setVisible(true);
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainView().setVisible(true);
			}
		});
	}

}
