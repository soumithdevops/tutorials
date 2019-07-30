FROM cassandra

RUN apt-get update; \
	apt-get install -y vim \
	; \
	rm -rf /var/lib/apt/lists/*

COPY cql /root/cql

# 7000: intra-node communication
# 7001: TLS intra-node communication
# 7199: JMX
# 9042: CQL
# 9160: thrift service
EXPOSE 7000 7001 7199 9042 9160
CMD ["cassandra", "-f"]
