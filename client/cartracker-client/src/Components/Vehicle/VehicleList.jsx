import React from 'react';
import axios from 'axios';
import './VehicleList.css';
import {BootstrapTable,TableHeaderColumn} from 'react-bootstrap-table';


let order='desc';
class VehicleList extends React.Component{

constructor(){
    super();
    this.state={
      vehiclelist:[]
    }
    this.options={
      sortIndicator:false
    }
  }
  componentWillMount(){
    let self=this;
    const vehicle_get_url="http://localhost:8080/vehicles"
    axios.get(vehicle_get_url)
      .then(function(response){
        console.log("the length of the data is ",response.data.length)
        if(response.data){
          self.setState({
            vehiclelist:response.data
          })
        }
      })
      .catch(function(error){
        console.log(error)
      })
  }

  handleBtnClick=()=>{
    console.log('entered handleBtnClick method')
    if(order=='desc'){
      this.refs.table1.handleSort('asc','vin');
      order='asc';
    }
    else{
      this.refs.table1.handleSort('desc','vin');
      order='desc';
    }
  }


  render(){
  let vehicles;
  if(this.state.vehiclelist){
   vehicles=this.state.vehiclelist;
   return(
    <div>
        <h1>VEHICLES</h1>
        <BootstrapTable ref="table1" data={vehicles} className="vehiclepanel"  height='200' scrollTop={ 'Bottom' }>
          <TableHeaderColumn width='20%' dataField='vin' isKey>VIN</TableHeaderColumn>
          <TableHeaderColumn width='10%' dataField='make'>MAKE</TableHeaderColumn>
          <TableHeaderColumn width='10%'  dataField='model'>MODEL</TableHeaderColumn>
          <TableHeaderColumn width='20%' dataField='redlineRpm'>RedLineRPM</TableHeaderColumn>
          <TableHeaderColumn width='20%' dataField='maxFuelVolume'>MaxFuelVolume</TableHeaderColumn>
          <TableHeaderColumn width='20%' dataField='lastServiceDate'>LastServiceDate</TableHeaderColumn>
        </BootstrapTable>
    </div>
       )
}
  return(
    <ul>
    {vehicles}
    </ul>
    )
  }
}

export default VehicleList