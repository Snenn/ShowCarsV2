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
        // var url = 'https://showcarsv2.herokuapp.com/ads'
        var url = 'http://localhost:8080/ads'
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
        // var url = 'http://localhost:8080/users'
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
            return (<tr key={item.id}>
                <td className="tdUsers">{item.id}</td>
                <td className="tdUsers">{item.surname}</td>
                <td className="tdUsers">{item.name}</td>
                <td className="tdUsers">{item.login}</td>
                <td className="tdUsers">{item.email}</td>

            </tr>);
        });
        return (
            <div>
                <div>
                    <table className="tableStyle">
                        <tbody>
                        <tr>
                            <td className="tdUsersHead">id</td>
                            <td className="tdUsersHead">surname</td>
                            <td className="tdUsersHead">name</td>
                            <td className="tdUsersHead">login</td>
                            <td className="tdUsersHead">email</td>
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
        // var url = 'http://localhost:8080/records'
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

    render: function () {

        const items = this.state.list.map((item) => {
            return (<tr key={item.id}>
                <td className="tdRecords">{item.id}</td>
                <td className="tdRecords">{item.idUser}</td>
                <td className="tdRecords">{item.userName}</td>
                <td className="tdRecords">{new Date(item.date).toUTCString()}</td>
            </tr>);
        });
        return (
            <div>
                <div>
                    <table className="tableStyle">
                        <tbody>
                        <tr>
                            <td className="tdRecordsHead">id</td>
                            <td className="tdRecordsHead">idUser</td>
                            <td className="tdRecordsHead">userName</td>
                            <td className="tdRecordsHead">date</td>
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
            );

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