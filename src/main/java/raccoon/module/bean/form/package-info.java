package raccoon.module.bean.form;

// todo lombok有继承情况时和普通bean有什么不同?

// form表单提交数据, swagger的提示信息不应该包含不需要前端提供的数据.
// 比如新增数据时不应有ID, 创建时间等参数.

/*

  @PostMapping("/save")
  public Supplier insert(@RequestBody Supplier supplier) {
    return supplierService.supplierAdd(supplier);
  }

  接口接收的数据不能包含不允许前端穿过来的参数, 需要定义form或param等bean









* */