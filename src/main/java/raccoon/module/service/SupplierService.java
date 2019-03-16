package raccoon.module.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raccoon.module.bean.SupplierSelectParams;
import raccoon.module.bean.entity.Supplier;
import raccoon.module.mapper.SupplierDAO;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class SupplierService {

  @Autowired
  private SupplierDAO supplierDAO;

  public Supplier supplierAdd(Supplier supplier) {

    // TODO 查询下数据库是否存在这个进货商
    supplier.setUpdateTime(LocalDateTime.now());
    supplier.setIsActive((byte) 0);
    supplierDAO.insert(supplier);
    return supplier;
  }


  /**
   * todo params参数如何传递?
   * 查询supplier
   */
  public PageInfo<Supplier> list(SupplierSelectParams params) {

    //获取第PageNum(由1开始)页，PageSize条内容，默认查询总数count
    PageHelper.startPage(params.getPageNum(), params.getPageSize());
    List<Supplier> list = supplierDAO.selectByContacts(params);
    //用PageInfo对结果进行包装
    PageInfo page = new PageInfo(list);
    return page;
  }
}
