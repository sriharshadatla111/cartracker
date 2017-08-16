import React from 'react';
import axios from 'axios';
import './ReadingList.css';
import {BootstrapTable,TableHeaderColumn} from 'react-bootstrap-table';

class ReadingList extends React.Component{

  constructor(){
    super();
    this.state={
      readinglist:[]
    }
    this.options={
      sortIndicator:false
    }
  }

 
  componentWillMount(){
    let self=this;
    const reading_get_url="http://localhost:8080/readings"
    axios.get(reading_get_url)
      .then(function(response){
        if(response.data){
          self.setState({
            readinglist:response.data
          })
        }
      })
      .catch(function(error){
        console.log(error)
      })
  }

  render(){
  let readings;
  if(this.state.readinglist){
   readings=this.state.readinglist;
   
   return(
<div>
    <h1>READINGS</h1>
    <h1>{readings.length}</h1>
        <BootstrapTable data={readings}  height='200' scrollTop={ 'Bottom' }>
          <TableHeaderColumn dataField='vin' isKey>VIN</TableHeaderColumn>
          <TableHeaderColumn dataField='latitude'>Latitude</TableHeaderColumn>
          <TableHeaderColumn dataField='longitude'>Longitude</TableHeaderColumn>
          <TableHeaderColumn dataField='fuelVolume'>FuelVolume</TableHeaderColumn>
          <TableHeaderColumn dataField='speed'>Speed</TableHeaderColumn>
          <TableHeaderColumn dataField='engineHp'>engineHP</TableHeaderColumn>
          <TableHeaderColumn dataField='checkEngineLightOn'>checkEngineLightOn</TableHeaderColumn>
          <TableHeaderColumn dataField='engineCoolantLow'>EngineCoolantLow</TableHeaderColumn>
          <TableHeaderColumn dataField='cruiseControlOn'>cruisecontrolOn</TableHeaderColumn>
          <TableHeaderColumn dataField='engineRpm'>EngineRPM</TableHeaderColumn>
          <TableHeaderColumn dataField='timestamp'>TimeStamp</TableHeaderColumn>
        </BootstrapTable>
        </div>
      )
}
  return(
    <ul>
    {readings}
    </ul>
    )
  }
}

export default ReadingList