package raccoon.module.bean.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;
  private String orderId;
  private BigDecimal freight;
  private BigDecimal totalPrice;
  private Byte orderStatus;
  private String supplierId;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
  private String remarks;

}