package raccoon.module.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import raccoon.utils.PageParams;

@Data
@EqualsAndHashCode(callSuper = true)
public class SupplierSelectParams extends PageParams {
  private String contacts;
}
