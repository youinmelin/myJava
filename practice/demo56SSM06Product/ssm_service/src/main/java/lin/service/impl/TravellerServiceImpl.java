package lin.service.impl;

import lin.dao.ITravellerDao;
import lin.domain.Traveller;
import lin.service.ITravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravellerServiceImpl implements ITravellerService{

    @Autowired
    ITravellerDao travellerDao;

    @Override
    public List<Traveller> findTravellersByOrderId(Integer oId) {
        List<Traveller> travellers = travellerDao.findTravellersByOrderId(oId);
        return travellers;
    }
}
