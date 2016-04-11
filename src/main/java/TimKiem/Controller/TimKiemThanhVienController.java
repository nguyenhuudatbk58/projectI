package TimKiem.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TimKiemThanhVienController {
	public TimKiemThanhVienController(TableRowSorter<TableModel> sorter, Object keySearch, String subjectSearch) {
		if (subjectSearch.equals("Tên thành viên")) {
			sorter.setRowFilter(RowFilter.regexFilter((String) keySearch, 1));
		} else if (subjectSearch.equals("Mã thành viên")) {
			sorter.setRowFilter(RowFilter.regexFilter((String) keySearch, 2));

		} else if (subjectSearch.equals("Email")) {
			sorter.setRowFilter(RowFilter.regexFilter((String) keySearch, 3));

		} else if (subjectSearch.equals("Ngày tham gia")) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd--MM--yyyy");
			Date date = null;
			try {
				date = dateFormat.parse((String) keySearch);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			sorter.setRowFilter(RowFilter.dateFilter(RowFilter.ComparisonType.EQUAL, date, 5));

		}
	}

}
