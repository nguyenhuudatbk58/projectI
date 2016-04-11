package TimKiem.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TimKiemSachController {
	public TimKiemSachController(TableRowSorter<TableModel> sorter, Object keySearch, String subjectSearch) {
		if (subjectSearch.equals("Tên sách")) {
			sorter.setRowFilter(RowFilter.regexFilter((String) keySearch, 1));
		} else if (subjectSearch.equals("Mã sách")) {
			sorter.setRowFilter(RowFilter.regexFilter((String) keySearch, 2));

		} else if (subjectSearch.equals("Tác giả")) {
			sorter.setRowFilter(RowFilter.regexFilter((String) keySearch, 3));

		} else if (subjectSearch.equals("Nhà xuất bản")) {
			sorter.setRowFilter(RowFilter.regexFilter((String) keySearch, 4));

		} else if (subjectSearch.equals("Chủ đề")) {
			sorter.setRowFilter(RowFilter.regexFilter((String) keySearch, 6));

		} else if (subjectSearch.equals("Ngày nhập")) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd--MM--yyyy");
			Date date = null;
			try {
				date = dateFormat.parse((String) keySearch);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sorter.setRowFilter(RowFilter.dateFilter(RowFilter.ComparisonType.EQUAL, date, 7));

		}
	}
}
