# fos-jq



### 技术栈：springboot + jquery



### 部署：docker



docker启动mysql

```
docker run --name mysql -d --rm  -v /docker/docker_mysql/conf:/etc/mysql/conf.d  -v /docker/docker_mysql/data:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root123456789 mysql
```



docker启动nginx

```
docker run --name nginx -d -p 80:80 nginx
```



jenkins

```
sudo docker run -d --restart unless-stopped --name jenkins -p 8888:8080 -p 50000:50000 -v /docker/jenkins_home:/var/jenkins_home -v /usr/bin/docker:/usr/bin/docker -v /var/run/docker.sock:/var/run/docker.sock -v /usr/lib64/libltdl.so.7:/usr/lib/x86_64-linux-gnu/libltdl.so.7 jenkins
```

