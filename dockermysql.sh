docker run  -p 3306:3306 \
 --name applicationmysql \
 -e MYSQL_ROOT_PASSWORD=my-secret-pw \
 -e MYSQL_DATABASE=application \
 mysql
