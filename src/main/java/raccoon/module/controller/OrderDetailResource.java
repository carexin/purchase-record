package raccoon.module.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 动词+名词的形式 动词指的http方法GET, POST等
 *
 * GET /devices/ID/images：获取某个设备的所有图片
 * GET /devices/ID/images/ID：获取某个设备的某张图片（我们不提供改方法，有人认为没有意义的）
 */
@RestController
@RequestMapping("/api/order-detail")
@Slf4j
public class OrderDetailResource {

  @GetMapping
  public String demo(){
    return "123123";
  }



}
