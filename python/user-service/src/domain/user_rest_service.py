from dataAccess.user_db_client import UserDbClient


class UserService:
    def __init__(self):
        self.__client = UserDbClient()

    def get_all_users(self):
        return self.__client.get_all()

    def get_user_by_id(self, user_id):
        return "Hello {}".format(user_id)
