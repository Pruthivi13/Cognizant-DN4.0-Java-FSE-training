import React from "react";
import "./App.css";

import DisplayPlayers from "./components/DisplayPlayers";
import Scorebelow70 from "./components/Scorebelow70";
import OddPlayers from "./components/OddPlayers";
import EvenPlayers from "./components/EvenPlayers";
import ListofIndianPlayers from "./components/ListofIndianPlayers";

function App() {
  const players = [
    { name: "Jack", score: 50 },
    { name: "Michael", score: 70 },
    { name: "John", score: 40 },
    { name: "Ann", score: 61 },
    { name: "Sachin", score: 95 },
    { name: "Dhoni", score: 100 },
    { name: "Virat", score: 84 },
    { name: "Rohit", score: 80 },
    { name: "Raina", score: 75 },
    { name: "Elisabeth", score: 61 },
    { name: "Jadeja", score: 64 },
  ];

  const IndianTeam = [
    "Sachin1",
    "Dhoni2",
    "Virat3",
    "Rohit4",
    "Yuvraj5",
    "Raina6",
  ];

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
  const MergedIndianPlayers = [...T20players, ...RanjiTrophyPlayers];

  var flag = false;

  if (flag === true) {
    return (
      <div className="App-header">
        <h1>List of Players</h1>
        <DisplayPlayers players={players} />
        <hr />
        <h1>List of Players having Scores Less than 70</h1>
        <Scorebelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div className="App-header">
        <div>
          <h1>Indian Team</h1>
          <h1>Odd Players</h1>
          <OddPlayers IndianTeam={IndianTeam} />
          <hr />
          <h1>Even Players</h1>
          <EvenPlayers IndianTeam={IndianTeam} />
        </div>
        <hr />
        <div>
          <h1>List of Indian Players Merged:</h1>
          <ListofIndianPlayers IndianPlayers={MergedIndianPlayers} />
        </div>
      </div>
    );
  }
}

export default App;
