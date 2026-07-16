import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            error: null
        };
    }

    // Fetch posts using Fetch API
    loadPosts = () => {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => {
                this.setState({ posts: data });
            })
            .catch(error => {
                this.setState({ error: error.message });
            });
    };

    // Lifecycle Hook - Runs after component is mounted
    componentDidMount() {
        this.loadPosts();
    }

    // Error Handling Lifecycle
    componentDidCatch(error, info) {
        alert(`Error occurred: ${error.message}`);
        console.error("Error Info:", info);
    }

    render() {
        const { posts, error } = this.state;

        if (error) {
            return <h3 style={{ color: 'red', textAlign: 'center' }}>Error: {error}</h3>;
        }

        return (
            <div style={{ padding: '20px', maxWidth: '900px', margin: '0 auto' }}>
                <h1 style={{ textAlign: 'center' }}>Blog Posts</h1>
                {posts.length === 0 ? (
                    <p>Loading posts...</p>
                ) : (
                    posts.map(post => (
                        <Post key={post.id} post={post} />
                    ))
                )}
            </div>
        );
    }
}

export default Posts;