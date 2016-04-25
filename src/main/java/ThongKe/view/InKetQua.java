package ThongKe.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class InKetQua {
	public static void print(ArrayList<String> results) {
		JFileChooser fChooser = new JFileChooser();
		fChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int choose = -1;
		String path1 = null;
		File file = null;
		choose = fChooser.showSaveDialog(null);
		if (choose == JFileChooser.CANCEL_OPTION) {
			return;
		}
		file = fChooser.getSelectedFile();
		path1 = file.getAbsolutePath();
		Document document = new Document();
		try {
			PdfWriter wt = PdfWriter.getInstance(document, new FileOutputStream(path1));
			document.open();

			Font font = null;
			try {
				font = new Font(BaseFont.createFont("libs\\arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
			} catch (IOException e) {
				e.printStackTrace();
			}

			font.setSize(10);
			font.setStyle(Font.NORMAL);

			Paragraph title = new Paragraph("Kết quả thống kê", font);
			title.setAlignment(Element.ALIGN_CENTER);
			title.setSpacingAfter(40.0f);
			document.add(title);

			Paragraph kq = null;

			for (String result : results) {
				kq = new Paragraph(result, font);
				kq.setIndentationLeft(20f);
				kq.setSpacingAfter(10f);
				document.add(kq);
			}

			document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		InKetQua.print(null);
	}

}
