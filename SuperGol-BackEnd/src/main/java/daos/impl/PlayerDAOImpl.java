package daos.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daos.interfaces.PlayerDAO;
import model.Player;

public class PlayerDAOImpl  extends HibernateDaoSupport implements PlayerDAO {

	@Override
	public void savePlayer(Player pl) {
		Session session = this.getSession();
		session.saveOrUpdate(pl);
	}

	@Override
	public Player searchPlayerByName(String name) {
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(Player.class);
		criteria.add(Restrictions.eq("name",name));
		return (Player) criteria.uniqueResult();
	}

}
