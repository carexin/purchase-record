package raccoon.module.mapper;

import org.apache.ibatis.annotations.Mapper;
import raccoon.module.bean.SupplierSelectParams;
import raccoon.module.bean.entity.Supplier;

import java.util.List;

@Mapper
public interface SupplierDAO {
  int deleteByPrimaryKey(Integer id);

  int insert(Supplier record);

  int insertSelective(Supplier record);

  Supplier selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Supplier record);

  int updateByPrimaryKey(Supplier record);

  List<Supplier> selectByContacts(SupplierSelectParams params);
}