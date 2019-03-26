package raccoon.module.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import raccoon.PurchaseRecordApplicationTests;
import raccoon.module.bean.dto.OrderDTO;
import raccoon.module.bean.dto.OrderDetailDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceTest extends PurchaseRecordApplicationTests {

  @Autowired
  private OrderService orderService;

  @Test
  @Transactional
  public void add() {
    OrderDTO dto = new OrderDTO();

    dto.setFreight(BigDecimal.valueOf(12.22));
    dto.setRemarks("1232123");
    dto.setSupplierId(1);
    dto.setTotalPrice(BigDecimal.valueOf(131.12));

    List<OrderDetailDTO> detailDTOS = new ArrayList<>();
    OrderDetailDTO detailDTO = new OrderDetailDTO();
    detailDTO.setAmount(BigDecimal.valueOf(12.12));
    detailDTO.setDetailPrice(BigDecimal.valueOf(12.12));
    detailDTO.setGoodsName("名称");
    detailDTO.setRemarks("备注");
    detailDTO.setUnitPrice(BigDecimal.valueOf(12.12));
    detailDTO.setOrderId("ewq-wqe-qwe-qwe");

    orderService.add(dto);
  }
}