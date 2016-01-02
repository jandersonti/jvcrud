package com.jvcrud.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jvcrud.util.TypeSearchOperator;

@SuppressWarnings({"unchecked","rawtypes"})
@Repository
public abstract class AbstractSimpleDAO<T> implements SimpleDAO<T> {

	protected SessionFactory sessionFactory;
	
	protected T entity;

	protected Class classType;
	
	protected AbstractSimpleDAO(Class classType){
		this.classType = classType;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;		
	}

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}


	/**
	 * @param filter
	 * @param field
	 * @param value
	 * @return
	 */
	protected SimpleExpression getFilter(final String filter, final String field, final Object value){
		SimpleExpression exp = null;
		
		switch (TypeSearchOperator.valueOf(filter)) {
		case EQ: //igual
			exp = Restrictions.eq(field, value);
			break;

		case LT: //menor que
			exp = Restrictions.lt(field, value);
			break;

		case LE: //menor que ou igual
			exp = Restrictions.le(field, value);
			break;	

		case GT: //maior que
			exp = Restrictions.gt(field, value);
			break;

		case GE: //maior que ou igual
			exp = Restrictions.ge(field, value);
			break;

		case IN: //inicia com
			exp = Restrictions.like(field, value + "%");
			break;

		case CN: //contem
			exp = Restrictions.like(field, "%" + value + "%");
			break;

		case EN: //termina com
			exp = Restrictions.like(field, "%" + value);
			break;

		default:
			exp = Restrictions.eq(field, value);
			break;
		}

		return exp;
	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRES_NEW)
	public T get(long id) {
		
		return (T) getSession().get(classType, id);
	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public long count() {

		return (Long) getSession().createCriteria(classType).setProjection(Projections.rowCount()).uniqueResult();
	}


	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public long count(Object search, String field, String filter) {

		Criteria criteria = getSession().createCriteria(classType);

		criteria.add(getFilter(filter, field, search));

		criteria.setProjection(Projections.rowCount());

		return (Long) criteria.uniqueResult();
	}


	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<T> findAll() {  

		return getSession().createQuery( "from " + classType.getName()).list();
	}


	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<T> find(int firstResult, int maxResults) {
		Criteria criteria = getSession().createCriteria(classType);

		criteria.addOrder(Order.asc("id"));

		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResults);

		return criteria.list();
	}	


	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<T> find(String propertyName, Object value){
		return getSession().createCriteria(classType).add(Restrictions.eq(propertyName, value)).list();
	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<T> find(Object search, String field, String filter, int firstResult, int maxResults) {

		Criteria criteria = getSession().createCriteria(classType);

		criteria.add(getFilter(filter, field, search));
		criteria.addOrder(Order.asc(field));

		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResults);	
		
		return (List<T>) criteria.list();
	}


	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<T> find(int firstResult, int maxResults, String orderBy) {
		Criteria criteria = getSession().createCriteria(classType);

		criteria.addOrder(Order.asc(orderBy));

		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResults);

		return criteria.list();
	}	


	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<T> findForWhereClause(String where, int firstResult, int maxResults){
		
		return getSession().createQuery( "from " + classType.getName() + " where " + where ).list();
		
	}	
}
