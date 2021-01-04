import requests
from flask import Flask

app = Flask(__name__)



@app.route('/user')
def imAlive():

    # response = requests.get("http://the-one-discovery:8080/discovery/v1/")
    requests.post("http://localhost:8080/discovery/v1/", json={
        'serviceName': 'user',
        'serviceIp': 'localhost',
        'servicePort': '5000'
    })

    return "Ok"


if __name__ == '__main__':
    app.run(host='0.0.0.0')
