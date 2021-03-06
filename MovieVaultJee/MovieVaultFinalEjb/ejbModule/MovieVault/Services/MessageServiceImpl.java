package MovieVault.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import MovieVault.Persistence.Message;

import MovieVault.Persistence.Admin;

@Stateless

public class MessageServiceImpl implements MessageServiceRemote{
	
	@PersistenceContext
	private EntityManager em;


	public void addMessage(Message m) {
		em.persist(m);
	}

	@Override
	public List<Message> finAllMessage() {
		return em.createQuery("select p from Message p").getResultList();

	}

	public List<Message> listMessageByUser(Admin admin) {
return em.createQuery("select m from Message m where m.pReceive.id=:c").setParameter("c", admin.getId()).getResultList();
//	return em.createQuery("select m from Message m").getResultList();

	}
	
	public List<Message> getMessageByClents(int id1, int id2)
	{ 
		Query query =em.createQuery("select e  from Message e where ((e.pSend.id=:idA and e.pReceive.id=:idB)OR (e.pSend.id=:idB and e.pReceive.id=:idA))order by e.date");
        
		query.setParameter("idA", id1);
		query.setParameter("idB", id2);
		return query.getResultList();
		
		
		
	}

	
	
	

}
