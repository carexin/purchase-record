package raccoon.module.bean.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailDTO {
  private String detailId;
  private String goodsName;
  private BigDecimal amount;
  private BigDecimal unitPrice;
  private BigDecimal detailPrice;
  private Byte detailStatus;
  private String orderId;
  private String remarks;

}
