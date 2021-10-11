package by.mycloud.www.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.mycloud.www.dao.ItemDao;
import by.mycloud.www.entity.Item;
import by.mycloud.www.entity.StandartSearchItem;

@Repository
public class ItemDaoImpl implements ItemDao {

	
	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<StandartSearchItem> listStandartSearchItem(StandartSearchItem standartSearchItem) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		System.out.println("session is good");
		List<StandartSearchItem> items= currentSession.createQuery("FROM StandartSearchItem").setFirstResult(1).setMaxResults(5).list();
		
		
		System.out.println("lalala "+items);
		return items;
	}

}
