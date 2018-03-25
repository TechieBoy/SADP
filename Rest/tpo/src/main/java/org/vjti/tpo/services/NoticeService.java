package org.vjti.tpo.services;

import java.util.ArrayList;
import java.util.Map;

import org.vjti.tpo.database.DatabaseClass;
import org.vjti.tpo.model.Notice;

public class NoticeService {

	private static Map<Long,Notice> notices=DatabaseClass.getNotices();
	
	public ArrayList<Notice> getNotices()
	{
		return new ArrayList<Notice>( notices.values());
	}
	
	public Notice getNotice(Long id){
		
		return notices.get(id);
	}
	
	
	public boolean addNotice(Notice n)
	{
		n.setId((long) (notices.size()+1));
		notices.put(n.getId(),n);
		return true;
		
		
	}
	public boolean updateNotice(Notice n)
	{
		if (n.getId() <= 0) {
			return false;
		}
		notices.put(n.getId(),n);
		return true;
	}
	public boolean removeNotice(Long id)
	{
		Notice n= notices.remove(id);
		if(n==null)
			return false;
		return true;
	}
}
