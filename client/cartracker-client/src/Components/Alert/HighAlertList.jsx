import React from 'react';
import axios from 'axios';
import './AlertList.css';
import {BootstrapTable,TableHeaderColumn} from 'react-bootstrap-table';


let order='desc';
class HighAlertList extends React.Component{

constructor(){
    super();
    this.state={
      highalertlist:[]
    }
    this.options={
      sortIndicator:false
    }
  }
  componentWillMount(){
    let self=this;
    const high_alert_get_url="http://localhost:8080/alerts/HIGH/two_hours/all"
    axios.get(high_alert_get_url)
      .then(function(response){
      	if(response.data){
          self.setState({
            highalertlist:response.data
          })
        }
      })
      .catch(function(error){
        console.log(error)
      })
  }

  handleBtnClick=()=>{
    if(order=='desc'){
      this.refs.table1.handleSort('asc','highalertcount');
      order='asc';
    }
    else{
      this.refs.table1.handleSort('desc','highalertcount');
      order='desc';
    }
  }
	render(){
  let all_alerts_last_two_hours;
  if(this.state.highalertlist){
   all_alerts_last_two_hours=this.state.highalertlist;
   console.log(all_alerts_last_two_hours.length)
   return(
    <div>
        <h1>High Alerts</h1>
        <button onClick={ this.handleBtnClick }>Sort By Count</button>
        <BootstrapTable ref="table1" data={all_alerts_last_two_hours} >
          <TableHeaderColumn dataField='VIN'  isKey>VIN</TableHeaderColumn>
          <TableHeaderColumn dataField='highalertcount'>Count</TableHeaderColumn>
        </BootstrapTable>
    </div>
      )
}
  return(
    <ul>
    {all_alerts_last_two_hours}
    </ul>
    )
  }
}

export default HighAlertList