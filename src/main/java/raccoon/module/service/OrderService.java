package raccoon.module.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raccoon.module.bean.dto.OrderDTO;
import raccoon.module.bean.dto.OrderDetailDTO;
import raccoon.module.bean.entity.Order;
import raccoon.module.bean.entity.OrderDetail;
import raccoon.module.mapper.OrderDAO;
import raccoon.module.mapper.OrderDetailDAO;

import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService {

  @Autowired
  private OrderDAO orderDAO;

  @Autowired
  private OrderDetailDAO orderDetailDAO;

  public String add(OrderDTO dto) {
    Order order = new Order();
    order.setOrderId(UUID.randomUUID().toString());
    BeanUtils.copyProperties(dto, order);

    // todo 如何抛出异常?
    Integer orderResult = orderDAO.insertSelective(order);

    for (OrderDetailDTO detailDTO : dto.getOrderDetailDTOList()) {
      OrderDetail detail = new OrderDetail();
      detail.setDetailId(UUID.randomUUID().toString());
      BeanUtils.copyProperties(detailDTO, detail);
      orderDetailDAO.insertSelective(detail);
    }
    return order.getOrderId();
  }
}
