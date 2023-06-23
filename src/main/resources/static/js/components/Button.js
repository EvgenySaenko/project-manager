class Button {

	constructor(id, name, elementClass, handleButtonClick) {
		this._id = id;
		this._name = name;
		this._class = elementClass;
		this._handleButtonClick = handleButtonClick;
		console.log(this._handleButtonClick);
	}

	generateButton() {
		this._button = document.createElement('button');
		this._button.setAttribute('id', this._id);
		this._button.setAttribute('class', this._class);
		this._button.setAttribute('type','button');
		this._button.textContent = this._name;
		this._button.addEventListener('click', () => this._handleButtonClick);
		return this._button;
	}

	setEventListeners() {
	    this._button.addEventListener('click', (e) => {
	        this.__handleButtonClick;
	    });
	}

}