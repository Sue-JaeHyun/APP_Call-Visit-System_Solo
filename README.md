## 프로젝트명
```c
Call-Visit-System : 군 내 현재 만연하고 있고 꺼내기 싫어하는 판도라의 상자와 같은 병력관리 문제점을 보완하는
                    기능들을 가진 병력관리 서비스앱
                    (출타자 현황관리, 추적관리, 상향식 일일결산, 마음의 편지 기능 보유)
                    
개발자 : 중위 서재현
기획의도 : 과연 중대장님은 우리 중대에 몇 명이 휴가나갔는지 아실까?, 오늘 몇 명 복귀하는지 아실까?
          군대에서 제일 중요하다는 인원 장비 중 인원에 대한 확실히 통제하고 있다고
          자신하는 지휘관이 몇 명이나 있을까?
          용사들은 제대로 된 소통창구가 존재할까?  
          이런 상황에서 장병 간 소통강화를 위해 제작하기 시작했습니다.
        
```
## 실행장면
```c
1. 로그인 화면
```
![로그인](https://user-images.githubusercontent.com/44388935/67486868-cb29db00-f6a7-11e9-8089-878ce1b1fb51.PNG)

```c
2. 가입화면(용사와 간부 나눠서 가입 / 직속상관명 정확히 기입)
```
![가입](https://user-images.githubusercontent.com/44388935/67486920-e85ea980-f6a7-11e9-8cf8-d6f3e3bbc225.PNG)

```c
3. 본인 정보
```
![정보](https://user-images.githubusercontent.com/44388935/67487280-9b2f0780-f6a8-11e9-8ee7-42ceb7392a72.PNG)

```c
4. 상황,위치 보고(용사) - 직속상관밖에 볼 수 없으며 Call-Visit 뿐 아니라 상향식 일일결산, 마음의 편지로
                         응용까지 가능하다. 위치버튼을 누르면 현재 위치의 GPS를 확인해 위도,경도가 출력된다.
```
![상황,위치보고(용사)](https://user-images.githubusercontent.com/44388935/67487152-658a1e80-f6a8-11e9-8c37-899a21bce1c7.PNG)

```c
5. 상황,위치 보고(간부) - 병력들의 보고현황이 들어오고 병력상태에 따라 색상이 달라진다.
```
![상황,위치보고](https://user-images.githubusercontent.com/44388935/67487207-7d61a280-f6a8-11e9-8198-64c8c1486147.PNG)

```c
6. 콜비짓 현황 관리 - 병력들로부터 마지막으로 콜비짓한 시간이 전송되고. 콜비짓을 미실시 했을 경우 전화버튼을
                     누르면 미실시한 병력한테 전화가 걸린다.
```
![콜비짓현황](https://user-images.githubusercontent.com/44388935/67487330-b1d55e80-f6a8-11e9-91b0-c350e13a1a9b.PNG)

```c
7. 출타자 관리 - 출타자 상태를 추가하고 제거할 수 있으며, 병력 상태에 따라 색상을 부여한다.
```
![출타자 관리](https://user-images.githubusercontent.com/44388935/67487310-a7b36000-f6a8-11e9-9dc8-77b083d0ffb1.PNG)

```c
8. 위치조회 - 4,5번에서 확인한 병력 위치를 검색하면 지도상에 표기된다. 위수지역을 이탈했는지 안했는지 확인가능하고, 
             복귀까지 소요되는 시간을 계산가능하다.
```
![위치 조회](https://user-images.githubusercontent.com/44388935/67487238-8c485500-f6a8-11e9-9a74-b80b96c986a3.PNG)


## Prerequisites(컴퓨터 구성 필수 조건 안내)
```c
android 9(API 28) 이상 권장
```
## Installing the Source(설치안내)
```c
App 설치는 위 첨부된 Apk파일을 다운받으시면 됩니다.
혹 Clone 하셔서 직접 Apk를 만드시는 방법도 있습니다.
```

## Getting Started(사용법)
```c
실행장면에 주요기능 반영하였습니다.
App 세부 사용방법은 위 첨부된 ppt를 참조하세요.
```

## File Manifest(파일정보 및 목록)

* Activity
  * LoginActivity             (로그인 화면 액티비티)
  * MainActivity              (메인 화면 액티비티)
  * RegistActivity            (회원등록 액티비티)
  * SearchActivity            (위치조사 액티비티)
* Adaptor
  * CallvisitListAdaptor      (출타자 현황 리스트)
  * MemberListAdaptor         (전체 회원 리스트)
  * OutsiderManagementAdaptor (출타자 관리 리스트)
  * ReportListAdaptor         (상황,위치보고 목록)
* Fragment
  * CallVisitFragment         (출타자 현황 프레그먼트)
  * MyinfoFragment            (내정보 프레그먼트)
  * OutsiderManagementFragment(출타자 관리 프레그먼트)
  * ReportFragment            (상황,위치 보고 프레그먼트)
  * SearchFragment            (위치조사 프레그먼트)
  
## Copyrght / End User License(저작권 및 사용권 정보)
```c
mit license
```
## Contact Information(배포자 및 개발자의 연락처 정보)
```c
github ID : Sue-JaeHyun / 010-2275-3556 / aroa96@naver.com
```
## Known Issues(알려진 버그 & 보완 사항)
```c
오픈소스 아카데미 취지에 맞게 회원관리가 보안성에 취약, 상용화 되기 위해서는 otp를 이용하거나 기타 방식 고려 필요.
```
## Troubleshooting(문제발생에 대한 해결책)
```c
Creating an issue on Github
send me an email(aroa96@naver.com)
```
## Credit(크레딧)
* 개발자
  * 중위 서재현
* Thanks to 국방부 오픈소스 아카데미

## Change Log(업데이트 정보)
```c
ver 1.6(UI & Debug)
```
