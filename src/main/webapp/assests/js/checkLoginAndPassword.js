

getDataUsersInfo () {
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