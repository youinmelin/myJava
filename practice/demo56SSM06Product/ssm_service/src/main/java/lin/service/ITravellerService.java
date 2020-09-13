package lin.service;

import lin.domain.Traveller;

import java.util.List;

public interface ITravellerService {

    List<Traveller> findTravellersByOrderId(Integer oId);
}
