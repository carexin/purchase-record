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
class Record extends React.Component {
  render() {
    return (
        <tr>
          <td>{this.props.id}</td>
          <td>{this.props.contacts}</td>
          <td>{this.props.phone}</td>
          <td>{this.props.telephone}</td>
          <td>{this.props.address}</td>
          <td>{this.props.remarks}</td>
          {/*<td>{this.props.isActive}</td>*/}
          {/*<td>{this.props.createTime}</td>*/}
          {/*<td>{this.props.updateTime}</td>*/}
        </tr>
    )
  }
}

export default Record;