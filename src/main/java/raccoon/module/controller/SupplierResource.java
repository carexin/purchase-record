package raccoon.module.controller;

import com.github.pagehelper.PageInfo;
import raccoon.module.bean.entity.Supplier;
import raccoon.module.bean.SupplierSelectParams;
import raccoon.module.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
@Slf4j
public class SupplierResource {

  private SupplierService supplierService;

  public SupplierResource(SupplierService supplierService) {
    this.supplierService = supplierService;
  }


  /**
   * 保存经销商
   *
   * @return
   */
  @PostMapping("/save")
  public Supplier insert(@RequestBody Supplier supplier) {
    return supplierService.supplierAdd(supplier);
  }

  /**
   * 查询经销商
   *
   * @return
   */
  @GetMapping("/select")
  public PageInfo<Supplier> select(SupplierSelectParams params) {
    return supplierService.list(params);
  }

  /**
   * todo 更新
   */

  /**
   * todo 删除
   */


}
