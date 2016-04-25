package DAO;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import Domain.PhieuMuon;

public class PhieuMuonDAO {
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

	PhieuMuonDAO() {
		try {
			factory = new AnnotationConfiguration().configure().buildSessionFactory();

		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
	}

	public static void save(PhieuMuon phieuMuon) {
		session = factory.openSession();
		ts = session.beginTransaction();

		session.save(phieuMuon);

		ts.commit();
		session.close();
	}

	public static void delete(String maPhieu) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("Delete from PhieuMuon where maPhieu= :maPhieu");
		query.setParameter("maPhieu", maPhieu);
		query.executeUpdate();
		ts.commit();

	}

	public static ArrayList<PhieuMuon> getAll() {
		session = factory.openSession();
		ts = session.beginTransaction();

		ArrayList<PhieuMuon> pm = (ArrayList<PhieuMuon>) session.createQuery("FROM PhieuMuon").list();
		ts.commit();

		return pm;
	}

	public static PhieuMuon getByItemCode(String maPhieu) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("FROM PhieuMuon where maPhieu= :maPhieu");
		query.setParameter("maPhieu", maPhieu);

		PhieuMuon pm = (PhieuMuon) query.list().get(0);

		ts.commit();
		session.close();

		return pm;
	}

	public static void update(PhieuMuon phieuMuon) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("select id from PhieuMuon where maPhieu= :maPhieu");
		query.setParameter("maPhieu", phieuMuon.getMaPhieu());
		int id = (Integer) query.uniqueResult();
		phieuMuon.setId(id);

		session.update(phieuMuon);

		ts.commit();
	}

	public static PhieuMuon getByCouponCode(String couponCode) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery(" from PhieuMuon where maPhieu= :maPhieu");
		query.setParameter("maPhieu", couponCode);

		PhieuMuon pm = (PhieuMuon) query.uniqueResult();

		return pm;
	}
	public int getIdbyCouponCode(String couponCode){
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("select id from PhieuMuon where maPhieu= :maPhieu");
		query.setParameter("maPhieu", couponCode);
		
		return (Integer) query.uniqueResult();
	}
	
	public static PhieuMuon getByMemberCode(String memberCode) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery(" from PhieuMuon where maThanhVien= :maThanhVien");
		query.setParameter("maThanhVien", memberCode);

		PhieuMuon pm = (PhieuMuon) query.uniqueResult();

		return pm;
	}

}
