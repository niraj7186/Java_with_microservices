import axios from 'axios'

 const ACCOUNT_SERVICE_URL = "http://localhost:9191/api/v1/account";
 const email = "harsh1234.p@gmail.com";

 class AccountService{
    getAccountUser(){
       return axios.get(ACCOUNT_SERVICE_URL + "/" + email);
    }
 }

 export default new AccountService