docker run  -p 3307:3306 \
 --name vacancymysql \
 -e MYSQL_ROOT_PASSWORD=my-secret-pw \
 -e MYSQL_DATABASE=vacancy \
 mysql
