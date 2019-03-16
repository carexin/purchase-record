package raccoon.module.bean.form;

import lombok.Data;
import raccoon.module.bean.dto.OrderDetailDTO;

import java.math.BigDecimal;

@Data
public class OrderDetailForm {
  private String detailId;
  private String goodsName;
  private BigDecimal amount;
  private BigDecimal unitPrice;
  private BigDecimal detailPrice;
  private Byte detailStatus;
  private String orderId;
  private String remarks;

  /**
   * 设计成对象的方法, 获取到form对象就能够获取到其dto对象
   * <p>
   * 返回新的对象即可, 而不是别人持有的对象的引用.
   *
   * @return
   */
  public OrderDetailDTO getDTO() {
    return OrderDetailDTO.builder()
            .detailId(this.detailId)
            .goodsName(this.goodsName)
            .amount(this.amount)
            .unitPrice(this.unitPrice)
            .detailPrice(this.detailPrice)
            .detailStatus(this.detailStatus)
            .orderId(this.orderId)
            .remarks(this.remarks)
            .build();
    // build() 方法将创建新的对象.
  }
}
