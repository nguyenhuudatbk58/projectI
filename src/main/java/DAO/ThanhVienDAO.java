package DAO;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import Domain.ThanhVien;

public class ThanhVienDAO {
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

	ThanhVienDAO() {
		try {
			factory = new Configuration().configure().buildSessionFactory();

		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
	}

	public static ArrayList<ThanhVien> getAll() {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("FROM ThanhVien");
		ArrayList<ThanhVien> thanhVien = (ArrayList<ThanhVien>) query.list();

		ts.commit();
		session.close();

		return thanhVien;
	}

	public static ThanhVien getByMemberCode(String maThanhVien) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("FROM ThanhVien where maThanhVien= :maThanhVien");
		query.setParameter("maThanhVien", maThanhVien);
		ThanhVien thanhVien = (ThanhVien) query.uniqueResult();

		ts.commit();
		session.close();

		return thanhVien;
	}

	public static void save(ThanhVien thanhVien) {
		session = factory.openSession();
		ts = session.beginTransaction();

		session.save(thanhVien);

		ts.commit();
		session.close();
	}

	public static void delete(ThanhVien thanhVien) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("delete from Sach where maThanhVien= :maThanhVien");
		query.setParameter("maThanhVien", thanhVien.getMaThanhVien());
		query.executeUpdate();

		ts.commit();
		session.close();
	}

	public static void updateById(ThanhVien thanhVien) {
		session = factory.openSession();
		ts = session.beginTransaction();

		session.update(thanhVien);

		ts.commit();
		session.close();
	}

	public static ArrayList<String> getMemberCodes() {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("Select maThanhVien FROM ThanhVien ORDER BY maThanhVien ASC ");
		ArrayList<String> memberCodes = (ArrayList<String>) query.list();

		return memberCodes;
	}

	public static String getMemberNameByMemberCode(String memberCode) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("select ten from ThanhVien where maThanhVien= :maThanhVien");
		query.setParameter("maThanhVien", memberCode);
		String memberName = (String) query.uniqueResult();

		return memberName;
	}
	public static int getIdByMemberCode(String memberCode){
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("select id from ThanhVien where maThanhVien= :maThanhVien");
		query.setParameter("maThanhVien", memberCode);
		
		return (Integer) query.uniqueResult();
	}

}
