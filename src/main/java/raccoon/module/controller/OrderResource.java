package raccoon.module.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import raccoon.utils.ResultVO;
import raccoon.module.bean.form.OrderForm;
import raccoon.utils.ResultVOUtil;

@RestController
@RequestMapping("/api/order")
public class OrderResource {

  /**
   * 添加order记录
   * <p>
   * order通过supplier_id与supplier关联
   * 可通过supplier_id 查出在此supplier下订购了多少次
   * 【OrderDetail明细】 名称、数量、单价、总价
   */
  @PostMapping
  public ResultVO add(OrderForm orderForm) {


    //添加成功, 返回保存的这条数据的主键.
    return ResultVOUtil.success();
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
