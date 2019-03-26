package raccoon.module.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import raccoon.module.bean.SupplierSelectParams;
import raccoon.module.bean.dto.SupplierDTO;
import raccoon.module.bean.entity.Supplier;
import raccoon.module.bean.form.SupplierForm;
import raccoon.module.service.SupplierService;
import raccoon.utils.ResultVO;
import raccoon.utils.ResultVOUtil;

@RestController
@RequestMapping("/api/supplier")
@Slf4j
@Api(tags = {"供货商-接口"})
public class SupplierResource {

  @Autowired
  private SupplierService supplierService;

  @PostMapping
  @ApiOperation(value = "新增供货商", notes = "不要传id参数")
  public ResultVO<Integer> add(@RequestBody @ApiParam(
          name = "供应商form",
          value = "传入json格式",
          required = true) SupplierForm supplierForm) {

    supplierForm.setId(null);
    SupplierDTO supplierDTO = new SupplierDTO();
    BeanUtils.copyProperties(supplierForm, supplierDTO);
    Integer supplierId = supplierService.add(supplierDTO);
    return ResultVOUtil.success(supplierId);
  }

  @GetMapping
  @ApiOperation(value = "分页查询supplier", notes = "默认显示10条")
  public PageInfo<Supplier> list(SupplierSelectParams params) {
    PageInfo<Supplier> result = supplierService.list(params);
    return result;
  }

  @PutMapping
  @ApiOperation(value = "更新supplier", notes = "根据id更新")
  public ResultVO<Integer> update(@RequestBody SupplierForm supplierForm) {

    if (null == supplierForm.getId()) {
      return ResultVOUtil.error(10000, "缺少主键");
    }
    SupplierDTO supplierDTO = new SupplierDTO();
    BeanUtils.copyProperties(supplierForm, supplierDTO);

    Integer result = supplierService.update(supplierDTO);
    return ResultVOUtil.success(result);

  }


  @DeleteMapping("/{supplierId}")
  @ApiOperation(value = "删除一个代理商", notes = "根据id删除, 并删除与之关联的所有order")
  public ResultVO<Integer> delete(@PathVariable @ApiParam(name = "supplierId",
          value = "int",
          required = true) Integer supplierId) {

    // todo 参数校验
    // todo 删除前的校验, 数据库查出此记录, 有责删除, 无则抛出异常
    log.info("supplier resource delete(): supplierId = {}", supplierId);

    Integer result = supplierService.deleteById(supplierId);
    return ResultVOUtil.success(result);
  }


}
