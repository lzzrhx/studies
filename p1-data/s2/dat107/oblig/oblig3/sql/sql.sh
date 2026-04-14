#! /bin/bash
psql -h <host> -p <port> -U vrqtcpdsga -d dat107 --file 02-setup.sql
