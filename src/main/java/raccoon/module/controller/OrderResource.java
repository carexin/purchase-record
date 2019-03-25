package raccoon.module.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import raccoon.module.bean.dto.OrderDTO;
import raccoon.module.bean.form.OrderForm;
import raccoon.module.service.OrderService;
import raccoon.utils.ResultVO;
import raccoon.utils.ResultVOUtil;

@RestController
@RequestMapping("/api/order")
public class OrderResource {

  @Autowired
  private OrderService orderService;

  /**
   * 添加order记录
   * <p>
   * order通过supplier_id与supplier关联
   * 可通过supplier_id 查出在此supplier下订购了多少次
   * 【OrderDetail明细】 名称、数量、单价、总价
   */
  @PostMapping
  @ApiOperation(value = "添加订单", notes = "添加订单时指定具体商品, 订单和商品将同时添加")
  public ResultVO<String> add(@RequestBody @ApiParam(
          name = "订单form",
          value = "传入json格式",
          required = true) OrderForm orderForm) {

    OrderDTO dto = new OrderDTO();
    BeanUtils.copyProperties(orderForm, dto);
    String orderId = orderService.add(dto);

    return ResultVOUtil.success(orderId);
  }


  /**
   * todo 订单查询
   * 可按照各种参数进行查询
   */

  /**
   * todo 获取某个具体的order
   */

  /**
   * todo 获取某个具体order下的order_detail list
   */


}
