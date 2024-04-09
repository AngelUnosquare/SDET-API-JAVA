Feature: User is posted succesfully in Reqres

Scenario:
Given add "user" and "job"
When user calls "ReqresAPI" with post http request
Then The api call got success with status code 201
