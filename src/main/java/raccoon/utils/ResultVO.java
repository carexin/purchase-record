package raccoon.utils;


import lombok.Data;

/**
 *
 * todo 有必须实现Serializable接口吗?
 *
 * @param <T> Data的具体类型
 */
@Data
public class ResultVO<T> {

  private static final long serialVersionUID = 3068837394742385883L;

  /**
   * 错误码.
   */
  private Integer code;

  /**
   * 提示信息.
   */
  private String msg;

  /**
   * 具体内容.
   */
  private T data;
}
