package raccoon.module.bean.form;

import lombok.Builder;
import lombok.Data;
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

  /**
   * todo 图方便直接转为entity操作.
   *
   * @return
   */
  public Supplier getEntity() {
    return Supplier.builder()
            .id(id)
            .contacts(contacts)
            .phone(phone)
            .telephone(telephone)
            .address(address)
            .remarks(remarks)
            .build();
  }

}
