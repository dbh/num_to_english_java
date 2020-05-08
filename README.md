# num_to_english_java

## Objective
The task:
Create an application that exposes an endpoint, 

## Endpoints
| Op  | URL  | Payload  | Params  |
|---|---|---|---|
| GET  | /num_to_english  | Body,JSON  | N/A |
| GET  | /num_to_english_param?number=123  | N/A  | number parameter  |
| POST | /num_to_english  | BODY,JSON  | N/A  |

### GET /num_to_english
Which has the following Request Body Format, where a number is passed in the number field.

**NOTE** Sending A request body payload on a GET request is usually considered illegal and bad practice, but it works in some tools/frameworks.


```json
{
    “number”: “12345678” 
}
```

This endpoint will convert any number given to it into the english words that describe that number. For example the above request should respond in the following format.
```json
{
    “status”: “ok”,
    “num_in_english”: “twelve million three hundred forty five thousand six hundred seventy eight” 
}
```

**status** is reserved for messaging back if the process succeeded or failed. Make sure to use that when handling errors.

### GET /number_to_eng_param?number=123
Here's a better approach

## Additional Requirements:
Treat this as a production endpoint you would publish.
How would you organize it to be production ready? 
What are the things you would do to allow other engineers to use your endpoint?

These would be necessary for production readiness
* HealthCheck (handled by Actuator)
* Docker Image
* Not Implemented but important
  * Configurable options, to be passed in through environment variables
  * Authentication methodologies
    * API key & secret, OAUTH, etc?
  * Authorization methodologies
    * Define needed granularity
  * Kubernetes,DC/OS,Helm-charts, etc


## Assumptions
* Numbers may be from 0 to Integer.MAX_VALUE (2147483647)
  * It could have been bigger... Arbitrary choice
* Commas will be removed from the input number
* Numbers should be expressed in base ten