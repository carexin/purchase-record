package raccoon.module.controller;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import raccoon.module.bean.SupplierSelectParams;
import raccoon.module.bean.entity.Supplier;
import raccoon.module.bean.form.SupplierForm;
import raccoon.module.service.SupplierService;
import raccoon.utils.ResultVO;
import raccoon.utils.ResultVOUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/supplier")
@Slf4j
public class SupplierResource {

  /**
   * 之所以不使用构造方法注入, 只是因为感觉不整齐.
   */

  @Autowired
  private SupplierService supplierService;

  @PostMapping("/save")
  public Supplier insert(@RequestBody Supplier supplier) {
    return supplierService.supplierAdd(supplier);
  }

  @PostMapping
  public ResultVO<Integer> add(@RequestBody SupplierForm supplierForm) {

    Map<String, Integer> map = new HashMap<>(1);
    Integer supplierId = supplierService.add(supplierForm.getDTO());
    map.put("supplierId", supplierId);
    return ResultVOUtil.success(map);
  }

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
