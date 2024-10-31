\#!/bin/sh

# Phone Number is a Hex encoded JSON String

curl -X 'GET' \
  'http://localhost:8080/customer-service/v1/customer/1' \
  -H 'accept: */*'