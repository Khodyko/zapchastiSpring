package by.mycloud.www.dao.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.mycloud.www.dao.ItemDao;
import by.mycloud.www.entity.Depo;
import by.mycloud.www.entity.StandartSearchItem;

@Repository
public class ItemDaoImpl implements ItemDao {
	final private static String QUERY_GET_STANDART_SEARCH_LIST = "FROM StandartSearchItem WHERE name LIKE  :name AND nn LIKE :nn AND nnSap LIKE :nnSap";
	final private static String QUERY_GET_DEPO_LIST = "FROM Depo";
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<StandartSearchItem> listStandartSearchItem(StandartSearchItem standartSearchItem) {
		Session session = sessionFactory.getCurrentSession();

		List<StandartSearchItem> items = (List<StandartSearchItem>) session.createQuery(QUERY_GET_STANDART_SEARCH_LIST)
				.setParameter("name", likeString(standartSearchItem.getName()))
				.setParameter("nn", likeString(standartSearchItem.getNn()))
				.setParameter("nnSap", likeString(standartSearchItem.getNnSap())).setFirstResult(1).setMaxResults(30)
				.list();

		return items;
	}

	String likeString(String string) {

		return "%" + string + "%";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Depo> getDepoList() {
		Session session = sessionFactory.getCurrentSession();
		List<Depo> depoList = (List<Depo>) session.createQuery(QUERY_GET_DEPO_LIST).list();
		System.out.println("depolist: "+depoList);
		return depoList;
	}

}