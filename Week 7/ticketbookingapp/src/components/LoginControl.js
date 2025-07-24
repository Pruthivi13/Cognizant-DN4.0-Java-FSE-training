import React, { Component } from "react";
import UserGreeting from "./UserGreeting";
import GuestGreeting from "./GuestGreeting";
import LoginButton from "./LoginButton";
import LogoutButton from "./Logout";

class LoginControl extends Component {
  constructor(props) {
    super(props);
    this.handleLoginClick = this.handleLoginClick.bind(this);
    this.handleLogoutClick = this.handleLogoutClick.bind(this);
    this.state = { isLoggedIn: false };
  }

  handleLoginClick() {
    this.setState({ isLoggedIn: true });
  }

  handleLogoutClick() {
    this.setState({ isLoggedIn: false });
  }

  render() {
    const isLoggedIn = this.state.isLoggedIn;
    let button;
    let greeting;

    if (isLoggedIn) {
      button = <LogoutButton onClick={this.handleLogoutClick} />;
      greeting = <UserGreeting />;
    } else {
      button = <LoginButton onClick={this.handleLoginClick} />;
      greeting = <GuestGreeting />;
    }

    return (
      <div>
        {greeting}
        {button}
      </div>
    );
  }
}

export default LoginControl;
