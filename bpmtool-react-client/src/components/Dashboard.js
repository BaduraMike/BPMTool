import React, {Component, PropTypes} from 'react';
import ProjectItem from "./Project/ProjectItem";

class Dashboard extends Component {
    propTypes = {};

    defaultProps = {};

    render() {
        return (
            <div>
            <h4 className={"alert alert-warning"}>That is the Dashboard</h4>
            <ProjectItem/>
            <ProjectItem/>
            </div>
        );
    }
}

export default Dashboard;