package raccoon.module.bean.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class Supplier implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer id;
  private String contacts;
  private String phone;
  private String telephone;
  private String address;
  private String remarks;
  private Byte isActive;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}