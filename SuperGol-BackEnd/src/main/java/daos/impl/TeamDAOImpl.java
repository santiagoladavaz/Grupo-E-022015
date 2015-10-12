package daos.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daos.interfaces.TeamDAO;
import model.Team;

public class TeamDAOImpl extends HibernateDaoSupport implements TeamDAO{

	@Override
	public void saveTeam(Team t) {
		this.getHibernateTemplate().save(t);
		this.getHibernateTemplate().flush();		
	}

}
