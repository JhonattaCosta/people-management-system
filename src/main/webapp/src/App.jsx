import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import UserList from './components/UserList';
import UserForm from './components/UserForm';
import UserDetails from './components/UserDetails';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<UserList />} />
                <Route path="/create" element={<UserForm />} />
                <Route path="/edit/:id" element={<UserForm />} />
                <Route path="/details/:id" element={<UserDetails />} />
            </Routes>
        </Router>
    );
}

export default App;