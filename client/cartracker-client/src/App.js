import React, { Component } from 'react';
import ReadingList from './Components/Reading/ReadingList';
import VehicleList from './Components/Vehicle/VehicleList';
import ReactDOM from 'react-dom';
import Button from 'react-bootstrap/lib/Button';
import Select from 'react-select';
import HighAlertList from './Components/Alert/HighAlertList';
import AlertListByVin from './Components/Alert/AlertListByVin';
import _ from 'lodash';
import axios from 'axios';
import 'react-select/dist/react-select.css';
import './App.css';


 

class App extends Component {
  constructor(){
      super();
      this.state={
        vehiclebuttoncount:0,
        readingbuttoncount:0,
        alertbuttoncount:0,
        allalertsbyvinbuttoncount:0,
        options:[]
      }
    }


    componentWillMount(){
      axios.get("http://")
    }


    //this is for mounting vehicleList component
    mountandunmountVehicleList(count){
      if(count%2!==0){
        ReactDOM.unmountComponentAtNode(document.getElementById('vehiclelistpanel')) 
      }
      else
      {
        ReactDOM.render(<VehicleList/>,document.getElementById('vehiclelistpanel'))  
      }
      this.setState({
        vehiclebuttoncount:count+1
      })
  }
  //this is for mounting and unmounting readinglist
  mountandunmountReadingList(count){
      
      if(count%2!==0){
        ReactDOM.unmountComponentAtNode(document.getElementById('readinglistpanel')) 
      }
      else
      {
        ReactDOM.render(<ReadingList/>,document.getElementById('readinglistpanel'))  
      }
      this.setState({
        readingbuttoncount:count+1
      })
  }

  //this is for mounting and unmounting alertlist
  mountandunmountAlertList(count){
    if(count%2!==0){
        ReactDOM.unmountComponentAtNode(document.getElementById('alertlistpanel')) 
      }
      else
      {
        ReactDOM.render(<HighAlertList/>,document.getElementById('alertlistpanel'))  
      }
      this.setState({
        alertbuttoncount:count+1
      })
  }

  mountandunmountAllAlertList(count){
    if(count%2!==0){
      ReactDOM.unmountComponentAtNode(document.getElementById("allalertsbyvinpanel"))
    }
    else
    {
      ReactDOM.render(<AlertListByVin/>,document.getElementById("allalertsbyvinpanel"))
    }
    this.setState({
      allalertsbyvinbuttoncount : count+1
    })
  }

 


  render() {
    return (
      <div className="App">
          <h2>Car-Tracker App</h2>
          <Button onClick={()=>this.mountandunmountVehicleList(this.state.vehiclebuttoncount)} color="success">Vehicles</Button>{' '}
          <Button onClick={()=>this.mountandunmountReadingList(this.state.readingbuttoncount)} color="success">Readings</Button>{' '}
          <Button onClick={()=>this.mountandunmountAlertList(this.state.alertbuttoncount)} color="success">High Alerts</Button>{' '}
          <Button onClick={()=>this.mountandunmountAllAlertList(this.state.allalertsbyvinbuttoncount)} color="success">Alerts</Button>{' '}
          <div className="container">
          <div id="vehiclelistpanel">
          </div>
          <div id="readinglistpanel">
          </div>
          <div id="alertlistpanel">
          </div>
          <div id="allalertsbyvinpanel">
          </div>
          <div id="allalertsbyvinpanel2">
          </div> 
        </div>
      </div>
    );
  }
  componentWillMount(){
    
  }
}



export default App;
