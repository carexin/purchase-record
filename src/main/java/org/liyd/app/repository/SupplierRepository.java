package org.liyd.app.repository;

import org.liyd.app.entity.Supplier;
import org.liyd.app.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author liyudong
 */
@Repository
public class SupplierRepository {

  @Autowired
  private SupplierMapper supplierMapper;

  public Optional<Supplier> selectByContacts(String contacts) {
    return Optional.ofNullable(supplierMapper.selectByContacts(contacts));
  }

  public int insert(Supplier supplier) {
    return supplierMapper.insert(supplier);
  }

}
