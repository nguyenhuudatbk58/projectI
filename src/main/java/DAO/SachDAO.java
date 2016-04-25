package DAO;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import Domain.Sach;

public class SachDAO {
	private static SessionFactory factory;
	private static Session session;
	private static Transaction ts;

	static {
		try {
			factory = new AnnotationConfiguration().configure().buildSessionFactory();

		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

	}

	public SachDAO() {
		try {
			factory = new AnnotationConfiguration().configure().buildSessionFactory();

		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
	}

	public static ArrayList<Sach> getAll() {
		session = factory.openSession();
		ts = session.beginTransaction();

		ArrayList<Sach> sach = (ArrayList<Sach>) session.createQuery("FROM Sach").list();

		ts.commit();
		session.close();

		return sach;
	}

	public static Sach getByBookCode(String maSach) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("FROM Sach where maSach= :maSach");
		query.setParameter("maSach", maSach);
		Sach sach = (Sach) query.uniqueResult();

		ts.commit();
		session.close();

		return sach;
	}

	public static void save(Sach sach) {
		session = factory.openSession();
		ts = session.beginTransaction();

		session.save(sach);

		ts.commit();
		session.close();

	}

	public static void delete(Sach sach) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("delete from Sach where maSach= :maSach");
		query.setParameter("maSach", sach.getMaSach());
		query.executeUpdate();

		ts.commit();
		session.close();
	}

	public static void updateById(Sach sach) {
		session = factory.openSession();
		ts = session.beginTransaction();

		session.update(sach);

		ts.commit();
		session.close();
	}

	public static ArrayList<String> getBookCodes() {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("Select maSach FROM Sach ORDER BY maSach ASC ");
		ArrayList<String> bookCodes = (ArrayList<String>) query.list();

		return bookCodes;
	}

	public static int getIdByBookCode(String bookCode) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("Select id FROM Sach where maSach= :maSach");
		query.setParameter("maSach", bookCode);
		return (Integer) query.uniqueResult();
	}

	public static int findTotal(String nhaXuatBan, String chuDe, Date toTime, Date fromTime) {

		session = factory.openSession();
		ts = session.beginTransaction();
		Criteria criteria = session.createCriteria(Sach.class);
		criteria.setProjection(Projections.rowCount());

		if (nhaXuatBan != null) {
			criteria.add(Restrictions.eq("nhaXuatBan", nhaXuatBan));
		}
		if (chuDe != null) {
			criteria.add(Restrictions.eq("chuDe", chuDe));
		}

		if (toTime != null) {
			criteria.add(Restrictions.le("ngayThem", toTime));
		}

		if (fromTime != null) {
			criteria.add(Restrictions.ge("ngayThem", fromTime));
		}
		Integer total = (Integer) criteria.uniqueResult();

		ts.commit();
		session.close();
		if (total == null) {
			return 0;
		}
		return total;
	}

	public static ArrayList<Sach> findInputedBook(Date fromTime, Date toTime) {
		session = factory.openSession();
		ts = session.beginTransaction();
		Criteria criteria = session.createCriteria(Sach.class);

		if (toTime != null) {
			criteria.add(Restrictions.le("ngayThem", toTime));
		}

		if (fromTime != null) {
			criteria.add(Restrictions.ge("ngayThem", fromTime));
		}

		ArrayList<Sach> books = (ArrayList<Sach>) criteria.list();

		return books;
	}

	public static Integer getCostByBookCode(String bookCode) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("select gia from Sach where maSach = :maSach");
		query.setParameter("maSach", bookCode);

		Integer cost = (Integer) query.uniqueResult();

		ts.commit();
		session.close();

		return cost;
	}

	public static String getNameByBookCode(String bookCode) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("select ten from Sach where maSach = :maSach");
		query.setParameter("maSach", bookCode);

		String name = (String) query.uniqueResult();

		return name;
	}

}
