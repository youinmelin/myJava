package lin.service.impl;

import lin.dao.IItemsDao;
import lin.domain.Items;
import lin.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl  implements IItemService {

    @Autowired(required=true)
    private IItemsDao itemsDao;

    @Override
    public Items findItemById(Integer id) {
        Items item = itemsDao.findItemById(id);
        return item;
    }
}
