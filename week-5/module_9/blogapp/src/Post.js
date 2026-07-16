import React from 'react';

class Post extends React.Component {
    render() {
        const { post } = this.props;
        return (
            <div style={{
                marginBottom: '20px',
                padding: '15px',
                border: '1px solid #ddd',
                borderRadius: '8px',
                backgroundColor: '#f9f9f9'
            }}>
                <h3>{post.title}</h3>
                <p>{post.body}</p>
            </div>
        );
    }
}

export default Post;