package raccoon.module.bean.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel(value = "OrderForm", description = "订单(包含订单详情)")
public class OrderForm {

  @ApiModelProperty(value = "主键id, 添加时不需要给, 更新时需要传入id")
  private String orderId;

  @ApiModelProperty(value = "运费", example = "44.5")
  private BigDecimal freight;

  @ApiModelProperty(value = "总价", example = "1110.2")
  private BigDecimal totalPrice;

  @ApiModelProperty(hidden = true)
  private Byte orderStatus;

  @ApiModelProperty(value = "经销商id", example = "1")
  private String supplierId;

  @ApiModelProperty(value = "备注", example = "油价上涨, 导致运费变高.")
  private String remarks;

  private List<OrderDetailForm> orderDetailFormList;

}
