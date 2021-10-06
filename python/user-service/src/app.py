import requests
from flask import Flask
from config.config import CONFIG
from domain.user_rest_service import UserService

app = Flask(__name__)
service = UserService()


@app.route('/user/v1', methods=['GET'])
def im_alive():
    return "User service is alive"


@app.route('/user/v1/<user_id>')
def get_user_by_id(user_id):
    return service.get_user_by_id(user_id)


@app.route('/users', methods=['GET'])
def get_all_users():
    return service.get_all_users()


def register_service_with_discovery():
    print('UserService: Registering self with discovery on {}:{}'.format(
        CONFIG['discoveryIp'],
        CONFIG['discoveryPort'])
    )
    requests.post(f"http://{CONFIG['discoveryIp']}:{CONFIG['discoveryPort']}/discovery/v1/", json={
        'serviceName': CONFIG['appName'],
        'serviceIp': CONFIG['appIp'],
        'servicePort': CONFIG['appPort']
    })


def start_service():
    app.run(host='0.0.0.0', port=CONFIG['appPort'])


if __name__ == '__main__':
    # register_service_with_discovery()
    start_service()
