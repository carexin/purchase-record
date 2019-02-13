package org.liyd.app.web.rest;

import com.github.pagehelper.PageInfo;
import org.liyd.app.entity.Supplier;
import org.liyd.app.service.SupplierService;
import org.liyd.app.web.rest.vo.SupplierSelectParams;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource/supplier")
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

}
