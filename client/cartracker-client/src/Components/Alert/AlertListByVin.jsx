import React from 'react'
import {BootstrapTable,TableHeaderColumn} from 'react-bootstrap-table'
import axios from 'axios'
class AlertListByVin extends React.Component{
	constructor(){
		super();
		this.state={
			all_alerts:[],
			vinid:''
		}
	}

	
	update(e){
		let self=this;
		let temp_all_alerts;
		if(self.state.vinid){
		const all_alerts_of_vin_url = "http://localhost:8080/alerts/all/"+this.state.vinid
		axios.get(all_alerts_of_vin_url)
		     .then(function(response){
		     	if(response.data)
		     	{
		     		self.setState({
		     		all_alerts:response.data	
		     	})
		     	}
		     });
		     
		}
	}
	
	render(){
		let all_alerts_by_vin;
		if(this.state.all_alerts){
			all_alerts_by_vin=this.state.all_alerts;
			return(
				<div>
					Enter the VIN : <input 
									type="text" 
									onChange={(e)=>this.setState({vinid:e.target.value})} 
									placeholder="enter the vin"/>
					<button onClick={this.update.bind(this)}>Submit</button>
					<AlertsHistory all_alerts_by_vin={this.state.all_alerts}/>

				</div>
				)
		}
		return(
			<div>
				{all_alerts_by_vin}
			</div>
			)
	}
}

class AlertsHistory extends React.Component {
	render(){
			let all_alerts=[];
			console.log('before ',all_alerts.length)
			if(this.props.all_alerts_by_vin){
			all_alerts=this.props.all_alerts_by_vin;
			console.log('after ',all_alerts.length)
			return(
				<BootstrapTable data={all_alerts} height='160' scrollTop={ 'Bottom' }>
						<TableHeaderColumn dataField='reason' isKey>Reason</TableHeaderColumn>
						<TableHeaderColumn dataField='alertLevel' >Level</TableHeaderColumn>
				</BootstrapTable>
				)
		}
		return(<div>There is no data present</div>)
	}
}

export default AlertListByVin
