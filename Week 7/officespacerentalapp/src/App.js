import React from 'react';
import './App.css';

function App() {
  const mainHeading = "Office Space";

  const officeList = [
    {
      Name: 'DBS',
      Rent: 50000,
      Address: 'Chennai',
      imgSrc: 'https://images.unsplash.com/photo-1556761175-5973dc0f32e7?w=500'
    },
    {
      Name: 'WeWork',
      Rent: 75000,
      Address: 'Bengaluru',
      imgSrc: 'https://images.unsplash.com/photo-1521737604893-d14cc237f11d?w=500'
    },
    {
      Name: 'Regus',
      Rent: 58000,
      Address: 'Mumbai',
      imgSrc: 'https://images.unsplash.com/photo-1552664730-d307ca884978?w=500'
    }
  ];

  return (
    <div className="App">
      <header className="App-header">

        <h1>{mainHeading}, at Affordable Range</h1>

        {officeList.map((office, index) => {
          let colors = [];
          if (office.Rent <= 60000) {
            colors.push('textRed');
          } else {
            colors.push('textGreen');
          }

          const imageAttribute = <img src={office.imgSrc} width="25%" height="25%" alt="Office Space" />;

          return (
            <div key={index} style={{ marginBottom: '40px', border: '1px solid #ccc', padding: '20px' }}>
              {imageAttribute}
              <h2>Name: {office.Name}</h2>
              <h3 className={colors.join(' ')}>Rent: Rs. {office.Rent}</h3>
              <h3>Address: {office.Address}</h3>
            </div>
          );
        })}
      </header>
    </div>
  );
}

export default App;