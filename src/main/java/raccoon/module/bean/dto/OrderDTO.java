package raccoon.module.bean.dto;

import lombok.Builder;
import lombok.Data;
import raccoon.module.bean.entity.Order;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class OrderDTO {

  private String orderId;
  private BigDecimal freight;
  private BigDecimal totalPrice;
  private Byte orderStatus;
  private String supplierId;
  private String remarks;

  private List<OrderDetailDTO> orderDetailDTOList;

  public Order getEntity() {
    return Order.builder()

            .build();
  }

}
