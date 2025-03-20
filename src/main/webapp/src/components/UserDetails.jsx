import React, { useEffect, useState } from 'react';
import api from '../services/api';
import { useParams, useNavigate } from 'react-router-dom';

const UserDetails = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [user, setUser] = useState(null);

    useEffect(() => {
        api.get(`/list/${id}`)
            .then(response => setUser(response.data))
            .catch(error => console.error(error));
    }, [id]);

    if (!user) return <div>Carregando...</div>;

    return (
        <div className="container d-flex justify-content-center align-items-center vh-100">
            <div className="w-100">
                <h1 className="mb-4 text-center">Detalhes do Usuário</h1>
                <div className="card">
                    <div className="card-body">
                        <h5 className="card-title">{user.name}</h5>
                        <p className="card-text">Email: {user.email}</p>
                        <p className="card-text">Idade: {user.age}</p>
                        <p className="card-text">CPF: {user.cpf}</p>
                        {user.imgUrl && (
                            <img src={user.imgUrl} alt={user.name} className="img-fluid mt-3" />
                        )}
                    </div>
                </div>
                <div className="text-center mt-3">
                    <button className="btn btn-secondary" onClick={() => navigate('/')}>
                        <i className="fas fa-arrow-left"></i> Voltar
                    </button>
                </div>
            </div>
        </div>
    );
};

export default UserDetails;