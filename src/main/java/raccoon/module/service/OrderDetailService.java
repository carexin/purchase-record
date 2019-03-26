package raccoon.module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raccoon.module.bean.entity.Order;
import raccoon.module.bean.entity.OrderDetail;
import raccoon.module.bean.param.OrderDetailNoPageParams;
import raccoon.module.mapper.OrderDetailDAO;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderDetailService {

  @Autowired
  private OrderDetailDAO orderDetailDAO;

  public List<OrderDetail> listNoPage(OrderDetailNoPageParams params) {
    List<OrderDetail> orderList = orderDetailDAO.listByParams(params);
    return orderList;
  }
}
