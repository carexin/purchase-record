package raccoon.module.bean.param;

import lombok.Data;

@Data
public class PageParams {

  private int pageNum = 1;
  private int pageSize = 10;

}
