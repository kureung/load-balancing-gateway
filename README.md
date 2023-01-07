
# [English version]
A gateway capable of load balancing.

If you send the load balancing setting to the gateway as a request value, it is applied in real time.

The default port is `7777`.

<br>

## How to use
``` json
POST http://localhost:7777/routers
Content-Type: application/json

{
  "routers" : [
    {
      "weight" : 7,
      "url" : "http://localhost:8070"
    },
    {
      "weight" : 3,
      "url" : "http://localhost:8090"
    }
  ]
}
```
`http` request form. The first time you run the gateway, the above request has been applied.

When using the gateway, first send a request to `POST http://localhost:7777/routers` as desired by the user.
You must set it up. Otherwise, the HTTP form above will be applied and the desired load balancing will not be possible.

The larger the `weight` value, the more traffic the server will have. The sum of the values of `weight` doesn't have to be `10`.

For example, if the gateway server receives 100 requests for `GET http://localhost:7777/hello`, 70 requests for `GET http://localhost:8070/hello` and 30 requests for `GET http://localhost:8090/hello`.

<br>

### Precautions
When sending a request to the gateway to change the load balancing setting, there should be no duplicate `url` value in the http request `routers`.

<br>
<br>



# [Korean version]
부하 분산 처리가 가능한 게이트 웨이입니다.

게이트 웨이에 부하 분산 설정을 요청값으로 보내면 실시간으로 적용됩니다.

기본 포트는 `7777` 입니다.

<br>

## 사용 방법
``` json
POST http://localhost:7777/routers
Content-Type: application/json

{
  "routers" : [
    {
      "weight" : 7,
      "url" : "http://localhost:8070"
    },
    {
      "weight" : 3,
      "url" : "http://localhost:8090"
    }
  ]
}
```
`http` 요청 양식입니다. 처음 해당 게이트 웨이를 실행 시킬 때, 위의 요청이 적용되어 있습니다.

게이트 웨이를 사용할 때 먼저 `POST http://localhost:7777/routers` 에 요청을 보내서 사용자가 원하는대로
설정해야합니다. 그렇지 않으면 위 HTTP 양식이 적용되어 있어서 원하는 로드 밸런싱이 가능하지 않습니다.

`weight` 값이 클수록 해당 서버에 트래픽이 많이 가게 됩니다. `weight`의 값들의 합이 `10`이 아니여도 됩니다.

예를 들어서 게이트 웨이 서버에 `GET http://localhost:7777/hello` 요청이 100번 올 경우 `GET http://localhost:8070/hello` 에 70번, `GET http://localhost:8090/hello` 에 30번 요청이 갑니다.



<br>

### 주의 사항
부하 분산 설정을 바꾸기 위해서 게이트 웨이에 요청을 보낼 때 http 요청인 `routers`안에 `url` 값의 중복이 있으면 안됩니다.











