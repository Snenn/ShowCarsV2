"use strict"
window.ee = new EventEmitter();


var ads = document.getElementById("ads");
var users = document.getElementById("users");
var register = document.getElementById("register");

ads.onclick = function (event) {
    window.ee.emit('Action', "ads");
}

users.onclick = function (event) {
    window.ee.emit('Action', "users");
}

register.onclick = function (event) {
    window.ee.emit('Action', "register");
}


var Ads = React.createClass({

    getInitialState: function () {
        return this.state = {
            list: []
        }
    },

    loadData () {
        var self = this;
        var req = new XMLHttpRequest();
        req.responseType = 'json';
        var url = 'https://showcarsv2.herokuapp.com/ads'
        req.open('GET', url, true);
        req.send();
        var json;
        req.onreadystatechange = function () {
            if (req.readyState === 4 && req.status === 200) {
                json = req.response;
                self.setState({list: json});
            }
        }
    },

    componentDidMount() {
        this.loadData();
    },


    render() {
        const items = this.state.list.map((item) => {
            return (
                <div key={item.id} className="adverColomnBorder">
                    <div className='adverColomnPhoto'>
                        {/*<img src="assests/pictures/example.jpg" className="adverPhoto"/>*/}
                        <img src={item.photo} className="adverPhoto"/>
                    </div>
                    <div className='adverColomnInfo'>
                        <div className='adverColomnInfoHeader'>
                            <div className='adverMakeMade'>{item.make} {item.model}</div>
                            <div className='adverYear'>{item.year}</div>
                        </div>
                        <div className='adverColomnInfoDesc'>{item.description}</div>
                    </div>
                    <div className='adverColomnInfoPrice'>
                        <div className="centr">{item.price}</div>
                    </div>
                </div>

            );
        });
        return (
            <div>
                <div>{items}</div>
            </div>
        );
    }


});

var Users = React.createClass({

    getInitialState: function () {
        return this.state = {
            list: []
        }
    },

    loadData () {
        var self = this;
        var req = new XMLHttpRequest();
        req.responseType = 'json';
        var url = 'https://showcarsv2.herokuapp.com/users'
        req.open('GET', url, true);
        req.send();
        var json;
        req.onreadystatechange = function () {
            if (req.readyState === 4 && req.status === 200) {
                json = req.response;
                alert(json);
                self.setState({list: json});
            }
        }
    },

    componentDidMount() {
        this.loadData();
    },


    render() {

        const items = this.state.list.map((item) => {
            return (<tr key={item.id}>
                <td >{item.id}</td>
                <td >{item.surname}</td>
                <td >{item.name}</td>
                <td >{item.login}</td>
                <td >{item.email}</td>

            </tr>);
        });
        return (
            <div>
                <div>
                    <table>
                        <tbody>
                        <tr>
                            <td >id</td>
                            <td >surname</td>
                            <td >name</td>
                            <td >login</td>
                            <td >email</td>
                        </tr>
                        {items}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
});

var Register = React.createClass({

    getInitialState: function () {
        return this.state = {
            list: []
        }
    },


    loadData () {
        var self = this;
        var req = new XMLHttpRequest();
        req.responseType = 'json';
        var url = 'https://showcarsv2.herokuapp.com/records'
        req.open('GET', url, true);
        req.send();
        var json;
        req.onreadystatechange = function () {
            if (req.readyState === 4 && req.status === 200) {
                json = req.response;
                alert(json);
                self.setState({list: json});
            }
        }
    },

    componentDidMount() {
        this.loadData();
    },

    render: function () {

        const items = this.state.list.map((item) => {
            return (<tr key={item.id}>
                <td >{item.id}</td>
                <td >{item.idUser}</td>
                <td >{item.userName}</td>
                <td >{item.date}</td>
            </tr>);
        });
        return (
            <div>
                <div>
                    <table>
                        <tbody>
                        <tr>
                            <td >id</td>
                            <td >idUser</td>
                            <td >userName</td>
                            <td >date</td>
                        </tr>
                        {items}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
});

var text = "ads";

var App = React.createClass({
    getInitialState: function () {
        return {
            state: text
        };
    },
    componentDidMount: function () {
        var self = this;
        window.ee.addListener('Action', function (item) {

            if (item == "ads") text = "ads";
            if (item == "users") text = "users";
            if (item == "register") text = "register";
            var newText = text;
            self.setState({state: newText});
        });
    },
    componentWillUnmount: function () {
        window.ee.removeListener('Action');
    },

    render: function () {
        if (text.trim() == "ads") {
            return (
                <Ads />
            )

        }
        if (text.trim() == "users") {
            return (
                <Users />
            );
        }
        if (text.trim() == "register") {
            return (
                <Register />
            );
        }
    }

});
ReactDOM.render(
    <App />
    ,
    document.getElementById('root')
);