\#!/bin/sh

# Phone Number is a Hex encoded JSON String

curl -X 'DELETE' \
  'http://localhost:8080/customer-service/v1/delete-customer/1' \
  -H 'accept: application/json'