package daos.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daos.interfaces.LeagueDAO;
import model.League;
import model.Match;
import model.Player;

public class LeagueDAOImpl extends HibernateDaoSupport implements LeagueDAO{

	
	
	
	@Override
	public List<League> obtainLeagues() {
		List<League> list = (List<League>) getHibernateTemplate().execute(new HibernateCallback<List<League>>(){

			@SuppressWarnings("unchecked")
			public List<League> doInHibernate(Session session) throws HibernateException, SQLException {
				return (List<League>) session.createCriteria(League.class).list();
			}			
	});
		return list;
	}

	@Override
	public League createLeague(String name, int maxPlayers, int minPlayers) {
		League l = new League(name, maxPlayers, minPlayers);
		getHibernateTemplate().save(l);
		getHibernateTemplate().flush();
		return l;
	}

	@Override
	public void editLeague(final Integer id, final String name,final Integer maxPlayers,final Integer minPlayers) {
		this.getHibernateTemplate().execute(new HibernateCallback<League>() {

			@Override
			public League doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(League.class);
				criteria.add(Restrictions.eq("id", id));
				League l = (League) criteria.uniqueResult();
				l.editWith(name,maxPlayers,minPlayers);
				session.update(l);
				session.flush();
				return null;
			}
		});
		
	}

	@Override
	public void save(League l) {
		this.getHibernateTemplate().saveOrUpdate(l);
		getHibernateTemplate().flush();
	}

	@Override
	public void deleteById(final int id) {
		this.getHibernateTemplate().execute(new HibernateCallback<League>() {

			@Override
			public League doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(League.class);
				criteria.add(Restrictions.eq("id", id));
				League l = (League) criteria.uniqueResult();
				session.delete(l);
				session.flush();
				return null;
			}
		});
		
	}

	@Override
	public League obtainLeagueById(int idLeague) {
		DetachedCriteria criteria = DetachedCriteria.forClass(League.class);
		criteria.add(Restrictions.eq("id", idLeague));
		return (League) this.getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	@Override
	public void insertMatch(Match match) {
		this.getHibernateTemplate().save(match);
		this.getHibernateTemplate().flush();
		
	}
  
	

	
	
}
