package raccoon.module.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import raccoon.module.bean.entity.Supplier;

import java.time.LocalDateTime;

/**
 * @author liyudong
 */
@Data
public class SupplierDTO {
  /**
   * 主键id
   */
  private Integer id;

  /**
   * 联系人
   */
  private String contacts;

  /**
   * 手机号码
   */
  private String phone;

  /**
   * 电话号码
   */
  private String telephone;

  /**
   * 地址
   */
  private String address;

  /**
   * 备注
   */
  private String remarks;

  /**
   * 更新时间
   */
  private LocalDateTime updateTime;

  /**
   * 进货商状态(1正常，0未启动)
   */
  private Byte isActive;

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(hidden = true)
  public Supplier getEntity() {
    Supplier supplier = Supplier.builder().build();
    supplier.setAddress(this.address);
    supplier.setContacts(this.contacts);
    supplier.setId(this.id);
    supplier.setIsActive(this.isActive);
    supplier.setPhone(this.phone);
    supplier.setRemarks(this.remarks);
    supplier.setUpdateTime(this.updateTime);

    return supplier;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
