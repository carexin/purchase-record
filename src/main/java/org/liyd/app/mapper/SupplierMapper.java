package org.liyd.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.liyd.app.entity.Supplier;
import org.liyd.app.web.rest.vo.SupplierSelectParams;

import java.util.List;

/**
 * @author liyudong
 */
@Mapper
public interface SupplierMapper {

  /**
   * 根据主键删除进货商
   *
   * @param id
   * @return
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * 插入经销商
   *
   * @param record
   * @return
   */
  int insert(Supplier record);

  /**
   * 非空插入进货商
   *
   * @param record
   * @return
   */
  int insertSelective(Supplier record);

  /**
   * 根据主键查询进货商
   *
   * @param id
   * @return
   */
  Supplier selectByPrimaryKey(Integer id);

  /**
   * 非空更新进货商
   *
   * @param record
   * @return
   */
  int updateByPrimaryKeySelective(Supplier record);

  /**
   * 更新进货商
   *
   * @param record
   * @return
   */
  int updateByPrimaryKey(Supplier record);

  /**
   * 根据联系人查询supplier
   *
   */
  List<Supplier> selectByContacts(SupplierSelectParams supplierSelectParams);
}