package raccoon.module.bean.dto;

import lombok.Builder;
import lombok.Data;
import raccoon.module.bean.entity.OrderDetail;

import java.math.BigDecimal;

@Data
@Builder
public class OrderDetailDTO {
  private String detailId;
  private String goodsName;
  private BigDecimal amount;
  private BigDecimal unitPrice;
  private BigDecimal detailPrice;
  private Byte detailStatus;
  private String orderId;
  private String remarks;

  public OrderDetail getEntity() {
    return OrderDetail.builder()
            .detailId(detailId)
            .goodsName(goodsName)
            .amount(amount)
            .unitPrice(unitPrice)
            .detailPrice(detailPrice)
            .detailStatus(detailStatus)
            .orderId(orderId)
            .remarks(remarks)
            .build();
  }

}
