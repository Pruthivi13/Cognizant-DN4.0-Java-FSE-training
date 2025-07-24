import React from "react";

function IndianPlayers() {
  const cricketPlayers = [
    "Sachin1",
    "Dhoni2",
    "Virat3",
    "Rohit4",
    "Yuvraj5",
    "Raina6",
  ];

  const [first, , third, , fifth] = cricketPlayers;

  const [, second, , fourth, , sixth] = cricketPlayers;

  const T20players = [
    "Mr. First Player",
    "Mr. Second Player",
    "Mr. Third Player",
  ];
  const RanjiTrophyPlayers = [
    "Mr. Fourth Player",
    "Mr. Fifth Player",
    "Mr. Sixth Player",
  ];
  const allIndianPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Odd Players</h2>
      <div>
        <li>First : {first}</li>
        <li>Third : {third}</li>
        <li>Fifth : {fifth}</li>
      </div>

      <hr />

      {/* NEW: Even Players Section */}
      <h2>Even Players</h2>
      <div>
        <li>Second : {second}</li>
        <li>Fourth : {fourth}</li>
        <li>Sixth : {sixth}</li>
      </div>

      <hr />

      <h2>List of Indian Players Merged:</h2>
      <ul>
        {allIndianPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
}

export default IndianPlayers;
