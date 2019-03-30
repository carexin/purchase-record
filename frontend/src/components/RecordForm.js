import React from 'react';

/**
 * "id": 1,
 "contacts": "李逍遥",
 "phone": "137******15",
 "telephone": "85******",
 "address": "李逍遥的客栈",
 "remarks": "此人比较抠门",
 "isActive": null,
 "createTime": "2019-03-26T18:53:32",
 "updateTime": "2019-03-26T18:53:32"
 */
class RecordForm extends React.Component {

  constructor(props){
    super(props);
    this.state = {
      // contacts : "",
      //
    };
  }

  render() {
    return (
        <form className="form-inline">
          <div className="form-group">
            <input name="contacts" type="text" className="form-control" placeholder="联系人"/>
          </div>
          <div className="form-group">
            <input name="phone" type="text" className="form-control" placeholder="手机号"/>
          </div>
          <div className="form-group">
            <input name="telephone" type="text" className="form-control" placeholder="电话"/>
          </div>
          <div className="form-group">
            <input name="address" type="text" className="form-control" placeholder="地址"/>
          </div>
          {/*<div className="form-group">*/}
          {/*  <input name="remarks" type="text" className="form-control" placeholder="remarks"/>*/}
          {/*</div>*/}
          <button type="submit" className="btn btn-primary">创建进货商</button>
        </form>
        // <tr>
        //   <td>{this.props.id}</td>
        //   <td>{this.props.contacts}</td>
        //   <td>{this.props.phone}</td>
        //   <td>{this.props.telephone}</td>
        //   <td>{this.props.address}</td>
        //   <td>{this.props.remarks}</td>
        // </tr>
    );
  }
}

export default RecordForm;