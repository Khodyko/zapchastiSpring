package by.mycloud.www.dao;

import java.util.List;

import by.mycloud.www.entity.Depo;
import by.mycloud.www.entity.Sector;
import by.mycloud.www.entity.StandartSearchItem;

public interface ItemDao {

	List<StandartSearchItem> listStandartSearchItem(StandartSearchItem standartSearchItem);

	List<Depo> getDepoList();

	List<Sector> getSectorList(Integer depoUI);

	Depo getDepoById(Integer Id);

	Sector getSectorById(Integer Id);

}
