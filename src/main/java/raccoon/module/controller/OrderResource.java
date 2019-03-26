package raccoon.module.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import raccoon.module.bean.dto.OrderDTO;
import raccoon.module.bean.dto.OrderDetailDTO;
import raccoon.module.bean.entity.Order;
import raccoon.module.bean.form.OrderDetailForm;
import raccoon.module.bean.form.OrderForm;
import raccoon.module.bean.param.OrderParam;
import raccoon.module.service.OrderService;
import raccoon.utils.ResultVO;
import raccoon.utils.ResultVOUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@Slf4j
@Api(tags = {"订单-接口"})
public class OrderResource {

  @Autowired
  private OrderService orderService;

  @PostMapping
  @ApiOperation(value = "添加订单", notes = "添加订单时指定具体商品, 订单和商品将同时添加")
  public ResultVO<String> add(@RequestBody @ApiParam(
          name = "订单form",
          value = "传入json格式",
          required = true) OrderForm orderForm) {

    log.info("OrderResource.add() " + orderForm.toString());

    //todo 优化form转dto
    OrderDTO dto = new OrderDTO();
    BeanUtils.copyProperties(orderForm, dto);

    List<OrderDetailDTO> detailDTOS = new ArrayList<>();

    for (OrderDetailForm orderDetailForm : orderForm.getOrderDetailFormList()) {
      OrderDetailDTO detailDTO = new OrderDetailDTO();
      BeanUtils.copyProperties(orderDetailForm, detailDTO);
      detailDTOS.add(detailDTO);
    }

    dto.setOrderDetailDTOList(detailDTOS);

    String orderId = orderService.add(dto);

    return ResultVOUtil.success(orderId);
  }

  @PutMapping
  @ApiOperation(value = "更新订单(包含detail)", notes = "orderId是更新时的必填项, detailId有则为更新, 否则为新增, " +
          "此更新不能用于删除detail, 删除detail请调用单独的方法.")
  public ResultVO<String> update(@RequestBody @ApiParam(
          name = "订单form",
          value = "传入json格式",
          required = true) OrderForm orderForm) {

    log.info("OrderResource.update() " + orderForm.toString());
    OrderDTO dto = new OrderDTO();
    BeanUtils.copyProperties(orderForm, dto);

    List<OrderDetailDTO> detailDTOS = new ArrayList<>();

    for (OrderDetailForm orderDetailForm : orderForm.getOrderDetailFormList()) {
      OrderDetailDTO detailDTO = new OrderDetailDTO();
      BeanUtils.copyProperties(orderDetailForm, detailDTO);
      detailDTOS.add(detailDTO);
    }

    dto.setOrderDetailDTOList(detailDTOS);

    String orderId = orderService.update(dto);

    return ResultVOUtil.success(orderId);
  }

  @GetMapping
  @ApiOperation(value = "分页查询supplier", notes = "默认显示10条")
  public ResultVO<PageInfo<Order>> list(OrderParam orderParam) {
    PageInfo<Order> orderPageInfo = orderService.list(orderParam);
    return ResultVOUtil.success(orderPageInfo);
  }

  @GetMapping("/{orderId}")
  public ResultVO<Order> getOrder(@PathVariable @ApiParam(name = "订单id",
          value = "string",
          required = true) String orderId) {
    Order order = orderService.getOrderById(orderId);

    return ResultVOUtil.success(order);
  }


}
