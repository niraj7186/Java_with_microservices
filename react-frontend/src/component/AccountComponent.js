import React, { Component } from 'react';
import AccountService from '../service/AccountService';

class AccountComponent extends Component {

    constructor(props) {
        super(props);
        
        this.state = {
            account: {},
            user: {},
        }
    }
    
    componentDidMount(){
        AccountService.getAccountUser().then(response =>{
            this.setState({account: response.data.account})
            this.setState({user: response.data.user})

            console.log(this.state.account)
            console.log(this.state.user)
        })
    }

    render() {
        return (
            <div> <br /><br />
                <div className='card col-md-6 offset-md-3'>
                    <h3 className='text-center card-header'>Account Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Account Id : </strong>{this.state.account.id}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Account Email : </strong>{this.state.account.email}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Account Balance : </strong>{this.state.account.balance}</p>
                        </div>
                </div>

                <h3 className='text-center card-header'>User Details</h3>
                <div className='card-body'>
                    <div className='row'>
                                <p><strong>User Id : </strong>{this.state.user.id}</p>
                    </div>
                    <div className='row'>
                                <p><strong>User Name : </strong>{this.state.user.name}</p>
                    </div>
                    <div className='row'>
                                <p><strong>User Email : </strong>{this.state.user.email}</p>
                    </div>
                    <div className='row'>
                                <p><strong>User Salary : </strong>{this.state.user.monthlySalary}</p>
                    </div>
                    <div className='row'>
                                <p><strong>User Expense : </strong>{this.state.user.monthlyExp}</p>
                    </div>
                </div>
                </div>
            </div>
        );
    }
}

export default AccountComponent;