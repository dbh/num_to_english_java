# num_to_english_java

## Objective
The task:
Create an application that exposes an endpoint, 

GET /num_to_english
Which has the following Request Body Format, where a number is passed in the number field.
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

Requirements:
Treat this as a production endpoint you would publish.
How would you organize it to be production ready? 
What are the things you would do to allow other engineers to use your endpoint?