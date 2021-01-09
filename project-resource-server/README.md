# Spring Boot Application as Resource Server

## Running app:

Application can be run as normal Spring Boot application

## Config:

All app configuration is placed in `resources/application.yml` file:

```yml
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: sa
    password:
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
  h2:
    console:
      enabled: true

server:
  port: 8081

security:
  oauth2:
    client:
      client-id: CLIENT_ID
      client-secret: CLIENT_SECRET
    resource:
      user-info-uri: USER_INFO_URI
      token-info-uri: TOKEN_INFO_URI
      prefer-token-info: false
```

## How to setup app authorization with Spotify API:

1. Enter Spotify Developer Dashboard: https://developer.spotify.com/dashboard/
2. Create new app
3. Copy `client_id` and `client_secret` which you can use in spring boot app (paste them into `application.yml`)
4. In Dashboard open `Edit settings` and add proper `redirect_url` (in our case: `http://localhost:8081/callback`)
5. In `application.yml` replace `USER_INFO_URI` with value `https://api.spotify.com/v1/me`
6. In `application.yml` replace `TOKEN_INFO_URI` with value `https://accounts.spotify.com/api/token`

## How to obtain access token using Spotify API:

To obtain access token:

Obtain authorization code by making GET request to: `https://accounts.spotify.com/authorize` with following request params:
- `client_id`: `CLIENT_ID` (from Spotify Dashboard)
- `response_type`: `code`
- `redirect_uri`: `http://localhost:8081/callback`

Example request:
`https://accounts.spotify.com/authorize?client_id=CLIENT_ID_HERE&response_type=code&redirect_uri=http://localhost:8081/callback`


Copy returned authorization code (we will use it in a moment).


Obtain access token by making POST request to `https://accounts.spotify.com/api/token` with following request body in `x-www-form-urlencoded` format:
- `grant_type`: `authorization_code`
- `code`: `YOUR_CODE_HERE` (returned authorization code from step 2)
- `redirect_uri`: `http://localhost:8081/callback`

You have to also add header:
`Authorization`: `Basic <BASE_64_ENCODED client_id:client_secret>`

Example header value: `Basic YjkwODE3MzI2MjA5NGQyZGIxZGIxNDhmYzk0YmU2YzI6YWIyNjNiOWZmZDEzNDFiODk2NjJkMDhiMzIyMWExOWE=`
