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
                 <div key={item.id}>
                     <div className='adverColomnPhoto' >{item.photo}</div>
                     <div className='adverColomnInfo' >
                         <div className='adverColomnInfoHeader' >
                             {item.make} {item.model} {item.year}</div>
                         <div className='adverColomnInfoDesc'>{item.description}</div>
                     </div>
                     <div className='adverColomnInfoPrice'>{item.price}</div>
                 </div>

            );
        });
        return (
            <div>{items}</div>
        );
    }


});

ReactDOM.render(
    <Ads />
    ,
    document.getElementById('root')
);
