*우선순위 판단
이번 프로젝트에서는 아이디와 비밀번호의 보안 및 안전성 강화가 최우선 과제라고 판단하였습니다. 우선적으로 개선이 필요한 부분에 집중하기 위해 valid credential을 사용하는 positive 테스트는 이번 단계에서 제외하고, 사용자 접근의 기본이 되는 로그인 기능에 대해 negative 테스트 케이스를 먼저 작성하고 실행하였습니다.
해당 기능이 정상적으로 작동하지 않으면 전체 서비스 이용이 불가하므로, 사용자 인증과 입력값 검증의 정확성을 특히 중점적으로 확인하였습니다.

*작업 결과
작성한 테스트 케이스는 아래 세 가지 중심으로 구성되었습니다:

1. 잘못된 자격 증명(invalid credential) 로그인

2. 이메일 ID 오류 / 비밀번호 오류

3. 미입력

* 실행 방법
테스트 자동화 스크립트는 Selenium과 JUnit 기반으로 작성되었으며, IDE에서 mvn test 명령어로 실행 가능합니다.


*발견 이슈
버그: 이메일 ID의 특수 문자 및 규칙 불명확(특히 @ 기호 전후)

설명:
이메일 ID의 로컬 파트( @ 기호 앞)에서 허용되는 특수 문자가 명확하지 않습니다. 현재는 밑줄(_), 대시(-), 점(.)만 허용되고 있는데(예: user_nodot@domain), 이메일 표준에서 인정하는 다른 특수문자까지의 범위와 명확성이 부족합니다.
RFC 5322에 따르면, 로컬 파트에는 문자와 숫자, 그리고 다음의 특수문자가 포함될 수 있습니다:
! # $ % & ' * + - / = ? ^ _ { | } ~ 그리고 점(.)
단, 점(.)은 처음이나 끝에 위치할 수 없으며 연속 사용도 불가합니다.
또한, 현 시스템은 도메인 파트(@ 이후)에서 점(.)이 없는 도메인(ex: user@domaincom)도 허용하는데, 이는 표준에 부합하지 않으며 일부 이메일 제공자만 지원하는 방식입니다.
이러한 불명확성은 사용자 혼란과 입력 일관성 저하를 초래할 수 있습니다.

기대사항:
로컬 파트와 도메인 파트의 허용 문자와 형식 규칙을 명확하게 정의할 것

도메인 부분에는 최소 한 개 이상의 점(.) 포함을 필수로 안내하거나 강제할 것

이메일 각 파트에 대해 일관된 에러 메시지와 입력 안내를 제공할 것



*** Negative Test Scenarios for Login Credentials ***

email:
1. invalid domain but format has @ and .
2. invalid email (double @), valid password format
3. missing '.' in domain (invalid format)
4. double dot in domain (invalid format)
5. empty email, valid password
   
password:
1. too short
2. only letters (letters only, no numbers or special chars)
3. 123456789012345678901 (too long)
4. no special characters
5. no numbers
6. contains whitespace





다음 단계
다음 테스트에서는 유효한 자격 증명(valid credential)으로 각 프로그램 모듈에 대한 접근 권한이 정상적으로 부여되는지를 확인할 예정입니다.
이를 통해 사용자가 권한 없는 모듈에 접근하지 못하고, 필요한 권한이 있을 시 정상적으로 접근이 가능한지를 검증할 계획입니다.
