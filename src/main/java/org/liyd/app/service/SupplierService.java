package org.liyd.app.service;

import org.liyd.app.entity.Supplier;
import org.liyd.app.repository.SupplierRepository;
import org.liyd.app.service.dto.SupplierDTO;
import org.liyd.app.web.rest.error.ContactsAlreadyUsedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class SupplierService {

  // TODO 多封装一层repository情况下, transactional是否仍然有效?

  @Autowired
  private SupplierRepository supplierRepository;

  /**
   * 添加supplier
   *
   * @param supplierDTO
   * @return
   */
  public Supplier supplierAdd(SupplierDTO supplierDTO) {

    Supplier supplier = supplierDTO.getEntity();

    supplierRepository.selectByContacts(supplierDTO.getContacts()).ifPresent(existingSupplier -> {
      if (existingSupplier.getContacts().equals(supplierDTO.getContacts())) {
        throw new ContactsAlreadyUsedException();
      }
    });
    supplierRepository.insert(supplier);
    return supplier;
  }


}
