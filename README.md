# Loan-Calculator

The Project is done using Spring boot.
The main functionality of this project is to calculate the APR (Annual Percentage Rate) using the given data

# Endpoints

# Save Loan Calculation

Request URL

http://localhost:8080/loancalculation

Request Method

POST

Sample Input

`{
"name": "Kannaa",
"ssn": "534",
"dob": "29/10/1996",
"principal": 500000,
"rate": "10.5",
"term": "5000",
"type": "MORTGAGE"
}`

Sample Response

_Saved Successfully_

# Get All Loan Calculation

Request URL

http://localhost:8080/loancalculation

Request Method

GET

Sample Response

`[
{
"id": 1,
"name": "Vaidee",
"ssn": 234,
"dob": "10/03/1996",
"principal": 1000,
"rate": 8.0,
"term": 90,
"type": "AUTO",
"arp": 3122.78
},
{
"id": 2,
"name": "Kannaa",
"ssn": 534,
"dob": "29/10/1996",
"principal": 500000,
"rate": 11.0,
"term": 5000,
"type": "MORTGAGE",
"arp": 3832.52
}
]`

# Get a Loan Calculation

Request URL

http://localhost:8080/loancalculation/{id}

Request Method

GET

Sample Response

`{
"id": 1,
"name": "Vaidee",
"ssn": 234,
"dob": "10/03/1996",
"principal": 1000,
"rate": 8.0,
"term": 90,
"type": "AUTO",
"arp": 3122.78
}
`