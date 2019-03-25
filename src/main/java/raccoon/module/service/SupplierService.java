package raccoon.module.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raccoon.module.bean.SupplierSelectParams;
import raccoon.module.bean.dto.SupplierDTO;
import raccoon.module.bean.entity.Supplier;
import raccoon.module.mapper.SupplierDAO;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class SupplierService {

  @Autowired
  private SupplierDAO supplierDAO;

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

  public Integer add(SupplierDTO supplierDTO) {

    Supplier supplier = new Supplier();
    BeanUtils.copyProperties(supplierDTO, supplier);

    // TODO 查询下数据库是否存在这个进货商
    supplier.setCreateTime(LocalDateTime.now());
    supplier.setUpdateTime(LocalDateTime.now());
    Integer result = supplierDAO.insert(supplier);
    return supplier.getId();
  }

  public Integer update(SupplierDTO supplierDTO) {
    Supplier supplier = new Supplier();
    BeanUtils.copyProperties(supplierDTO, supplier);
    Integer result = supplierDAO.updateByPrimaryKeySelective(supplier);
    return result;
  }
}
