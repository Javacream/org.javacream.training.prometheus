sudo setfacl --modify user:sl01:rw /var/run/docker.sock

/snap/bin/docker run -d --name nginx nginx
/snap/bin/docker stop nginx
/snap/bin/docker rm nginx