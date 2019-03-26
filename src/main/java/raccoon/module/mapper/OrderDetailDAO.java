package raccoon.module.mapper;

import org.apache.ibatis.annotations.Mapper;
import raccoon.module.bean.entity.Order;
import raccoon.module.bean.entity.OrderDetail;
import raccoon.module.bean.param.OrderDetailNoPageParams;

import java.util.List;

@Mapper
public interface OrderDetailDAO {
  int deleteByPrimaryKey(String detailId);

  int insert(OrderDetail record);

  int insertSelective(OrderDetail record);

  OrderDetail selectByPrimaryKey(String detailId);

  int updateByPrimaryKeySelective(OrderDetail record);

  int updateByPrimaryKey(OrderDetail record);

  List<OrderDetail> listByParams(OrderDetailNoPageParams params);
}