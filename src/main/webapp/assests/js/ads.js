"use strict"

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
        // var url = 'http://localhost:8080/ads'
        var url = 'https://showcarsv2.herokuapp.com/ads'
        req.open('GET', url, true);
        req.send();
        var json;
        req.onreadystatechange = function () {
            // document.write( req.readyState + " - req.readyState");
            // document.write( req.status + " - req.status");
            // document.write(req);
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
