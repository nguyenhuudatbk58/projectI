package Capnhat.Controller.PhieuMuon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PrintCoupon {

	public static void print(DefaultTableModel tableModel, String maPhieu, String tenThanhVien, String maThanhVien,
			int tienCoc) {
		
		JFileChooser fChooser = new JFileChooser();
		fChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
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
				font.setSize(10);
				font.setStyle(Font.NORMAL);
			} catch (IOException e) {
				font = null;
				e.printStackTrace();
			} catch (DocumentException e) {
				font = null;
				e.printStackTrace();
			}
			
			Paragraph header = new Paragraph("THƯ VIỆN TRƯỜNG ĐẠI HỌC BÁCH KHOA HÀ NỘI", font);
			header.setAlignment(Element.ALIGN_CENTER);
			header.setSpacingAfter(40.0f);
			document.add(header);

			Paragraph title = new Paragraph("Thông tin phiếu mượn", font);
			title.setAlignment(Element.ALIGN_CENTER);
			title.setSpacingAfter(40.0f);
			document.add(title);

			Paragraph coupon = new Paragraph("Phiếu mượn: " + maPhieu, font);
			coupon.setIndentationLeft(60f);
			coupon.setSpacingAfter(8f);
			document.add(coupon);

			Paragraph memberName = new Paragraph("Tên độc giả: " + tenThanhVien, font);
			memberName.setIndentationLeft(60f);
			memberName.setSpacingAfter(8f);
			document.add(memberName);

			Paragraph memberCode = new Paragraph("Mã độc giả: " + maThanhVien, font);
			memberCode.setSpacingAfter(8f);
			memberCode.setIndentationLeft(60f);
			document.add(memberCode);

			Paragraph prepayMoney = new Paragraph("Tiền cọc (70%): " + tienCoc + " (Đồng)", font);
			prepayMoney.setIndentationLeft(60f);
			prepayMoney.setSpacingAfter(20f);
			document.add(prepayMoney);

			Paragraph instruction = new Paragraph("Thông tin sách mượn", font);
			instruction.setAlignment(Element.ALIGN_CENTER);
			instruction.setSpacingAfter(15f);

			document.add(instruction);

			PdfPTable table = new PdfPTable(5); // 3 columns.

			PdfPCell cell1 = new PdfPCell(new Paragraph("Tên sách", font));
			PdfPCell cell2 = new PdfPCell(new Paragraph("Mã sách", font));
			PdfPCell cell3 = new PdfPCell(new Paragraph("Giá", font));
			PdfPCell cell4 = new PdfPCell(new Paragraph("Ngày mượn", font));
			PdfPCell cell5 = new PdfPCell(new Paragraph("Hạn trả", font));
			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			table.addCell(cell5);

			float[] columnWidths = { 1f, 1f, 1f, 1f, 1f };

			table.setWidths(columnWidths);
			int row = tableModel.getRowCount();
			PdfPCell bookName = null;
			PdfPCell bookCode = null;
			PdfPCell cost = null;
			PdfPCell loanDate = null;
			PdfPCell payDate = null;

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			for (int i = 0; i < row; i++) {
				bookName = new PdfPCell(new Paragraph((String) tableModel.getValueAt(i, 0), font));
				bookCode = new PdfPCell(new Paragraph((String) tableModel.getValueAt(i, 1), font));
				cost = new PdfPCell(new Paragraph("" + tableModel.getValueAt(i, 2)+" (Đồng)", font));
				loanDate = new PdfPCell(new Paragraph("" + dateFormat.format((Date) tableModel.getValueAt(i, 3)), font));
				payDate = new PdfPCell(new Paragraph("" + dateFormat.format((Date) tableModel.getValueAt(i, 4)), font));
				table.addCell(bookName);
				table.addCell(bookCode);
				table.addCell(cost);
				table.addCell(loanDate);
				table.addCell(payDate);
			}
			
			table.setSpacingAfter(20f);
			document.add(table);
			
			font.setStyle(Font.BOLD);
			Paragraph notice = new Paragraph("Chú ý:Nếu trả muộn người mượn sẽ bị phạt 5000 (đồng)/quyển/ngày", font);
			notice.setIndentationLeft(60f);
			notice.setSpacingAfter(50f);
			document.add(notice);
			
			font.setStyle(Font.NORMAL);
			Paragraph sumary = new Paragraph("Người mượn(ký tên):                                                                   Thủ thư (ký tên):", font);
			sumary.setIndentationLeft(60f);
			sumary.setSpacingAfter(30f);

			document.add(sumary);

			document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
