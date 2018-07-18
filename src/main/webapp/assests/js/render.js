"use strict"
window.ee = new EventEmitter();

var tree = document.getElementsByClassName("menuTree");

var filterApply = document.getElementById("filterApply");

filterApply.onclick = function (event) {
    window.ee.emit('Action', "renderFromFilter")
}
/* catch clicks on whole tree */
tree[0].onclick = function (event) {
    var target = event.target;
    var action = event.target.parentElement.getAttribute('about').trim();
    window.ee.emit('Action', action);
}


var MainRender = React.createClass({

    getInitialState: function () {
        return this.state = {
            list: []
        }
    },

    loadData () {
        var self = this;
        var minYear = document.getElementById("minYear");
        var maxYear = document.getElementById("maxYear");
        var minPrice = document.getElementById("minPrice");
        var maxPrice = document.getElementById("maxPrice");
        var req = new XMLHttpRequest();
        req.responseType = 'json';
        var url = 'https://showcarsv2.herokuapp.com/ads?minPrice=' + minPrice.value + '$maxPrice=' + maxPrice.value + '&minYear=' + minYear.value + '$maxYear' + maxYear.value;
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


    render () {
        const items = this.state.list.map((item) => {
            return (
                <div key={item.id} className="adverColomnBorder">
                    <div className='adverColomnPhoto'>
                        <img src="assests/pictures/example.jpg" className="adverPhoto"/>
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

var renderFromFilter = React.createClass({

    getInitialState: function () {
        return this.state = {
            list: []
        }
    },

    loadData () {
        var self = this;
        var minYear = document.getElementById("minYear");
        var maxYear = document.getElementById("maxYear");
        var minPrice = document.getElementById("minPrice");
        var maxPrice = document.getElementById("maxPrice");
        var req = new XMLHttpRequest();
        req.responseType = 'json';
        var url = 'https://showcarsv2.herokuapp.com/ads?minPrice=' + minPrice.value + '$maxPrice=' + maxPrice.value + '&minYear=' + minYear.value + '$maxYear' + maxYear.value;
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


    render () {
        const items = this.state.list.map((item) => {
            return (
                <div key={item.id} className="adverColomnBorder">
                    <div className='adverColomnPhoto'>
                        <img src="assests/pictures/example.jpg" className="adverPhoto"/>
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



var text = "mainRender";

var App = React.createClass({
    getInitialState: function () {
        return {
            state: text
        };
    },
    componentDidMount: function () {
        var self = this;
        window.ee.addListener('Action', function (item) {

            if (item == "mainRender") text = "mainRender";
            if (item == "renderFromFilter") text = "renderFromFilter";
            if (item == "renderFromPagination") text = "renderFromPagination";
            var newText = text;
            self.setState({state: newText});
        });
    },
    componentWillUnmount: function () {
        window.ee.removeListener('Action');
    },

    render: function () {
        if (text.trim() == "mainRender") {
            return (
                <MainRender />
            )

        }
        if (text.trim() == "renderFromFilter") {
            return (
                <div className='actionWindow'>
                    <div className='actionWindowTop'>
                        <div className='textInCaption'>
                            <spring:message code="user.createAccounts"/>
                        </div>
                        <div className='top'/>
                        <CreateAccounts />
                    </div>
                </div>
            );
        }


    }

});
ReactDOM.render(
    <App />
    ,
    document.getElementById('root')
);


