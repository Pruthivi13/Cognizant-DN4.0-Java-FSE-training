import React from "react";

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
    };
  }

  loadPosts() {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => response.json())
      .then((data) => {
        this.setState({ posts: data });
      })
      .catch((error) => {
        console.error("Fetch error:", error);
        alert("Error fetching posts: " + error.message);
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    console.error("Caught error:", error);
    this.setState({ hasError: true });
    alert("An error occurred: " + error.message);
  }

  render() {
    if (this.state.hasError) {
      return <h3>Something went wrong while displaying the posts.</h3>;
    }

    return (
      <div>
        <h2>Posts</h2>
        <ul>
          {this.state.posts.map((post) => (
            <li key={post.id}>
              <strong>{post.title}</strong>
              <p>{post.body}</p>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default Posts;
