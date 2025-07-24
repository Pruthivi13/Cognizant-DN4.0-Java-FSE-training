import React, { useState } from "react";
import BookDetails from "./components/BookDetails";
import CourseDetails from "./components/CourseDetails";
import BlogDetails from "./components/BlogDetails";
import { books, courses, blogs } from "./data";
import "./App.css";

function App() {
  const [showBooks, setShowBooks] = useState(true);
  const [showCourses, setShowCourses] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);

  return (
    <div className="App">
      <h1>Blogger App</h1>

      <div style={{ padding: "20px" }}>
        <button onClick={() => setShowCourses(!showCourses)}>
          Toggle Courses
        </button>
        <button
          onClick={() => setShowBooks(!showBooks)}
          style={{ margin: "0 10px" }}
        >
          Toggle Books
        </button>
        <button onClick={() => setShowBlogs(!showBlogs)}>Toggle Blogs</button>
      </div>

      <div className="container">
        {showCourses ? (
          <div className="column">
            <CourseDetails courses={courses} />
          </div>
        ) : null}

        {showBooks && (
          <div className="column divider">
            <BookDetails books={books} />
          </div>
        )}

        {showBlogs && (
          <div className="column divider">
            <BlogDetails blogs={blogs} />
          </div>
        )}
      </div>
    </div>
  );
}

export default App;
