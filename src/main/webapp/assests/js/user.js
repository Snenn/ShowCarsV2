"use strict"
window.ee = new EventEmitter();

function saveAd (event) {

    var ad = {
        make: '',
        model: '',
        year: '',
        price: '',
        description: '',

    };
    ad.make = document.getElementById("make");
    ad.model = document.getElementById("model");
    ad.year = document.getElementById("year");
    ad.price = document.getElementById("price");
    ad.description = document.getElementById("description");


    var jsonSend = JSON.stringify(ad);
    alert("this JSON will be send: " + jsonSend);
    var req = new XMLHttpRequest();
    req.responseType = 'json';
    var url = 'http://localhost:8080/grid';
    req.open('POST', url, true);
    req.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    var jsonResp;
    req.send(jsonSend);
    req.onreadystatechange = function () {
        if (req.readyState === 4 && req.status === 200) {
            jsonResp = req.response;
        }
    }


}



var MyAds = React.createClass({

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
        var url = 'http://localhost:8080/myAds'
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


ReactDOM.render(
    <MyAds />
    ,
    document.getElementById('root')
);