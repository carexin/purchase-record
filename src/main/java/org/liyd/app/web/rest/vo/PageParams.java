package org.liyd.app.web.rest.vo;

import lombok.Data;

@Data
public class PageParams {

  private int pageNum = 1;
  private int pageSize = 10;

}
