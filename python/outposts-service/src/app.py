import requests
from flask import Flask
from config.config import CONFIG

app = Flask(__name__)

@app.route('/outposts/v1', methods=['GET'])
def imAlive():
    return 'Outposts service is alive!'


def registerServiceWithDiscovery():
    print('OutpostsService: Registering self with discovery on {}:{}'.format(CONFIG['discoveryIp'], CONFIG['discoveryPort']))
    requests.post(f"http://{CONFIG['discoveryIp']}:{CONFIG['discoveryPort']}/discovery/v1/", json={
        'serviceName': CONFIG['appName'],
        'serviceIp': CONFIG['appIp'],
        'servicePort': CONFIG['appPort']
    })

def startService():
    app.run(host='0.0.0.0', port=CONFIG['appPort'])

if __name__ == '__main__':
    registerServiceWithDiscovery()
    startService()
