package raccoon.module.bean.form;

import lombok.Data;
import raccoon.module.bean.dto.OrderDTO;
import raccoon.module.bean.dto.OrderDetailDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderForm {

  private String orderId;
  private BigDecimal freight;
  private BigDecimal totalPrice;
  private Byte orderStatus;
  private String supplierId;
  private String remarks;

  private List<OrderDetailForm> orderDetailFormList;

  public OrderDTO getDTO() {

    List<OrderDetailDTO> detailDTOList = new ArrayList<>();

    for (OrderDetailForm form : this.getOrderDetailFormList()) {
      detailDTOList.add(form.getDTO());
    }

    return OrderDTO.builder()
            .orderId(this.getOrderId())
            .freight(this.getFreight())
            .totalPrice(this.totalPrice)
            .orderStatus(this.orderStatus)
            .supplierId(this.supplierId)
            .remarks(this.remarks)
            .orderDetailDTOList(detailDTOList)
            .build();
  }

}
