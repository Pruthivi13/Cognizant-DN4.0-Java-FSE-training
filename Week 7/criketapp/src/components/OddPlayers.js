import React from "react";

function OddPlayers({ IndianTeam }) {
  const [first, , third, , fifth] = IndianTeam;
  return (
    <div>
      <li>First : {first}</li>
      <li>Third : {third}</li>
      <li>Fifth : {fifth}</li>
    </div>
  );
}

export default OddPlayers;
