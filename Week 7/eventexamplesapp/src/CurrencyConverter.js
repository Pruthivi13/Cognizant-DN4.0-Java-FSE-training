import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      amount: '',
      currency: '',
    };
  }

  handleChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    const { amount, currency } = this.state;

    if (currency.toLowerCase() === 'euro') {
      const euroAmount = amount * 80;
      alert(`Converting to Euro Amount is ${euroAmount}`);
    } else {
      alert('Please enter "Euro" as the currency for conversion.');
    }
  };

  render() {
    return (
      <div>
        <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Amount: </label>
            <input
              type="number"
              name="amount"
              value={this.state.amount}
              onChange={this.handleChange}
            />
          </div>
          <div style={{ margin: '10px 0' }}>
            <label>Currency: </label>
            <input
              type="text"
              name="currency"
              value={this.state.currency}
              onChange={this.handleChange}
              placeholder="e.g., Euro"
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;