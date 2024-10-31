\#!/bin/sh

# Phone Number is a Hex encoded JSON String

curl -X 'PUT' \
  'http://localhost:8080/customer-service/v1/update-customer' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "customerId": "1",
  "firstName": "Pintu",
  "middleName": "",
  "lastName": "Bara",
  "email": "pintu@gmail.com",
  "phoneNumber": "5b0a20207b0a202020202274797065223a20224d6f62696c65222c0a202020202270686f6e654e756d626572223a20223836302d3030302d30303030222c0a2020202022657874656e73696f6e223a2022220a20207d0a5d"
}'