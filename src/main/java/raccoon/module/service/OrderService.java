package raccoon.module.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Objects;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raccoon.module.bean.dto.OrderDTO;
import raccoon.module.bean.dto.OrderDetailDTO;
import raccoon.module.bean.entity.Order;
import raccoon.module.bean.entity.OrderDetail;
import raccoon.module.bean.param.OrderParam;
import raccoon.module.mapper.OrderDAO;
import raccoon.module.mapper.OrderDetailDAO;
import raccoon.utils.UUIDUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService {

  @Autowired
  private OrderDAO orderDAO;

  @Autowired
  private OrderDetailDAO orderDetailDAO;

  public String add(OrderDTO dto) {
    Order order = new Order();

    BeanUtils.copyProperties(dto, order);
    order.setOrderId(UUIDUtils.getUUID());

    // todo 如何抛出异常?
    Integer orderResult = orderDAO.insertSelective(order);

    if (null == dto.getOrderDetailDTOList()) {
      dto.setOrderDetailDTOList(new ArrayList<>());
    }

    for (OrderDetailDTO detailDTO : dto.getOrderDetailDTOList()) {
      OrderDetail detail = new OrderDetail();

      BeanUtils.copyProperties(detailDTO, detail);

      detail.setOrderId(order.getOrderId());
      detail.setDetailId(UUIDUtils.getUUID());
      orderDetailDAO.insertSelective(detail);
    }
    return order.getOrderId();
  }

  public String update(OrderDTO dto) {
    Order order = new Order();

    BeanUtils.copyProperties(dto, order);
    Integer orderResult = orderDAO.updateByPrimaryKeySelective(order);

    if (null == dto.getOrderDetailDTOList()) {
      dto.setOrderDetailDTOList(new ArrayList<>());
    }

    for (OrderDetailDTO detailDTO : dto.getOrderDetailDTOList()) {

      OrderDetail detail = new OrderDetail();
      BeanUtils.copyProperties(detailDTO, detail);

      if(null == detail.getDetailId()){
        detail.setOrderId(dto.getOrderId());
        detail.setDetailId(UUIDUtils.getUUID());
        orderDetailDAO.insertSelective(detail);
      } else {
        orderDetailDAO.updateByPrimaryKeySelective(detail);
      }
    }
    return order.getOrderId();
  }

  public PageInfo<Order> list(OrderParam params) {
    PageHelper.startPage(params.getPageNum(), params.getPageSize());
    List<Order> list = orderDAO.selectByParams(params);
    //用PageInfo对结果进行包装
    PageInfo page = new PageInfo(list);
    return page;
  }

  public Order getOrderById(String orderId) {
    return orderDAO.selectByPrimaryKey(orderId);
  }


}
