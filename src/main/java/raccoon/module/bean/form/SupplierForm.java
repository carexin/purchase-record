package raccoon.module.bean.form;

import lombok.Builder;
import lombok.Data;
import raccoon.module.bean.dto.SupplierDTO;
import raccoon.module.bean.entity.Supplier;

@Data
@Builder
public class SupplierForm {

  private Integer id;
  private String contacts;
  private String phone;
  private String telephone;
  private String address;
  private String remarks;

  public SupplierDTO getDTO() {
    return SupplierDTO
            .builder()
            .id(id)
            .contacts(contacts)
            .phone(phone)
            .telephone(telephone)
            .address(address)
            .remarks(remarks)
            .build();
  }

}
