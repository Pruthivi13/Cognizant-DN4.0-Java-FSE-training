import React from 'react';

function CourseDetails(props) {
  return (
    <div>
      <h2>Course Details</h2>
      {props.courses.map((course) => (
        <div key={course.id}>
          <h3>{course.cname}</h3>
          <h4>{course.date}</h4>
        </div>
      ))}
    </div>
  );
}

export default CourseDetails;