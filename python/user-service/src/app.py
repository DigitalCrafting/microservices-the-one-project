import requests
from flask import Flask
from config.config import CONFIG

app = Flask(__name__)

@app.route('/user/v1', methods=['GET'])
def imAlive():
    return "User service is alive"


if __name__ == '__main__':
    requests.post(f"http://{CONFIG['discoveryIp']}:{CONFIG['discoveryPort']}/discovery/v1/", json={
        'serviceName': 'user',
        'serviceIp': 'localhost',
        'servicePort': '5000'
    })
    app.run(host='0.0.0.0')
