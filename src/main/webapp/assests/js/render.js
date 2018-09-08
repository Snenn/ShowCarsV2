"use strict"
window.ee = new EventEmitter();
var state = 0;

var filterApply = document.getElementById("filterApply");

filterApply.onclick = function (event) {
    state++;
    window.ee.emit('Action', state);
}


var MainRender = React.createClass({

        getInitialState: function () {
            return this.state = {
                data: [],
            }
        },

        loadData () {
            alert("loadData");
            var self = this;
            var minYear = document.getElementById("minYear");
            var maxYear = document.getElementById("maxYear");
            var minPrice = document.getElementById("minPrice");
            var maxPrice = document.getElementById("maxPrice");
            var req = new XMLHttpRequest();
            req.responseType = 'json';
            var url = 'https://showcarsv2.herokuapp.com/adsFilters?minYear=' + minYear.value + '&maxYear=' + maxYear.value + '&minPrice=' + minPrice.value + '&maxPrice=' + maxPrice.value;
            req.open('GET', url, true);
            req.send();
            var json;
            req.onreadystatechange = function () {
                if (req.readyState === 4 && req.status === 200) {
                    json = req.response;
                    self.setState({data: json});
                }
            }
        },

        componentDidMount: function () {
            var self = this;
            window.ee.addListener('Action', function (item) {
                var newText = text;
                self.setState({state: this.state});
                self.loadData();
                alert("listener work App");
            });
            self.loadData();
        },

        componentWillUnmount: function () {
            window.ee.removeListener('Action');
        },


        render()
        {
            alert("render Main");
            const items = this.state.data.map((item) => {
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


    })
    ;

var text = 0;

// var App = React.createClass({
//
//         getInitialState: function () {
//             return {
//                 state: text
//             };
//         },
//
//         componentDidMount: function () {
//             var self = this;
//             window.ee.addListener('Action', function (item) {
//                 var newText = text;
//                 self.setState({state: this.state});
//                 alert("listener work App");
//             });
//         },
//         componentWillUnmount: function () {
//             window.ee.removeListener('Action');
//         },
//
        {/*render: function () {*/}
//             if (1 == 1) {
//                 alert(" render App")
//                 return (<MainRender />)
//             }
// }
//
//     })
//     ;

ReactDOM.render(
    <MainRender />
    ,
    document.getElementById('root')
);




