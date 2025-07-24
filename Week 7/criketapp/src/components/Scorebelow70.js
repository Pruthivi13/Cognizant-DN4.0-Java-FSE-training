import React from "react";

function Scorebelow70({ players }) {
  const playersBelow70 = players.filter((player) => player.score < 70);

  return (
    <div>
      {playersBelow70.map((player, index) => (
        <li key={index}>
          Mr. {player.name} {player.score}
        </li>
      ))}
    </div>
  );
}

export default Scorebelow70;
