package daos.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daos.interfaces.PlayerDAO;
import exceptions.PlayerDoesntExistException;
import model.Player;

public class PlayerDAOImpl  extends HibernateDaoSupport implements PlayerDAO {

	@Override
	public void savePlayer(Player pl) {
		this.getHibernateTemplate().save(pl);
		this.getHibernateTemplate().flush();
	}

	@Override
	public Player searchPlayerByName(final String name) {
		try{
			Player pl =this.getHibernateTemplate().execute(new HibernateCallback<Player>(){
				public Player doInHibernate(Session session) throws HibernateException, SQLException {
					Criteria criteria = session.createCriteria(Player.class);
					criteria.add(Restrictions.eq("name", name));
					return (Player) criteria.uniqueResult();
				}
			});			
			return pl;
		}catch(Exception e){
			throw new PlayerDoesntExistException("No existe el jugador con nombre: " + name);
		}
	}

	@Override
	public void erase() {
		this.getHibernateTemplate().execute(new HibernateCallback<Player>(){
			public Player doInHibernate(Session session)throws HibernateException, SQLException{
				session.createSQLQuery("DELETE FROM PLAYER").executeUpdate();
				return null;
			}
		});
		
	}

	@Override
	public void delete(Player player) {
		this.getHibernateTemplate().delete(player);
		
	}

	@Override
	public List<Player> getAll() {
		List<Player> players = (List<Player>) this.getHibernateTemplate().execute(new HibernateCallback<List<Player>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<Player> doInHibernate(Session session) throws HibernateException, SQLException {
				return (List<Player>) session.createQuery("FROM PLAYER").list();
			}
			
		});
		return players;
	}

}
