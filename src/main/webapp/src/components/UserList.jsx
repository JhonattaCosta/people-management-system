import React, { useEffect, useState } from 'react';
import api from '../services/api';
import { Link } from 'react-router-dom';

const UserList = () => {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        api.get('/list')
            .then(response => setUsers(response.data))
            .catch(error => console.error(error));
    }, []);

    const handleDelete = (id) => {
        if (window.confirm("Tem certeza que deseja deletar este usuário?")) {
            api.delete(`/delete/${id}`)
                .then(() => {
                    setUsers(users.filter(user => user.id !== id));
                })
                .catch(error => console.error(error));
        }
    };

    return (
        <div > {/* Centraliza horizontalmente com mx-auto */}
            <h1 className="mb-4 text-center">Lista de Usuários</h1>
            <div className="text-center mb-3">
                <Link to="/create" className="btn btn-success">
                    <i className="fas fa-plus"></i> Criar Usuário
                </Link>
            </div>
            <table className="table table-striped table-hover">
                <thead className="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Idade</th>
                        <th>CPF</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map(user => (
                        <tr key={user.id}>
                            <td>{user.id}</td>
                            <td>{user.name}</td>
                            <td>{user.email}</td>
                            <td>{user.age}</td>
                            <td>{user.cpf}</td>
                            <td>
                                <Link to={`/details/${user.id}`} className="btn btn-primary btn-sm me-2">
                                    <i className="fas fa-eye"></i> Ver
                                </Link>
                                <Link to={`/edit/${user.id}`} className="btn btn-warning btn-sm me-2">
                                    <i className="fas fa-edit"></i> Editar
                                </Link>
                                <button onClick={() => handleDelete(user.id)} className="btn btn-danger btn-sm">
                                    <i className="fas fa-trash"></i> Deletar
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default UserList;