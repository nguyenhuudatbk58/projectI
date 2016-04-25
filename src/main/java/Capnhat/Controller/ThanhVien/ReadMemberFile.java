package Capnhat.Controller.ThanhVien;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JFileChooser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAO.ThanhVienDAO;
import Domain.ThanhVien;

public class ReadMemberFile {
	public static void readFile() throws IOException {

		ThanhVienDAO tvd = new ThanhVienDAO();
		JFileChooser fChooser = new JFileChooser();
		fChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int choose = -1;
		String path1 = null;
		File file = null;
		choose = fChooser.showOpenDialog(null);
		if (choose == JFileChooser.CANCEL_OPTION) {
			return;
		}
		file = fChooser.getSelectedFile();
		path1 = file.getAbsolutePath();
		FileInputStream inputStream = new FileInputStream(new File(path1));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		System.out.println(firstSheet.getFirstRowNum());
		System.out.println(firstSheet.getLastRowNum());
		Iterator<Row> iterator = firstSheet.iterator();

		ThanhVien member = null;
		int i = 0;
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			i = 0;
			member = new ThanhVien();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (i) {
				case 0:
					member.setTen(cell.getStringCellValue());
					break;
				case 1:
					member.setMaThanhVien(cell.getStringCellValue());
					break;
				case 2:
					member.setDiaChi(cell.getStringCellValue());
					break;
				case 3:
					member.setEmail(cell.getStringCellValue());
					break;
				case 4:
					member.setNgay_tham_gia(cell.getDateCellValue());
					break;

				}

				i++;
			}
			if (member.getTen().isEmpty()) {
				break;
			}
			tvd.save(member);
		}

		inputStream.close();
	}

}
