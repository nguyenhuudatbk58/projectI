package Capnhat.Controller.Sach;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFileChooser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAO.SachDAO;
import Domain.Sach;

public class ReadBookFile {
	public static void readFile() throws IOException {

		SachDAO sachDAO = new SachDAO();
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

		ArrayList<Sach> books = new ArrayList<Sach>();
		Sach book = null;
		int i = 0;
		while (iterator.hasNext()) {
			System.out.println("a");
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			i = 0;
			book = new Sach();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (i) {
				case 0:
					book.setTen(cell.getStringCellValue());
					break;
				case 1:
					book.setMaSach(cell.getStringCellValue());
					break;
				case 2:
					book.setTacGia(cell.getStringCellValue());
					break;
				case 3:
					book.setNhaXuatBan(cell.getStringCellValue());
					break;
				case 4:
					book.setChuDe(cell.getStringCellValue());
					break;
				case 5:
					book.setGia((int) cell.getNumericCellValue());
					break;
				case 6:
					book.setNgayThem(cell.getDateCellValue());
					break;
				}

				i++;
			}
			if (book.getGia() == 0) {
				break;
			}
			sachDAO.save(book);
		}
		System.out.println(books.size());
		inputStream.close();
	}

}
