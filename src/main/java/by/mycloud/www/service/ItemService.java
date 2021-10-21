package by.mycloud.www.service;

import java.util.List;

import by.mycloud.www.entity.Depo;
import by.mycloud.www.entity.Sector;
import by.mycloud.www.entity.StandartSearchItem;

public interface ItemService {

	List<StandartSearchItem> listStandartSearchItem(StandartSearchItem standartSearchItem);

	List<Depo> getDepoList();

	List<Sector> getSectorList(Depo depoUI);
	

}
