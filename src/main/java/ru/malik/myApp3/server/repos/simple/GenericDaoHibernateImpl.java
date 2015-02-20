package ru.malik.myApp3.server.repos.simple;

import com.sencha.gxt.data.shared.SortDir;
import com.sencha.gxt.data.shared.SortInfo;
import com.sencha.gxt.data.shared.loader.FilterConfig;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Малик on 04.11.2014.
 */
public class GenericDaoHibernateImpl<T, PK extends Serializable> implements GenericDao<T, PK>, FinderExecutor {
    private Class<T> type;
    private SessionFactory sessionFactory;

    public GenericDaoHibernateImpl(Class<T> type) {
        this.type = type;
    }

    public PK create(T o) {
        return (PK) getSession().save(o);
    }

    public T read(PK id) {
        return (T) getSession().get(type, id);
    }

    public void update(T o) {
        getSession().update(o);
    }

    @Override
    public void saveOrUpdate(T o) {
        getSession().saveOrUpdate(o);
    }

    public void delete(T o) {
        getSession().delete(o);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {

        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<T> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(type).list();
    }

    @Override
    public List<T> getAll(int start, int range) {

        return sessionFactory.getCurrentSession().createCriteria(type).setFirstResult(start).setMaxResults(range).list();
    }

    public List<T> getAll(int start, int range, List<? extends SortInfo> sortInfos, List<? extends FilterConfig> filterConfigs) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(type);
        criteria = criteria.setFirstResult(start).setMaxResults(range);

        for (int i = 0; i < sortInfos.size(); i++) {
            SortInfo sf = sortInfos.get(i);
            if (sf.getSortDir().equals(SortDir.ASC)) {
                criteria = criteria.addOrder(Order.asc(sf.getSortField()));
            } else {
                criteria = criteria.addOrder(Order.desc(sf.getSortField()));
            }
        }

        for (int i = 0; i < filterConfigs.size(); i++) {
            FilterConfig fc = filterConfigs.get(i);
            if ("string".equals(fc.getType().toLowerCase())) {
                Criterion cr = Restrictions.like(fc.getField(), fc.getValue());
                criteria.add(cr);
            }

        }

        return criteria.list();
    }

    @Override
    public Long count() {
        return (Long) sessionFactory.getCurrentSession().createCriteria(type).setProjection(Projections.rowCount()).uniqueResult();
    }

    public List<T> executeFinder(Method method, final Object[] queryArgs) {
        final String queryName = queryNameFromMethod(method);
        final Query namedQuery = getSession().getNamedQuery(queryName);
        String[] namedParameters = namedQuery.getNamedParameters();
        for (int i = 0; i < queryArgs.length; i++) {
            Object arg = queryArgs[i];
            namedQuery.setParameter(i, arg);
        }

        return (List<T>) namedQuery.list();
    }

    public String queryNameFromMethod(Method finderMethod) {
        return type.getName() + "." + finderMethod.getName();
    }
}