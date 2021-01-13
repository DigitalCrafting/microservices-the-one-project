import requests
from flask import Flask
from config.config import CONFIG

app = Flask(__name__)

@app.route('/user', methods=['GET'])
def imAlive():
    requests.post(f"http://{CONFIG['discoveryIp']}:{CONFIG['discoveryPort']}/discovery/v1/", json={
        'serviceName': 'user',
        'serviceIp': 'localhost',
        'servicePort': '5000'
    })

    return "Ok"


if __name__ == '__main__':
    app.run(host='0.0.0.0')
