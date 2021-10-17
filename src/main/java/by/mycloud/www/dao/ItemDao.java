package by.mycloud.www.dao;

import java.util.List;

import by.mycloud.www.entity.Depo;
import by.mycloud.www.entity.StandartSearchItem;

public interface ItemDao {

	List<StandartSearchItem> listStandartSearchItem(StandartSearchItem standartSearchItem);

	List<Depo> getDepoList();

}
