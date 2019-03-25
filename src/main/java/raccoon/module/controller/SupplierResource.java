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
@Api(tags = {"供货商-操作接口"})
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

  /**
   * 分页查询
   *
   * @param params
   * @return
   */
  @GetMapping
  @ApiOperation(value = "分页查询supplier", notes = "默认显示10条")
  public PageInfo<Supplier> list(SupplierSelectParams params) {
    PageInfo<Supplier> result = supplierService.list(params);
    return result;
  }


  /**
   * 更新供货商
   *
   * @param supplierForm
   * @return
   */
  @PutMapping
  @ApiOperation(value = "更新supplier", notes = "根据id更新")
  public ResultVO<Integer> update(@RequestBody SupplierForm supplierForm) {

    SupplierDTO supplierDTO = new SupplierDTO();
    BeanUtils.copyProperties(supplierForm, supplierDTO);

    Integer result = supplierService.update(supplierDTO);
    return ResultVOUtil.success(result);

  }


}
