import mybatis_mapper2sql
import pymysql
from config.config import CONFIG


class UserDbClient:
    def __init__(self) -> None:
        mapper, xml_raw_text = mybatis_mapper2sql.create_mapper(xml='dataAccess/user_mapper.xml')
        self._connection = UserDbClient.__create_connection()
        self._selectAll_statement = mybatis_mapper2sql.get_child_statement(mapper, "selectAllUsers")

    @staticmethod
    def __create_connection():
        return pymysql.connect(host=CONFIG['dbIp'], user=CONFIG['dbUser'], password=CONFIG['dbPass'], database=CONFIG['dbSchema'], port=CONFIG['dbPort'])

    def get_all(self):
        cursor = self._connection.cursor()
        cursor.execute(self._selectAll_statement)
        data = cursor.fetchall()
        print(data)
        cursor.close()
        return str(data[0]) + "\n"
