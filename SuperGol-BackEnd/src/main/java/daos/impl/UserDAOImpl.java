package daos.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daos.interfaces.UserDAO;
import model.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	
	@Override
	public void save(User usr) {
		this.getHibernateTemplate().save(usr);
		this.getHibernateTemplate().flush();
	}

}
