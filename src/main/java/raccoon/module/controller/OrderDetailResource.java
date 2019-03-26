package raccoon.module.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import raccoon.module.bean.dto.OrderDTO;
import raccoon.module.bean.entity.OrderDetail;
import raccoon.module.bean.param.OrderDetailNoPageParams;
import raccoon.module.service.OrderDetailService;
import raccoon.utils.ResultVO;
import raccoon.utils.ResultVOUtil;

import java.util.List;

@RestController
@RequestMapping("/api/order-detail")
@Slf4j
@Api(tags = {"订单条目-接口"})
public class OrderDetailResource {

  @Autowired
  private OrderDetailService orderDetailService;

  @GetMapping("/no-page")
  @ApiOperation(value = "查出符合条件的所有detail", notes = "不分页")
  public ResultVO<List<OrderDetail>> listByOrderId(OrderDetailNoPageParams params) {
    if(null == params.getOrderId()) {
      return ResultVOUtil.error(10000,"至少要传入orderId");
    }
    List<OrderDetail> orders = orderDetailService.listNoPage(params);
    return ResultVOUtil.success(orders);
  }

  @DeleteMapping("/{detailId}")
  @ApiOperation(value = "删除一条detail", notes = "直接删除")
  public ResultVO<OrderDTO> delete(@PathVariable String detailId) {

    // todo 待实现
    return ResultVOUtil.success();
  }

//  @GetMapping
//  @ApiOperation(value = "分页查询detail", notes = "分页")
//  public ResultVO<OrderDTO> list() {
//
//    //todo 待实现
//    return ResultVOUtil.success();
//  }

}
