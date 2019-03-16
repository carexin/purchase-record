package raccoon.module.mapper;

import org.apache.ibatis.annotations.Mapper;
import raccoon.module.bean.entity.OrderDetail;

@Mapper
public interface OrderDetailDAO {
  int deleteByPrimaryKey(String detailId);

  int insert(OrderDetail record);

  int insertSelective(OrderDetail record);

  OrderDetail selectByPrimaryKey(String detailId);

  int updateByPrimaryKeySelective(OrderDetail record);

  int updateByPrimaryKey(OrderDetail record);
}