package ThongKe.view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KetQuaThongKe {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KetQuaThongKe window = new KetQuaThongKe(null);
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
	public KetQuaThongKe(ArrayList<String> results) {
		initialize(results);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final ArrayList<String> results) {
		frame = new JFrame();
		frame.setBounds(100, 100, 544, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(0, 65, 528, 338);
		for (String result : results) {
			if (result == null) {
				continue;
			}
			textArea.append(result + "\n");
			textArea.append("\n");
		}
		frame.getContentPane().add(textArea);

		JLabel lblK = new JLabel("Kết quả thống kê");
		lblK.setHorizontalAlignment(SwingConstants.CENTER);
		lblK.setBounds(162, 11, 161, 30);
		frame.getContentPane().add(lblK);

		JButton btnKtThc = new JButton("Kết thúc");
		btnKtThc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnKtThc.setBounds(262, 414, 89, 23);
		frame.getContentPane().add(btnKtThc);

		JButton btnIn = new JButton("In");
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InKetQua.print(results);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnIn.setBounds(145, 414, 89, 23);
		frame.getContentPane().add(btnIn);
		frame.setVisible(true);
	}
}
