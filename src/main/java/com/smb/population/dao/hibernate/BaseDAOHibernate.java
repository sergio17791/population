package com.smb.population.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smb.population.dao.BaseDAO;
import com.smb.population.exceptions.PopulationException;
import com.smb.population.utils.HibernateUtils;

public class BaseDAOHibernate<T, ID extends Serializable> implements BaseDAO<T, ID> {
	
	private Class<T> persistentClass; 
	
	private final static Logger LOGGER = Logger.getLogger(BaseDAOHibernate.class.getName());
	
	@SuppressWarnings("unchecked")
	public BaseDAOHibernate() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public Class<T> getPersistentClass() {  
        return persistentClass;  
    }  

	@Override
	public T get(ID id) throws PopulationException {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			T entity = (T) session.get(getPersistentClass(), id);
			transaction.commit();
			
			return entity;
		} catch(HibernateException hibernateException) {
			try {
				if (transaction != null && transaction.isActive()) {
					transaction.rollback();
	            }
			} catch(Exception ex) {
				LOGGER.log(Level.WARNING,"Rollback on get failed", ex);
			} 			
			
			throw new PopulationException(hibernateException);
			
		} finally {
			session.close();
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() throws PopulationException {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		String queryStr = "from " + getPersistentClass().getName() + " entity";
		
		try {
			Query<T> query = session.createQuery(queryStr);
			return query.list();
		} catch(HibernateException hibernateException) {
			throw new PopulationException(hibernateException);
		} finally {
			session.close();
		}	
	}
}
