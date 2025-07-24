import React from 'react';

const players = [
    { name: 'Jack', score: 50 },
    { name: 'Michael', score: 70 },
    { name: 'John', score: 40 },
    { name: 'Ann', score: 61 },
    { name: 'Sachin', score: 95 },
    { name: 'Dhoni', score: 100 },
    { name: 'Virat', score: 84 },
    { name: 'Rohit', score: 80 },
    { name: 'Raina', score: 75 },
    { name: 'Elisabeth', score: 61 },
    { name: 'Jadeja', score: 64 },
];


function ListofPlayers() {
  const playersBelow70 = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>List of Players</h2>
      <div>
        {players.map((item, index) => (
          <div key={index}>
            <li>
              Mr. {item.name} {item.score}
            </li>
          </div>
        ))}
      </div>

      <hr />

     
      <h2>List of Players having Scores Less than 70</h2>
      <div>
        {playersBelow70.map((item, index) => (
          <div key={index}>
            <li>
              Mr. {item.name} {item.score}
            </li>
          </div>
        ))}
      </div>
    </div>
  );
}

export default ListofPlayers;