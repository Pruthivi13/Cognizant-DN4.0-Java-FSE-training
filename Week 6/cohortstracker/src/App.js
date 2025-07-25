import "./App.css";
import { CohortsData } from "./Cohort";
import CohortDetails from "./CohortDetails";

function App() {
  return (
    <div>
      <h1 style={{ textAlign: "center" }}>Cohorts Details</h1>

      <div
        style={{
          display: "flex",
          flexWrap: "wrap",
          justifyContent: "center", // ✅ centers the row
          gap: "20px", // ✅ space between cards
          padding: "20px", // ✅ space around edges
        }}
      >
        {CohortsData.map((cohort, index) => (
          <CohortDetails key={index} cohort={cohort} />
        ))}
      </div>
    </div>
  );
}

export default App;
