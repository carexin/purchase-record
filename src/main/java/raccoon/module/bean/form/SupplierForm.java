package raccoon.module.bean.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SupplierForm", description = "供货商form表单")
public class SupplierForm {

  @ApiModelProperty(value = "主键id, 添加时不需要给, 更新时需要传入id")
  private Integer id;

  @ApiModelProperty(value = "联络人", name = "contacts", example = "李逍遥")
  private String contacts;

  @ApiModelProperty(value = "手机", example = "137******15")
  private String phone;

  @ApiModelProperty(value = "固定电话", example = "85******")
  private String telephone;

  @ApiModelProperty(value = "地址", example = "李逍遥的客栈")
  private String address;

  @ApiModelProperty(value = "备注", example = "此人比较抠门")
  private String remarks;

}
