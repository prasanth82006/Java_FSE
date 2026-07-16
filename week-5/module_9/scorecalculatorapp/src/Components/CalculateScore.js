import React from 'react';
import './../Stylesheets/mystyle.css';

const CalculateScore = (props) => {
    const { name, school, total, goal } = props;

    // Calculate average score (assuming total is out of goal marks)
    const average = goal > 0 ? ((total / goal) * 100).toFixed(2) : 0;

    return (
        <div className="score-container">
            <h2>Student Score Report</h2>
            <div className="score-card">
                <p><strong>Name:</strong> {name}</p>
                <p><strong>School:</strong> {school}</p>
                <p><strong>Total Marks:</strong> {total}</p>
                <p><strong>Goal Marks:</strong> {goal}</p>
                <hr />
                <p className="average-score">
                    <strong>Average Score:</strong> {average}%
                </p>
            </div>
        </div>
    );
};

export default CalculateScore;