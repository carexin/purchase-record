package raccoon.module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raccoon.module.bean.form.OrderForm;
import raccoon.module.mapper.OrderDAO;
import raccoon.module.mapper.OrderDetailDAO;

import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService {

  @Autowired
  private OrderDAO orderDAO;

  @Autowired
  private OrderDetailDAO orderDetailDAO;

  /**
   * @param orderForm
   * @return orderId
   */
  public Optional<Integer> add(OrderForm orderForm) {



    return Optional.empty();
  }
}
