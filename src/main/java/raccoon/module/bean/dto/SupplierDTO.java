package raccoon.module.bean.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SupplierDTO {

  private Integer id;
  private String contacts;
  private String phone;
  private String telephone;
  private String address;
  private String remarks;
  private LocalDateTime updateTime;
  private Byte isActive;

}
