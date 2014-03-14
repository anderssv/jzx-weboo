FROM ubuntu
RUN apt-get update
RUN apt-get install -y haproxy
ADD haproxy.cfg.template /etc/haproxy/haproxy.cfg.template
ADD start-haproxy /start-haproxy
