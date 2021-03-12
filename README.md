# Selenium-Docker-ES-Kibana
Pushing selenium logs to ES and visualising in Kibana

**Docker Compose File: docker-compose.yml**


version: '3.3'
services:
   elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:7.4.0
    container_name: elasticsearch
    restart: always
    environment:
        - xpack.security.enabled=false
        - discovery.type=single-node
    ulimits:
       memlock:
         soft: -1
         hard: -1
       nofile:
         soft: 65536
         hard: 65536
    cap_add:
       - IPC_LOCK
    volumes:
       - elasticsearch-data-volume:/usr/share/elasticsearch/data
    ports:
       - 9200:9200
 
   kibana:
     container_name: kibana
     image: docker.elastic.co/kibana/kibana:7.4.0
     restart: always
     environment:
         - ELASTICSEARCH_HOSTS=http://elasticsearch:9200
     ports:
        - 5601:5601
     depends_on:
        - elasticsearch

volumes:
   elasticsearch-data-volume:
     driver: local
