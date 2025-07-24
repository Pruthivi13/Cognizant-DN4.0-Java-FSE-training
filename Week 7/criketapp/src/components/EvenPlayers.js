import React from 'react';

function EvenPlayers({ IndianTeam }) {
  const [, second, , fourth, , sixth] = IndianTeam;
  return (
    <div>
      <li>Second : {second}</li>
      <li>Fourth : {fourth}</li>
      <li>Sixth : {sixth}</li>
    </div>
  );
}

export default EvenPlayers;