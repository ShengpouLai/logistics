package com.lsp.logistics.util;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * BaseHibernateDao是一个抽象类<br>
 * 
 * 调用了HibernateSessionFactory类. <br>
 * BaseHibernateDao类通过getSession()、closeSession()两个方法，
 * 调用HibernateSessionFactory.
 * getSession()和HibernateSessionFactory.closeSession()， 实现了session的获取和关闭，
 * 通过在Hibernate中获得session，调用session中的方法对数据进行持久化在操作和查询操作。
 * DAO实现类通过继承BaseHibernateDao抽象类，实现各自对数据库的操作.
 * 
 * @see HibernateSessionFactory
 * @see Session
 * 
 * @author Administrator.
 */
public abstract class BaseHibernateDao extends HibernateDaoSupport {

	/**
	 * 
	 * 根据ID获取对应Class类中的一条特定值.
	 * 一个Hibernate.session自带的查询方法，通过Class类中的唯一值主键去查找某一条特定的实体类。
	 * 
	 * @param clz
	 *            一个持久类.
	 * @param id
	 *            一个主键标记.
	 * @see Session
	 * @return Object 如果获取成功，返回一个对应Class的Object值.
	 * @throws Exception
	 *             如果获取数据失败.
	 */
	public Object get(Class clz, java.io.Serializable id) {
		return getHibernateTemplate().get(clz, id);
	}

	/**
	 * 
	 * 添加一个实体对象到数据库持久化的操作. 系统调用Session中save()的方法，将传入的实体对象持久化到数据中。 <br>
	 * 通过事务控制，保证数据的正确性。session.save(item)执行成功就调用commit否者rollbacak 抛出Exception.
	 * 
	 * @param item
	 *            一个持久类的Object实例
	 * @see Session
	 * @see Transaction
	 * @return boolean 如果添加成功，返回true，添加失败，返回false.
	 * @throws Exception
	 *             如果数据添加失败
	 */
	public boolean add(Object item) {
		try {
			getHibernateTemplate().save(item);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 将一个实体对象更新到数据库. 系统调用Session中update()的方法，将传入的实体对象更新到持久化的数据库中。 <br>
	 * 通过事务控制，保证数据的正确性。session.update(item)执行成功就调用commit否者rollbacak 抛出Exception.
	 * 
	 * @param item
	 *            一个持久类的Object实例
	 * @see Session
	 * @see Transaction
	 * @return boolean 如果更新成功，返回true，更新失败，返回false.
	 * @throws Exception
	 *             如果更新数据失败
	 */
	public boolean update(Object item) {
		try {
			getHibernateTemplate().update(item);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 将一个特定的实体对象从数据库中删除. 系统调用Session中delete()的方法，在持久化数据库中找出传入的实体数据，
	 * 删除数据库中与该实体数据对应的信息。 <br>
	 * 通过事务控制，保证数据的正确性。session.delete(item)执行成功就调用commit否者rollbacak 抛出Exception.
	 * 
	 * 
	 * @param item
	 *            一个持久类的Object实例
	 * @see Session
	 * @see Transaction
	 * @return boolean 如果删除成功，返回true，删除失败，返回false.
	 * @throws Exception
	 *             如果删除数据失败.
	 */
	public boolean delete(Object item) {
		try {
			getHibernateTemplate().delete(item);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 通过HQL语句删除数据. 编译器通过createQuery（sql）识别SQL语句，executeUpdate()执行SQL命令，
	 * 达到删除数据的效果。 <br>
	 * 通过事务控制，保证数据的正确性。session.createQuery(sql).executeUpdate()
	 * 执行成功就调用commit否者rollbacak 抛出Exception.
	 * 
	 * @param sql
	 *            一个字符串，检查是否符合HQL语句的编写规范.
	 * @see Session
	 * @see Transaction
	 * @return 如果删除成功，返回true，删除失败，返回false.
	 * @throws Exception
	 *             如果解析HQL语句或者读取数据库失败.
	 */
	public boolean deleteByQuery(String hql) {
		 
		int i=getHibernateTemplate().bulkUpdate(hql);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 执行HQL语句的查询操作.
	 * 
	 * <pre>
	 * this.getHibernateTemplate().find(&quot;from bean.User&quot;);
	 * </pre>
	 * 
	 * @param hql
	 *            传入的hql语句.
	 * @return List 查询得到的结果.
	 */
	public List findByHQL(String hql) {
		return getHibernateTemplate().find(hql);
	}

	/**
	 * 通过SQL语句查询数据. 编译器通过createSQLQuery(sql)识别SQL语句，
	 * 执行SQL命令获取SQL语句查询得出的数据，表示为List<Object[]>.
	 * 
	 * @param sql
	 *            一个字符串，检查是否符合SQL语句的编写规范.
	 * @see Session
	 * @return List 如果查询成功，返回包含查询得到的所有数据的List.
	 * @throws RuntimeException
	 *             如果查询数据失败.
	 */
	public List findByQuerySQL(String sql) {
		return getSession().createSQLQuery(sql).list();
	}

	/**
	 * 读取所有数据. 根据用户给与的一个持久类，编译器创建一个新的标准实例， 获取该持久类中的数据到实体中，通过List保存获取的实体数据.
	 * 
	 * @param clazz
	 *            一个持久类.
	 * @return List 包含获取的所有实体数据.
	 * @throws RuntimeException
	 *             如果获取数据失败.
	 */
	public List readAll() {
		return getHibernateTemplate().find(null);
	}
	
	/**
	 * 通过实体对象的一般属性条件，进行查找(即在表中通过一般字段来查找记录)
	 * 
	 * @param clazz
	 *            指定的实体对象类型
	 * @param condition
	 *            将查询条件封装到实体对象中
	 * @return 返回查询出的实体对象的列表
	 */
	public List search(Class clazz, Object condition) {
			return getSession().createCriteria(clazz).add(Example.create(condition)).list();
	}


}
