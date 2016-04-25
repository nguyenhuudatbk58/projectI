package DAO;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import Domain.SachMuon;

public class SachMuonDAO {
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

	public static int findToTal(Date fromTime, Date toTime) {

		session = factory.openSession();
		ts = session.beginTransaction();
		Criteria criteria = session.createCriteria(SachMuon.class);
		criteria.setProjection(Projections.rowCount());
		Criterion fT = null;
		Criterion tT = null;
		if (fromTime != null) {
			fT = Restrictions.ge("ngayMuon", fromTime);
		}
		if (toTime != null) {
			tT = Restrictions.le("ngayMuon", toTime);
		}
		if (fromTime != null && toTime != null) {
			LogicalExpression andEL = Restrictions.and(tT, fT);
			criteria.add(andEL);
		}
		if (fromTime != null) {
			criteria.add(fT);
		}
		if (toTime != null) {
			criteria.add(tT);
		}
		int total = (Integer) criteria.uniqueResult();
		return total;
	}

}
