"use strict"

window.ee = new EventEmitter();

var filterApply = document.getElementById("filterApply");

filterApply.onclick = function (event) {
    window.ee.emit('Action', "renderFromFilter")
}

var Ads = React.createClass({

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
        var url = 'https://showcarsv2.herokuapp.com/adsFilters?minYear='+minYear.value+'&maxYear='+maxYear.value+'&minPrice='+minPrice.value+'&maxPrice='+maxPrice.value;
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



ReactDOM.render(
    <Ads />
    ,
    document.getElementById('root')
);
