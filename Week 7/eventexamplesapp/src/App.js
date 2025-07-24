import React, { Component } from "react";
import CurrencyConvertor from "./CurrencyConverter";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0,
    };
  }

  increment = () => {
    this.setState({ counter: this.state.counter + 1 });
  };

  sayHello = () => {
    alert("Hello! Member1");
  };

  callTwoFunctions = () => {
    this.increment();
    this.sayHello();
  };

  decrement = () => {
    this.setState({ counter: this.state.counter - 1 });
  };

  sayMessage = (message) => {
    alert(message);
  };

  handlePress = () => {
    alert("I was clicked");
  };

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h2>Counter: {this.state.counter}</h2>

          <button onClick={this.callTwoFunctions}>Increment</button>

          <button onClick={this.decrement} style={{ margin: "0 10px" }}>
            Decrement
          </button>

          <button onClick={() => this.sayMessage("welcome")}>
            Say Welcome
          </button>

          <button onClick={this.handlePress} style={{ marginLeft: "10px" }}>
            Click on me
          </button>

          <hr style={{ width: "100%", margin: "20px 0" }} />

          <CurrencyConvertor />
        </header>
      </div>
    );
  }
}

export default App;
