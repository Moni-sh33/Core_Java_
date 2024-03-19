import React, { Component } from 'react';
import axios from 'axios';

class Users extends Component {
  state = {
    users: []
  };

  componentDidMount() {
    this.fetchData();
  }

  fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:8081/users');
      console.log('Response:', response.data); 
      this.setState({ users: response.data });
    } catch (error) {
      console.log('Error fetching data:', error);
    }
  };

  render() {
    const { users } = this.state;

    return (
      <div>
        <h2>Users</h2>
        <div>
          {users.map(user => (
            <div key={user.id}>
              
              <h3>Name:{user.name}</h3>
              <p>Type: {user.type}</p>
              
            </div>
          ))}
        </div>
      </div>
    );
  }
}

export default Users;
