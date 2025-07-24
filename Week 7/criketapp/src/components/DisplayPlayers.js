import React from 'react';

function DisplayPlayers({ players }) {
  return (
    <div>
      {players.map((player, index) => (
        <li key={index}>Mr. {player.name} {player.score}</li>
      ))}
    </div>
  );
}

export default DisplayPlayers;