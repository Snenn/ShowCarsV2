var my_news = [
    {
        bigText: 'в четыре с четвертью часа четыре чёрненьких чумазеньких чертёнка чертили чёрными чернилами чертёж.',
    }
]
;
var Article = React.createClass({
    propTypes: {
        data: React.PropTypes.shape({
            bigText: React.PropTypes.string.isRequired
        })
    },
    getInitialState: function () {
        return {
            visible: false
        };
    },
    readmoreClick: function (e) {
        e.preventDefault();
        this.setState({visible: true});
    },
    render: function () {
        var bigText = this.props.data.bigText,
            visible = this.state.visible;
        return (
            <div className='article'>
                <a href="#"
                   onClick={this.readmoreClick}
                   className={'news__readmore ' + (visible ? 'none' : '')}>
                    Подробнее
                </a>
                <p className={'news__big-text ' + (visible ? '' : 'none')}>{bigText}</p>
            </div>
        )
    }
});
var News = React.createClass({
    propTypes: {
        data: React.PropTypes.array.isRequired
    },
    getInitialState: function () {
        return {
            counter: 0
        }
    },
    render: function () {
        var data = this.props.data;
        var newsTemplate;
        if (data.length > 0) {
            newsTemplate = data.map(function (item, index) {
                return (
                    <div key={index}>
                        <Article data={item}/>
                    </div>
                )
            })
        } else {
            newsTemplate = <p>К сожалению новостей нет</p>
        }
        return (
            <div className='news'>
                {newsTemplate}
                <strong
                    className={'news__count ' + (data.length > 0 ? '' : 'none') }>Всего новостей: {
                    data.length}</strong>
                Работа с input
            </div>
        );
    }
});
// --- добавили test input ---
var TestInput = React.createClass({
    render: function () {
        return (
            <input className='test-input' value='введите значение'/>
        );
    }
});
var App = React.createClass({
    render: function () {
        return (
            <div className='app'>
                <h3>Новости</h3>
                <TestInput /> {/* добавили вывод компонента */}
                <News data={my_news}/>
            </div>
        );
    }
});
ReactDOM.render(
    <App />,
    document.getElementById('root')
);
