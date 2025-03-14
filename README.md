# java-calculator-precourse
## 기능 요구 사항 정리

1. 쉼표 or 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 각 숫자를 분리하고 각 숫자의 합을 반환한다.
2. 그 외 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n”사이에 위치하는 문자이다.
3. 그 외 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### Feat1: CalculatorController의 전체 흐름

1. InputView를 통해 문자열을 받는다.
2. 문자열을 Extractor로 전달해 전체 구분자 집합(기본 구분자 + 커스텀 구분자)을 판단하고, 이를 기반으로 숫자를 골라내 Storage에 저장한다.
3. Validator를 통해 초기 문자열 및 Storage에 저장된 숫자를 검증한다. 검증에 실패했다면 `IllegaArgumentException` 을 발생시키고 애플리케이션을 종료한다.
4. 검증을 통과했다면 Calculator를 통해 Storage에 저장된 숫자를 모두 더한다.
5. OutputView로 연산 결과를 전달해, 출력 포맷을 완성시킨 후 콘솔에 출력한다.

### Feat2: InputView 및 OutputView

- InputView
    - 콘솔에 출력할 문자열을 상수로 선언한다.
    - 입력받은 문자열을 Controller 레이어로 반환한다.
- OutputView
    - 콘솔에 출력할 문자열 포맷을 상수로 선언한다.
    - Calculator로부터 전달받은 연산 결과를 통해 문자열을 완성시켜 콘솔에 출력한다.

### Feat3: Storage

- 이름 그대로 저장소 역할이다.
- 무엇을?
    - 허용된 구분자 집합
    - 허용된 구분자로 split한 숫자 집합

### Feat4: Extractor

1. 커스텀 구분자는 여러개 존재할 수 있다고 가정하고 while문을 통해 커스텀 구분자를 모두 뽑아 Storage에 저장한다. 이 때 커스텀 구분자에 대한 검증이 필요하다.
    1. 커스텀 구분자 선언부는 존재하지만 구분자가 없는 경우(공백인 경우)
    2. 커스텀 구분자 구문이 틀린 경우(”//”으로 시작했지만 ”\n”이 존재하지 않는 경우)
2. 허용 가능한 모든 구분자를 모두 포함하는 정규 표현식 문자열을 생성한다.
3. 해당 정규 표현식을 기반으로 문자열을 split해, 숫자가 될 가능성이 존재하는 부분 문자열을 뽑아내어 Storage에 저장한다. 

### Feat5: Validator

다음의 경우에 대해서 유효성을 검증한다.

1. 문자열이 숫자로 시작하지 않는데, 커스텀 구분자 선언부로 시작하지 않는 경우(공백 제외)
    1. “+2…”
2. Storage에 저장된 숫자가 될 가능성이 있는 문자열들을 정규 표현식으로 탐색, 숫자가 아닌 경우
3. 음수가 등장한 경우

유효성 검증에 실패하면  `IllegalArgumentException` 응답

### Feat6: Calculator

1. Calculator는 Extractor로부터 숫자 모음을 받아온다.
2. 더하기 연산을 수행한다.
3. OutputView로 결과를 전송한다.

### 더 생각해볼 점

- Validator 구현에서, 사용자가 잘못된 값을 입력했다고 판단하는 조건이 더 있을지 생각해봐야 한다.

### 스스로의 판단으로 구현한 부분

- “//~\n//@\n” 처럼 커스텀 구분자가 여러 개 있는 경우는?
    - 정상 입력
    - 커스텀 구분자를 여러개로 인식한다.