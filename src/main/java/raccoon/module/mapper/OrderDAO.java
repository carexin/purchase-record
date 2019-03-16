package raccoon.module.mapper;

import org.apache.ibatis.annotations.Mapper;
import raccoon.module.bean.entity.Order;

@Mapper
public interface OrderDAO {
  int deleteByPrimaryKey(String orderId);

  int insert(Order record);

  int insertSelective(Order record);

  Order selectByPrimaryKey(String orderId);

  int updateByPrimaryKeySelective(Order record);

  int updateByPrimaryKey(Order record);
}