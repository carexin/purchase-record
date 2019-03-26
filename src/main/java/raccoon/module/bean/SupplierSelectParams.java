package raccoon.module.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import raccoon.module.bean.param.PageParams;

@Data
@EqualsAndHashCode(callSuper = true)
public class SupplierSelectParams extends PageParams {
  private String contacts;
}
