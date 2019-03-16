package raccoon.module.bean.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class OrderDetail implements Serializable {

  private static final long serialVersionUID = 1L;
  private String detailId;
  private String goodsName;
  private BigDecimal amount;
  private BigDecimal unitPrice;
  private BigDecimal detailPrice;
  private Byte detailStatus;
  private String orderId;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
  private String remarks;

}