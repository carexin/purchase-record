package raccoon.module.bean.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailForm {

  @ApiModelProperty(value = "id", example = "111-111-111-11")
  private String detailId;

  @ApiModelProperty(value = "商品名称", example = "倚天剑")
  private String goodsName;

  @ApiModelProperty(value = "总价", example = "44.22")
  private BigDecimal amount;

  @ApiModelProperty(value = "单价", example = "12.22")
  private BigDecimal unitPrice;

  @ApiModelProperty(value = "价格", example = "50.22")
  private BigDecimal detailPrice;

  @ApiModelProperty(hidden = true)
  private Byte detailStatus;

  @ApiModelProperty(value = "订单id", example = "11-1-1-1-1-1")
  private String orderId;

  @ApiModelProperty(value = "备注", example = "这是备注")
  private String remarks;

}
