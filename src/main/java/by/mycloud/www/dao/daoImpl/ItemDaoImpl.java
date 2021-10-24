package by.mycloud.www.dao.daoImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.mycloud.www.dao.ItemDao;
import by.mycloud.www.entity.Depo;
import by.mycloud.www.entity.Sector;
import by.mycloud.www.entity.StandartSearchItem;

@Repository
public class ItemDaoImpl implements ItemDao {
	final private static String QUERY_GET_STANDART_SEARCH_LIST = "FROM StandartSearchItem WHERE name LIKE  :name AND nn LIKE :nn AND nnSap LIKE :nnSap";
	final private static String QUERY_GET_DEPO_LIST = "FROM Depo";
	/**
	 * 
	 */
	final private static String QUERY_GET_SECTOR_LIST_BY_DEPO_ID = "FROM Depo WHERE id_depo  = :depoUI";
	final private static String QUERY_GET_DEPO_BY_ID = "FROM Depo WHERE id_depo  = :depoUI";
	final private static String QUERY_GET_SECTOR_BY_ID = "FROM Sector WHERE id_sector  = :sectorUI";
	
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

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sector> getSectorList(Integer depoUI) {
		System.out.println("depoUI:"+ depoUI);
		Session session = sessionFactory.getCurrentSession();
		List<Depo> depoList = (List<Depo>) session.createQuery(QUERY_GET_SECTOR_LIST_BY_DEPO_ID)
				.setParameter("depoUI", depoUI)
				.list();
		
		List<Sector> sectorList=  new ArrayList(depoList.get(0).getSectors());
		System.out.println("sectorlist DAO: "+sectorList);
		System.out.println("concrete sector "+ sectorList.get(0).getName());
		
		return  sectorList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Depo getDepoById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Depo depo = (Depo)session.createQuery(QUERY_GET_DEPO_BY_ID)
				.setParameter("depoUI", id)
				.uniqueResult();
		return depo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Sector getSectorById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Sector sector = (Sector)session.createQuery(QUERY_GET_SECTOR_BY_ID)
				.setParameter("sectorUI", id)
				.uniqueResult();
		return sector;
	}
	
	

}