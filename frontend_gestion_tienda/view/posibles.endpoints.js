

function apiFetch(url, options = {}) {

    const token = localStorage.getItem("token");

    if (!token) {
        alert("Debes iniciar sesión");
        return Promise.reject("No token");
    }

    return fetch(url, {
        ...options,
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + token,
            ...options.headers
        }
    })
        .then(response => {

            if (response.status === 401) {
                localStorage.removeItem("token");
                throw new Error("Sesión expirada");
            }

            if (!response.ok) {
                throw new Error("Error en la petición");
            }

            return response.json();
        });
}

function buscarId(id) {

    apiFetch(`http://localhost:8080/api/producto/${id}`)
        .then(data => {
            console.log(data);
            alert(JSON.stringify(data, null, 2));
        })
        .catch(error => alert(error));
}

function listarTodos() {

    apiFetch(`http://localhost:8080/api/producto`)
        .then(data => {
            console.log(data);
            alert(JSON.stringify(data, null, 2));
        })
        .catch(error => alert(error));
}