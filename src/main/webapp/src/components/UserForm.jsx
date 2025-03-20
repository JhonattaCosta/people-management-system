import React, { useEffect, useState } from 'react';
import api from '../services/api';
import { useParams, useNavigate } from 'react-router-dom';

const UserForm = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [user, setUser] = useState({
        name: '',
        email: '',
        age: 0,
        cpf: '',
        imgUrl: '',
    });

    useEffect(() => {
        if (id) {
            api.get(`/list/${id}`)
                .then(response => setUser(response.data))
                .catch(error => console.error(error));
        }
    }, [id]);

    const handleSubmit = (e) => {
        e.preventDefault();
        if (id) {
            api.patch(`/update/${id}`, user)
                .then(() => navigate('/'))
                .catch(error => console.error(error));
        } else {
            api.post('/create', user)
                .then(() => navigate('/'))
                .catch(error => console.error(error));
        }
    };

    return (
        <div className="container d-flex justify-content-center align-items-center vh-100">
            <div>
                <h1 className="mb-4 text-center">{id ? 'Editar Usuário' : 'Criar Usuário'}</h1>
                <form onSubmit={handleSubmit}>
                    <div className="mb-3">
                        <label className="form-label"><span class="white">Nome</span></label>
                        <input
                            type="text"
                            className="form-control"
                            value={user.name}
                            onChange={(e) => setUser({ ...user, name: e.target.value })}
                            required
                        />
                    </div>
                    <div className="mb-3">
                        <label className="form-label"><span class="white">Email</span></label>
                        <input
                            type="email"
                            className="form-control"
                            value={user.email}
                            onChange={(e) => setUser({ ...user, email: e.target.value })}
                            required
                        />
                    </div>
                    <div className="mb-3">
                        <label className="form-label"><span class="white">Idade</span></label>
                        <input
                            type="number"
                            className="form-control"
                            value={user.age}
                            onChange={(e) => setUser({ ...user, age: e.target.value })}
                            required
                        />
                    </div>
                    <div className="mb-3">
                        <label className="form-label"><span class="white">CPF</span></label>
                        <input
                            type="text"
                            className="form-control"
                            value={user.cpf}
                            onChange={(e) => setUser({ ...user, cpf: e.target.value })}
                            required
                        />
                    </div>
                    <div className="mb-3">
                        <label className="form-label"><span class="white">URL da Imagem</span></label>
                        <input
                            type="text"
                            className="form-control"
                            value={user.imgUrl}
                            onChange={(e) => setUser({ ...user, imgUrl: e.target.value })}
                        />
                    </div>
                    <div className="text-center">
                        <button type="submit" className="btn btn-primary me-2">
                            <i className="fas fa-save"></i> {id ? 'Salvar' : 'Criar'}
                        </button>
                        <button type="button" className="btn btn-secondary" onClick={() => navigate('/')}>
                            <i className="fas fa-arrow-left"></i> Voltar
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default UserForm;