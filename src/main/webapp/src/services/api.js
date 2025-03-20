import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080/users', // URL do seu back-end
});

export default api;