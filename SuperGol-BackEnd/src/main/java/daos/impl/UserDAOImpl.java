package daos.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daos.interfaces.UserDAO;
import exceptions.PlayerDoesntExistException;
import model.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	
	@Override
	public void save(User usr) {
		this.getHibernateTemplate().save(usr);
		this.getHibernateTemplate().flush();
	}

	@Override
	public User obtainUser(final String userName) throws PlayerDoesntExistException {
		
		User u = this.getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("FROM User u WHERE USERNAME = :username");
				query.setString("username", userName);
				return (User) query.uniqueResult();
			}
		});
		if (u == null){
			throw new PlayerDoesntExistException("User does not exist! or It has a team already!");
		}
		return u;
		
	}

	@Override
	public void deleteUser(User u1) {
		this.getHibernateTemplate().delete(u1);
		this.getHibernateTemplate().flush();
	}

}
