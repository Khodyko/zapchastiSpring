package by.mycloud.www.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.mycloud.www.dao.ItemDao;
import by.mycloud.www.entity.StandartSearchItem;
import by.mycloud.www.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;

	@Override
	public List<StandartSearchItem> listStandartSearchItem(StandartSearchItem standartSearchItem) {
		List<StandartSearchItem> items= itemDao.listStandartSearchItem(standartSearchItem);
		return items;
	}

}
