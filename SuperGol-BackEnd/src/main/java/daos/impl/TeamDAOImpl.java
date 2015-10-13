package daos.impl;

import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daos.interfaces.TeamDAO;
import exceptions.TeamDoesntExistException;
import model.Team;

public class TeamDAOImpl extends HibernateDaoSupport implements TeamDAO{

	@Override
	public void saveTeam(Team t) {
		this.getHibernateTemplate().save(t);
		this.getHibernateTemplate().flush();		
	}

	@Override
	public Team getTeamByName(final String name) {
		try{
			Team t = this.getHibernateTemplate().execute(new HibernateCallback<Team>(){
				
				@Override
				public Team doInHibernate(Session session) throws HibernateException, SQLException {
					Criteria criteria = session.createCriteria(Team.class);
					criteria.add(Restrictions.eq("name",name));
					return (Team)criteria.uniqueResult();
				}
			});
			return t;
		}catch(Exception e){
			throw new TeamDoesntExistException("There's no team with name: "+ name);
		}
	}

	@Override
	public void deleteTeam(Team t) {
		this.getHibernateTemplate().delete(t);		
	}

}
