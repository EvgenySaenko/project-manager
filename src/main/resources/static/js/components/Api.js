class Api {
  constructor(baseUrl, headers) {
    this._url = baseUrl;
    this._headers = headers;
  }
  //получить список проектов
  getProjects() {
    return fetch(`${this._url}/projects`, {
      method: "GET",
      headers: this._headers
    })
    .then((res) => this._checkResponse(res));
  }
  //проверка ответа, вывод ошибки и  ее статус кода
  _checkResponse(res) {
    return res.ok ? res.json() : Promise.reject('Ошибка : ${res.status}');
  }
}