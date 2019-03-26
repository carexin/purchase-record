package raccoon.module.bean.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {

  private String orderId;
  private BigDecimal freight;
  private BigDecimal totalPrice;
  private Byte orderStatus;
  private Integer supplierId;
  private String remarks;

  private List<OrderDetailDTO> orderDetailDTOList;

}
