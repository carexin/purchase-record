import React from 'react';
import Record from './Record'
import RecordForm from './RecordForm'
import axios from 'axios'
// 类型检查
import PropTypes from 'prop-types'
import * as RecordsAPI from '../utils/RecordsAPI'

class Records extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      records: []
    }
  }

  componentDidMount() {
    axios.get(RecordsAPI.api).then(
        response => this.setState({
          records: response.data.list,
          isLoaded: true
        })
    ).catch(
        error => this.setState({
          isLoaded: true,
          error
        })
    )
  }

  render() {

    const {error, isLoaded, records} = this.state;

    let recordsComponent;

    if (error) {
      recordsComponent = <div>Error: {error.responseText}</div>;
    } else if (!isLoaded) {
      recordsComponent = <div>Loading ...</div>;
    } else {
      recordsComponent = (
          <div>
            <table className="table table-bordered">
              <thead>
              <tr>
                <th>id</th>
                <th>联系人</th>
                <th>手机</th>
                <th>手机号</th>
                <th>地址</th>
                <th>备注</th>
                {/*<th>是否有效</th>*/}
                {/*<th>创建时间</th>*/}
                {/*<th>更新时间</th>*/}
              </tr>
              </thead>
              <tbody>
              {records.map(
                  (record) => <Record key={record.id} {...record}/>)}
              </tbody>
            </table>
          </div>
      );
    }

    return (
        <div>
          <h2>记账本</h2>
          <RecordForm/>
          {recordsComponent}
        </div>
    )
  }
}

export default Records;

Records.propTypes = {
  id: PropTypes.number,
  contacts: PropTypes.string,
  phone: PropTypes.string
}