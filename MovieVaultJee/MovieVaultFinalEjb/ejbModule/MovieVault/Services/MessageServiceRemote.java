package MovieVault.Services;


import java.util.List;

import javax.ejb.Local;

import MovieVault.Persistence.Message;

import MovieVault.Persistence.Admin;

@Local
public interface MessageServiceRemote{
  public void addMessage(Message m);
	public List<Message> finAllMessage();
	public List<Message> listMessageByUser(Admin admin);
	public List<Message> getMessageByClents(int id1, int id2);	

	

}