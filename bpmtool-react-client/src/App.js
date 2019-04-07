import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import Dashboard from "./components/Dashboard";

class App extends Component {
    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <p>
                        {/*Edit <code>src/App.js</code> and save to reload.*/}
                        Welcome to BPMTool
                    </p>
                    <Dashboard/>
                    <a
                        className="App-link"
                        href="https://reactjs.org"
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        Learn React
                    </a>
                </header>
            </div>
        );
    }
}

export default App;